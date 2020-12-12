package com.vokabeltrainer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import com.vokabeltrainer.model.Thema;
import com.vokabeltrainer.model.Vokabel;
import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.TrainingsView;

import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class TrainingsControllerTest {
	
	private Stage mockStage;
	private VokabelModel mockModel;
	private TrainingsView mockView;
	private TrainingsController controller;
	
	private int eingabeUngueltig, antwortAngezeigt, nextVokabel, beenden;
	private Boolean richtigeAntwort;
	private boolean overrideBeenden;
	
	@Start
	public void start(Stage stage) {
		mockStage = stage;
		eingabeUngueltig = 0;
		antwortAngezeigt = 0;
		nextVokabel = 0;
		beenden = 0;
		richtigeAntwort = null;
		overrideBeenden = true;
		mockModel = new VokabelModel();
		mockModel.getAktuelleVokabeln().addAll(Thema.dateiEinlesen("/com/vokabeltrainer/Animals-short.txt", false));
		mockModel.setSprache("Englisch");
		mockModel.setRichtungUmkehren(false);
		mockModel.setIndex(0);
		mockModel.setCountGesamt(0);
		mockModel.setCountKorrekt(0);
		mockModel.getFalscheVokabeln().clear();
		mockView = new TrainingsView(false, mockModel, (eingabe) -> {},() -> {}, () -> {}) {
			@Override
			public void eingabeUngueltig() {
				eingabeUngueltig++;
			}
			
			@Override
			public void antwortAnzeigen(boolean richtig) {
				richtigeAntwort = richtig;
				antwortAngezeigt++;
			}
			
			@Override
			public void nextVokabel() {
				nextVokabel++;
			}
		};
		nextVokabel--;
		controller = new TrainingsController(mockModel, mockStage) {
			@Override
			protected TrainingsView createView() {
				return mockView;
			}
			
			@Override
			void beenden() {
				if(overrideBeenden) beenden++;
				else super.beenden();
			}
		};
		
	}
	
	 @Test
	 public void testBestaetigen() {
		 assertEquals(0, mockModel.getCountGesamt());
		 assertEquals(0, mockModel.getCountKorrekt());
		 assertEquals(0, mockModel.getIndex());
		 assertEquals(0, eingabeUngueltig);
		 
		 controller.bestaetigen("0");
		 
		 assertEquals(0, mockModel.getCountGesamt());
		 assertEquals(0, mockModel.getCountKorrekt());
		 assertEquals(0, mockModel.getIndex());
		 assertEquals(1, eingabeUngueltig);
		 
		 controller.bestaetigen("fish");
		 
		 assertEquals(1, mockModel.getCountGesamt());
		 assertEquals(1, mockModel.getCountKorrekt());
		 assertEquals(1, mockModel.getIndex());
		 assertEquals(1, antwortAngezeigt);
		 assertEquals(1, eingabeUngueltig);
		 assertTrue(mockModel.getFalscheVokabeln().isEmpty());
		 assertTrue(richtigeAntwort);
		 
		 controller.bestaetigen("bla");

		 assertEquals(2, mockModel.getCountGesamt());
		 assertEquals(1, mockModel.getCountKorrekt());
		 assertEquals(2, mockModel.getIndex());
		 assertEquals(2, antwortAngezeigt);
		 assertTrue(mockModel.getFalscheVokabeln().contains(mockModel.getAktuelleVokabeln().get(1)));
		 assertFalse(richtigeAntwort);
	 }
	 
	 @Test
	 public void testWeiter() {
		 List<Vokabel> aktuell = mockModel.getAktuelleVokabeln(), falsch = mockModel.getFalscheVokabeln();
		 
		 assertEquals(0, nextVokabel);
		 
		 controller.weiter();
		 
		 assertEquals(1, nextVokabel);
		 assertEquals(0, beenden);
		 
		 Vokabel v = aktuell.get(0);
		 aktuell.clear();
		 
		 controller.weiter();
		 
		 assertEquals(1, nextVokabel);
		 assertEquals(1, beenden);
		 
		 falsch.add(v);
		 
		 controller.weiter();
		 
		 assertTrue(aktuell.contains(v));
		 assertEquals(1, aktuell.size());
		 assertEquals(0, mockModel.getIndex());
		 assertTrue(falsch.isEmpty());
	 }
	 
		@Test
		public void testNeustart(FxRobot robo) {
			overrideBeenden = false;
			assertSame(controller.view.getScene(), mockStage.getScene());
			robo.interact(() -> controller.beenden());
			// Testet dass TrainginsView von der Stage entfernt wurde
			assertNotSame(controller.view.getScene(), mockStage.getScene());
		}
}

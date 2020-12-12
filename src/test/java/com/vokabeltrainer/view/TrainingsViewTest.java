package com.vokabeltrainer.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import com.vokabeltrainer.model.Thema;
import com.vokabeltrainer.model.VokabelModel;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class TrainingsViewTest {
	
	private VokabelModel model;
	private TrainingsView view;
	private int bestaetigt, weiter, beenden;
	private String letzteEingabe;

	@Start
	public void start(Stage stage) {
		bestaetigt = 0;
		weiter = 0;
		beenden = 0;
		letzteEingabe = null;
		model = new VokabelModel();
		model.getAktuelleVokabeln().addAll(Thema.dateiEinlesen("/com/vokabeltrainer/Animals-short.txt", false));
		model.setSprache("Englisch");
		model.setRichtungUmkehren(false);
		model.setIndex(0);
		view = new TrainingsView(false, model, (eingabe) -> {letzteEingabe = eingabe; bestaetigt++;},() -> weiter++, () -> beenden++);
		view.showOn(stage);
		stage.show();
	}
	
	@Test
	public void testNextVokabel(FxRobot robo) {
		Text frage = robo.lookup("#frage").queryText();
		
		assertEquals("Was heisst 'Fisch' auf Englisch?", frage.getText());
		model.setIndex(1);
		
		model.setRichtungUmkehren(true);
		view.nextVokabel();

		assertEquals("Was heisst 'Hund' auf Deutsch?", frage.getText());
	}
	
	@Test
	public void antwortAnzeigen(FxRobot robo) {
		view.antwortAnzeigen(false);
		Text antwort = robo.lookup("#loesung").queryText();
		Text eingabe = robo.lookup("#gepruefteEingabe").queryText();
		assertTrue(antwort.isVisible());
		assertEquals("Die richtige Lösung ist 'fish'.", antwort.getText());
		assertEquals("Ihre Antwort ist falsch.", eingabe.getText());
		
		view.antwortAnzeigen(true);
		assertFalse(antwort.isVisible());
		assertEquals("Ihre Antwort ist richtig.", eingabe.getText());
	}
	
	@Test
	public void testEingabeUngueltig(FxRobot robo) {
		view.eingabeUngueltig();
		assertEquals("Die Eingabe ist ungültig!", robo.lookup("#gepruefteEingabe").queryText().getText());
	}
	
	@Test
	public void testButtons(FxRobot robo) {
		Button bestaetigenButton = robo.lookup("#bestaetigenButton").queryButton();
		Button weiterButton = robo.lookup("#weiterButton").queryButton();
		Button beendenButton = robo.lookup("#beendenButton").queryButton();
		TextField eingabe = (TextField) robo.lookup("#antwort").queryTextInputControl();
		
		assertEquals(0, bestaetigt);
		
		robo.clickOn(eingabe);
		robo.write("bla");
		robo.clickOn(bestaetigenButton);
		
		assertEquals(1, bestaetigt);
		assertEquals(0, weiter);
		assertEquals("bla", letzteEingabe);
		
		view.antwortAnzeigen(false);
		
		robo.clickOn(weiterButton);
		assertEquals(1, weiter);
		assertEquals(0, beenden);
		robo.clickOn(beendenButton);
		
		assertEquals(1, weiter);
		assertEquals(1, beenden);
	}
}

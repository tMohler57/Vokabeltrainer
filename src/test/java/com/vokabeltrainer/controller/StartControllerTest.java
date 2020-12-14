package com.vokabeltrainer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import com.vokabeltrainer.model.Thema;
import com.vokabeltrainer.model.Vokabel;
import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.StartView;

import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class StartControllerTest {
	
	private Stage mockStage;
	private VokabelModel mockModel;
	private StartView mockView;
	private StartController controller;
	
	private Thema thema;
	private String sprache;
	private Boolean umkehren;
	
	private int enableCalled;
	private Boolean lastEnabled;
	private int dateiGeladen;

	@Start
	public void start(Stage stage) {
		mockStage = stage;
		mockModel = new VokabelModel() {
			
			@Override
			public void ladeDatei() {
				getAktuelleVokabeln().add(new Vokabel("Der Test", "Le Unit-Test"));
				dateiGeladen++;
			}
		};
		mockModel.setSprache("Englisch");
		mockView = new StartView(mockModel, () -> {}, () -> {}) {
			
			@Override
			public Thema getThema() {
				return thema;
			}
			
			@Override
			public String getSprache() {
				return sprache;
			}
			
			@Override
			public Boolean isRichtungUmkehren() {
				return umkehren;
			}
			
			@Override
			public void enableStartButton(boolean enabled) {
				enableCalled++;
				lastEnabled = enabled;
			}
		};
		controller = new StartController(mockModel, stage) {
			
			@Override
			protected StartView createView() {
				return mockView;
			}
			
		};
		enableCalled = 0;
		lastEnabled = null;
		dateiGeladen = 0;
	}
	
	@Test
	public void testConstructor(FxRobot robo) {
		robo.interact(() -> controller = new StartController(mockModel, mockStage));
		assertTrue(controller.view instanceof StartView);
	}
	
	@Test
	public void testDropdown() {
		thema = Thema.Tiere;
		sprache = "Französisch";
		umkehren = null;
		controller.dropdown();
		assertSame(thema, mockModel.getThema());
		assertSame(sprache, mockModel.getSprache());
		assertNull(mockModel.isRichtungUmkehren());
		assertEquals(1, enableCalled);
		assertFalse(lastEnabled);
		
		umkehren = true;
		controller.dropdown();
		assertTrue(mockModel.isRichtungUmkehren());
		assertEquals(2, enableCalled);
		assertTrue(lastEnabled);
		
		assertEquals(0, dateiGeladen);
	}
	
	@Test
	public void testWeiter(FxRobot robo) {
		assertSame(mockView.getScene(), mockStage.getScene());
		robo.interact(() -> controller.weiter());
		assertEquals(1, dateiGeladen);
		// Testet das StartView von der Stage entfernt wurde
		assertNotSame(mockView.getScene(), mockStage.getScene());
	}
}

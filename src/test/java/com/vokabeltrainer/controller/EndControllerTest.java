package com.vokabeltrainer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.EndView;

import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class EndControllerTest {
	
	private Stage mockStage;
	private VokabelModel mockModel;
	private EndController controller;
	
	@Start
	public void start(Stage stage) {
		mockStage = stage;
		mockModel = new VokabelModel();
		mockModel.setCountGesamt(30);
		mockModel.setCountKorrekt(21);
		controller = new EndController(mockModel, mockStage);
		controller.view.showOn(mockStage);
		mockStage.show();
	}
	
	@Test
	public void testConstructor(FxRobot robo) {
		assertTrue(controller.view instanceof EndView);
		assertEquals("Herzlichen Glückwunsch!", robo.lookup("#glueckwunschAusgabe").queryText().getText());
	}
	
	@Test
	public void testNeustart(FxRobot robo) {
		assertSame(controller.view.getScene(), mockStage.getScene());
		robo.interact(() -> controller.programmNeustarten());
		// Testet dass EndView von der Stage entfernt wurde
		assertNotSame(controller.view.getScene(), mockStage.getScene());
	}
	
}

package com.vokabeltrainer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import com.vokabeltrainer.model.Vokabel;
import com.vokabeltrainer.model.VokabelModel;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class StartControllerTest {
	
	private VokabelModel model;
	private int gestartet;

	@Start
	public void start(Stage stage) {
		model = new VokabelModel();
		gestartet = 0;
		new StartController(model, stage) {
			@Override
			void weiter() {
				model.ladeDatei();
				gestartet++;
			}
		};
		stage.show();
	}
	
	@Test
	public void test(FxRobot robo) {
		Button startButton = robo.lookup("#startButton").queryButton();
		selectFromDropdown(robo, "#themaDropdown", "Tourismus");
		assertFalse(startButton.isVisible());
		selectFromDropdown(robo, "#spracheDropdown", "Englisch");
		assertFalse(startButton.isVisible());
		selectFromDropdown(robo, "#richtungDropdown", "Deutsch -> Fremdsprache");
		assertTrue(startButton.isVisible());
		selectFromDropdown(robo, "#themaDropdown", "Tiere");
		selectFromDropdown(robo, "#spracheDropdown", "Französisch");
		assertTrue(startButton.isVisible());
		assertEquals(0, gestartet);
		robo.clickOn(startButton);
		assertEquals(1, gestartet);
		assertTrue(0 < model.getAktuelleVokabeln().size());
		assertEquals("Französisch", model.getSprache());
		Vokabel v = model.getAktuelleVokabeln().get(0);
		assertEquals("der Fisch", v.getVokabel());
		assertEquals("le poisson", v.getUebersetzung());
	}
	
	// https://stackoverflow.com/questions/3369794/how-to-read-a-file-from-jar-in-java#3370096
	private void selectFromDropdown(FxRobot robo, String comboBoxId, String itemToSelect) {
	    ComboBox<String> actualComboBox = robo.lookup(comboBoxId).queryComboBox();
	    for (Node child : actualComboBox.getChildrenUnmodifiable()) {
	        if (child.getStyleClass().contains("arrow-button")) {
	            Node arrowRegion = ((Pane) child).getChildren().get(0);
	            robo.clickOn(arrowRegion);
	            sleep(100);
	            robo.clickOn(itemToSelect);
	            return;
	        }
	    }
	    fail("Couldn't find an arrow-button.");
	}
	
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException iexc) {
			throw new RuntimeException(iexc);
		}
	}
}

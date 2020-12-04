package com.vokabeltrainer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class StartbildschirmTest {
	
	private SetVokabeln wörtli;

	@Start
	public void start(Stage stage) {
		wörtli = null;
		Startbildschirm startbildschirm = new Startbildschirm(wörtli -> this.wörtli = wörtli);
		stage.setScene(startbildschirm.getScene());
		stage.show();
	}
	
	@Test
	public void test(FxRobot robo) {
		Button startButton = robo.lookup("#startButton").queryButton();
		selectFromDropdown(robo, "#themaDropdown", "Tourismus");
		assertFalse(startButton.isVisible());
		selectFromDropdown(robo, "#spracheDropdown", "Englisch");
		assertTrue(startButton.isVisible());
		selectFromDropdown(robo, "#themaDropdown", "Tiere");
		selectFromDropdown(robo, "#spracheDropdown", "Französisch");
		assertTrue(startButton.isVisible());
		robo.clickOn(startButton);
		assertNotNull(wörtli);
		assertEquals("Französisch", wörtli.getSprache());
		Vokabel v = wörtli.getWort().get(0);
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

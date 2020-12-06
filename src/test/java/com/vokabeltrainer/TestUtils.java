package com.vokabeltrainer;

import static org.junit.jupiter.api.Assertions.fail;

import org.testfx.api.FxRobot;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public final class TestUtils {
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException iexc) {
			throw new RuntimeException(iexc);
		}
	}
	
	// https://stackoverflow.com/questions/3369794/how-to-read-a-file-from-jar-in-java#3370096
	public static void selectFromDropdown(FxRobot robo, String comboBoxId, String itemToSelect) {
	    ComboBox<String> actualComboBox = robo.lookup(comboBoxId).queryComboBox();
	    for (Node child : actualComboBox.getChildrenUnmodifiable()) {
	        if (child.getStyleClass().contains("arrow-button")) {
	            Node arrowRegion = ((Pane) child).getChildren().get(0);
	            robo.clickOn(arrowRegion);
	            TestUtils.sleep(100);
	            robo.clickOn(itemToSelect);
	            return;
	        }
	    }
	    fail("Couldn't find an arrow-button.");
	}

	private TestUtils() {}
}

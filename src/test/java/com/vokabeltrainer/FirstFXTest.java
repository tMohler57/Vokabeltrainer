package com.vokabeltrainer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class FirstFXTest {
	
	@Start
	public void start(Stage stage) {
		Button button = new Button("click");
		button.setId("firstButton");
		button.setOnAction(actionEvent -> button.setText("pressed"));
		stage.setScene(new Scene(new StackPane(button), 100, 100));
		stage.show();
	}
	
	@Test
	public void test(FxRobot robo) {
		Button button = robo.lookup("#firstButton").queryButton();
		assertEquals("click", button.getText());
		robo.clickOn(button);
		assertEquals("pressed", button.getText());
	}

}

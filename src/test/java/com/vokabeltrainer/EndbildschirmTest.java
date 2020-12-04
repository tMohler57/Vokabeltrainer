package com.vokabeltrainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.control.Button;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class EndbildschirmTest {

	int wurdeBenutzt;

	@Start
	public void start(Stage stage) {
		wurdeBenutzt = 0;
		Endbildschirm endbildschirm = new Endbildschirm(5, 30, event -> {
			wurdeBenutzt++;
		});

		stage.setScene(endbildschirm.getScene());
		stage.show();
	}

	@Test
	public void test(FxRobot robo) {
		assertEquals("Sie haben 5 von 30 Vokabeln richtig übersetzt.",
				robo.lookup("#countAusgabe").queryText().getText());
		assertEquals("Damit haben Sie eine Erfolgsquote von 16.67%",
				robo.lookup("#feedbackAusgabe").queryText().getText());
		Button beenden = robo.lookup("#beendenButton").queryButton();
		assertEquals(0, wurdeBenutzt);
		robo.clickOn(beenden);
		assertEquals(1, wurdeBenutzt);
	}
}

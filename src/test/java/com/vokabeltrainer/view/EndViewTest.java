package com.vokabeltrainer.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import com.vokabeltrainer.model.VokabelModel;

import javafx.scene.control.Button;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class EndViewTest {
	
	private EndView view;
	private int beendet;
	private int weiter;
	
	@Start
	public void start(Stage stage) {
		beendet = 0;
		weiter = 0;
		VokabelModel model = new VokabelModel();
		model.setCountGesamt(30);
		model.setCountKorrekt(5);
		view = new EndView(model, () -> beendet++, () -> weiter++);
		view.showOn(stage);
		stage.show();
	}
	
	@Test
	public void test(FxRobot robo) {
		assertEquals(0, beendet);
		assertEquals("Sie haben 5 von 30 Vokabeln richtig übersetzt.",
				robo.lookup("#countAusgabe").queryText().getText());
		assertEquals("Damit haben Sie eine Erfolgsquote von 16.67%",
				robo.lookup("#feedbackAusgabe").queryText().getText());
		Button beenden = robo.lookup("#beendenButton").queryButton();
		assertNotNull(beenden);
		robo.clickOn(beenden);
		assertEquals(1, beendet);
	}

}

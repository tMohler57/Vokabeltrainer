package com.vokabeltrainer.view;

import static com.vokabeltrainer.TestUtils.selectFromDropdown;
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
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class StartViewTest {
	
	private StartView view;
	private int gestartet;
	private int dropdownBenutzt;

	@Start
	public void start(Stage stage) {
		gestartet = 0;
		dropdownBenutzt = 0;
		view = new StartView(new VokabelModel(), () -> gestartet++, () -> dropdownBenutzt++);
		view.showOn(stage);
		stage.show();
	}
	
	@Test
	public void testDropdowns(FxRobot robo) {
		assertEquals(0, gestartet);
		assertEquals(0, dropdownBenutzt);
		
		selectFromDropdown(robo, "#themaDropdown", "Tourismus");
		assertEquals(Thema.Tourismus, view.getThema());
		assertEquals(1, dropdownBenutzt);
		
		selectFromDropdown(robo, "#spracheDropdown", "Englisch");
		assertEquals("Englisch", view.getSprache());
		assertEquals(2, dropdownBenutzt);
		
		selectFromDropdown(robo, "#richtungDropdown", "Fremdsprache -> Deutsch");
		assertEquals(true, view.isRichtungUmkehren());
		assertEquals(3, dropdownBenutzt);
		
		assertEquals(0, gestartet);
	}
	
	@Test
	public void testButton(FxRobot robo) {
		assertEquals(0, dropdownBenutzt);
		Button startButton = robo.lookup("#startButton").queryButton();
		
		assertFalse(startButton.isVisible());
		view.enableStartButton(true);
		assertTrue(startButton.isVisible());
		
		assertEquals(0, gestartet);
		robo.clickOn(startButton);
		assertEquals(1, gestartet);

		view.enableStartButton(false);
		assertFalse(startButton.isVisible());
		
		assertEquals(1, gestartet);
		assertEquals(0, dropdownBenutzt);
	}
}
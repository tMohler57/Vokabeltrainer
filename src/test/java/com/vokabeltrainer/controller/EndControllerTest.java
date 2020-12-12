package com.vokabeltrainer.controller;

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
	private EndView mockView;
	private EndController controller;
	
	private Boolean wuenscheEnabled;
	
	@Start
	public void start(Stage stage) {
		mockStage = stage;
		mockModel = new VokabelModel();
		mockModel.setCountGesamt(30);
		mockModel.setCountKorrekt(21);
		mockView = new EndView(mockModel, () -> {}, () -> {});
		
		wuenscheEnabled = null;
				
		controller = new EndController(mockModel, stage) {
			
			@Override
			protected EndView createView() {
				if (model.erfolgsquote() >= 50.00) wuenscheEnabled = true;
				return mockView;
			}
			
		};
		
	}
	
	@Test
	public void testConstructor(FxRobot robo) {
		robo.interact(() -> controller = new EndController(mockModel, mockStage));
		assertTrue(controller.view instanceof EndView);
	}

//	@Test
//	public void testGlueckwuensche(Stage stage) {
//		System.out.println(wuenscheEnabled);
//		assertTrue(wuenscheEnabled);
//	}
	
}

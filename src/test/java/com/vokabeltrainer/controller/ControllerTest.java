package com.vokabeltrainer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.View;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class ControllerTest {
	
	private VokabelModel mockModel;
	private Stage mockStage;
	private Scene mockScene;
	private View mockView;
	
	private Controller<View> controller;
	private int viewCreated;

	@Start
	public void start(Stage stage) {
		mockStage = stage;
		mockModel = new VokabelModel();
		mockScene = new Scene(new HBox(new Text("MockView")));
		mockView = new View(null) {

			@Override
			protected Scene getScene() {
				return mockScene;
			}
		};
		
		viewCreated = 0;
	}
	
	@Test
	public void testConstructor(FxRobot robo) {
		robo.interact(() -> controller = new Controller<>(mockModel, mockStage) {

			@Override
			protected View createView() {
				assertSame(mockModel, model);
				assertSame(mockStage, stage);
				assertNull(view);
				viewCreated++;
				return mockView;
			}
		});
		assertEquals(1, viewCreated);
		assertSame(mockView, controller.view);
		assertSame(mockScene, mockStage.getScene());
		assertEquals("Vokabeltrainer", mockStage.getTitle());
	}
}
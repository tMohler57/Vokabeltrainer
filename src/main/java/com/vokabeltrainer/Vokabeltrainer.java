package com.vokabeltrainer;

import com.vokabeltrainer.controller.StartController;
import com.vokabeltrainer.model.VokabelModel;

import javafx.application.Application;
import javafx.stage.Stage;

public class Vokabeltrainer extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		new StartController(new VokabelModel(), stage);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
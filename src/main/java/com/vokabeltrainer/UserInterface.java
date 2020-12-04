package com.vokabeltrainer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class UserInterface extends Application {

	private Stage stage = null;
	private View start;
	private Trainingsbildschirm training;

	public UserInterface() {
		start = new Startbildschirm((wörtli) -> {
			training.setWoertli(wörtli);
			showView(training);
		});
		training = new Trainingsbildschirm(
				(korrekt, gesamt) -> showView(new Endbildschirm(korrekt, gesamt, beendenButton -> {
					Platform.exit();
					System.exit(0);
				})));

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		showView(start);
		stage.show();

	}

	public void showView(View view) {
		stage.setScene(view.getScene());
		stage.setTitle(view.getTitle());
	}

	public static void main(String[] args) {
		launch(args);
	}
}

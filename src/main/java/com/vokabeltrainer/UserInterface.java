package com.vokabeltrainer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class UserInterface extends Application {
	
	private Stage stage = null;
	private View start, training, kontrolle, ende;
	
	public UserInterface() {
		start = new Startbildschirm(startButton -> showView(training));
		training = new Eingabe(kontrolleButton -> showView(kontrolle));
		kontrolle = new Kontrolle(neueVokabelButton -> showView(training), endButton -> showView(ende));
		ende = new Endbildschirm(beendenButton ->  {
	        Platform.exit();
	        System.exit(0);
	    });
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

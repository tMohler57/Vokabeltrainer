package com.vokabeltrainer;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserInterface extends Application {
	
	private Stage stage = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		
		// controller (sollte später mal ausgelagert werden:
		showView(new Startbildschirm());
		
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

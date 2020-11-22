package com.vokabeltrainer;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserInterface extends Application {
	
	private Stage stage = null;
	private View other, start;
	
	public UserInterface() {
		start = new Startbildschirm(evt -> showView(other));
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

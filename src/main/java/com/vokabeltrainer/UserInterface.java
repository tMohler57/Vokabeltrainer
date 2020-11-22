package com.vokabeltrainer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class UserInterface extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			GridPane gridPane = new GridPane();
			
			Scene scene = new Scene(gridPane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Vokabeltrainer");
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

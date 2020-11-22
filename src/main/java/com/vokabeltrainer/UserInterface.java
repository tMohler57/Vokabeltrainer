package com.vokabeltrainer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class UserInterface extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			GridPane gridPane = new GridPane();			
			gridPane.setPadding(new Insets(20));
		    gridPane.setHgap(25);
		    gridPane.setVgap(15);
		
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

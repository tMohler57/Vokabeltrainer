package com.vokabeltrainer;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Startbildschirm implements View {
	
	private GridPane gridPane = new GridPane();

	public Startbildschirm() {
		Label wilkommen = new Label("Wilkommen zum Vokabletraining!");
		gridPane.add(wilkommen, 2, 3);
	}

	public Scene getScene() {
		return new Scene(gridPane);
	}
	
	
}

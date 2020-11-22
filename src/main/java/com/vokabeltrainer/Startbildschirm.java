package com.vokabeltrainer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Startbildschirm implements View {
	
	private GridPane gridPane = new GridPane();

	public Startbildschirm(EventHandler<ActionEvent> startEvent) {
		Label willkommen = new Label("Willkommen zum Vokabeltraining!");
		
		Button start = new Button("Start");
		start.setOnAction(startEvent);
		
		gridPane.add(willkommen, 2, 3);
		gridPane.add(start, 3, 2);
	}

	public Scene getScene() {
		return new Scene(gridPane);
	}
	
	
}

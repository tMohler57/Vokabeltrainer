package com.vokabeltrainer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Startbildschirm implements View {

	private GridPane gridPane = new GridPane();

	public Startbildschirm(EventHandler<ActionEvent> startEvent) {
		Label willkommen = new Label("Willkommen zum Vokabeltraining!");

		Button start = new Button("Start");
		start.setOnAction(startEvent);
		
		gridPane.setStyle("-fx-background-color: #F7819F");
		
		willkommen.setFont(new Font("Arial", 30));
		
		start.setMinWidth(115);
		start.setMinHeight(50);
		start.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		start.getStyle();

		gridPane.setHgap(10);
		gridPane.setHgap(10);
		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setPercentWidth(10);
		RowConstraints rowConstraints = new RowConstraints();
		rowConstraints.setPercentHeight(20);
		for (int i = 0; i < 10; i++) {
			gridPane.getColumnConstraints().add(columnConstraints);
			gridPane.getRowConstraints().add(rowConstraints);
		}

		gridPane.add(willkommen, 1, 4, 6, 1);
		gridPane.add(start,7, 4);
	}

	public Scene getScene() {	
		return new Scene(gridPane, 1000, 500);
	}


}

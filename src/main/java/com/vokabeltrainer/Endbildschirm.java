package com.vokabeltrainer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class Endbildschirm implements View {
	
	private GridPane gridPane = new GridPane();
	
	public Endbildschirm(EventHandler<ActionEvent> startEvent) {
		Label wiedersehen = new Label("Das Vokabeltraining wurde beendet. Auf Wiedersehen!");
		
		Button beenden = new Button("Programm beenden");
		beenden.setOnAction(startEvent);
		
		gridPane.setStyle("-fx-background-color: #F7819F");
		
		wiedersehen.setFont(new Font("Arial", 26));
		
		beenden.setMinWidth(115);
		beenden.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		beenden.getStyle();

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
		
		gridPane.add(wiedersehen, 1, 4, 7, 1);
		gridPane.add(beenden, 6, 6);
	}

	@Override
	public Scene getScene() {
		
		return new Scene(gridPane, 1000, 500);
	}

}

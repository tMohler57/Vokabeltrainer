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

public class Eingabe implements View{
	
	private final GridPane gridPane = new GridPane();
	private final Scene scene;

	public Eingabe(EventHandler<ActionEvent> startEvent) {
		Label losgehts = new Label("Los gehts. Wir trainieren jetzt Vokabeln!");
		
		Button kontrolle = new Button("Kontrolle");
		kontrolle.setOnAction(startEvent);
		
		gridPane.setStyle("-fx-background-color: #F7819F");
		
		losgehts.setFont(new Font("Arial", 26));
		
		kontrolle.setMinWidth(115);
		kontrolle.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		kontrolle.getStyle();

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
		
		gridPane.add(losgehts, 1, 2, 5, 1);
		gridPane.add(kontrolle, 7, 2);
		scene = new Scene(gridPane, 1000, 500);
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}

}

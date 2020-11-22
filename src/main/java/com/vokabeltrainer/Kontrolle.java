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

public class Kontrolle implements View {
	
	private final GridPane gridPane = new GridPane();
	private final Scene scene;
	
	public Kontrolle(EventHandler<ActionEvent> startEvent, EventHandler<ActionEvent> endEvent) {
		Label loesung = new Label("Dies ist die korrekte Lösung");
		
		Button neueVokabel = new Button("weiter Lernen");
		neueVokabel.setOnAction(startEvent);
		Button ende = new Button("lernen beenden");
		ende.setOnAction(endEvent);
		
		gridPane.setStyle("-fx-background-color: #F7819F");
		
		loesung.setFont(new Font("Arial", 23));
		
		neueVokabel.setMinWidth(115);
		neueVokabel.setMinHeight(50);
		neueVokabel.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		neueVokabel.getStyle();
		
		ende.setMinWidth(115);
		ende.setMinHeight(50);
		ende.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		ende.getStyle();

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
	 
		gridPane.add(loesung, 3, 3, 3, 1);
		gridPane.add(neueVokabel, 3, 7);
		gridPane.add(ende, 5, 7);
		
		scene = new Scene(gridPane, 1000, 500);
	}

	@Override
	public Scene getScene() {

		return scene;
	}

}

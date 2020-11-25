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
import javafx.scene.text.Text;

public class Startbildschirm implements View {

	private GridPane gridPane = new GridPane();

	public Startbildschirm(EventHandler<ActionEvent> startEvent) {
		Text willkommen = new Text("Willkommen zum Vokabeltraining!");

		Button start = new Button("Start");
		start.setOnAction(startEvent);
		
		
		
		textStyle(willkommen);		
		buttonStyle(start);
		gridpaneStyle(gridPane);

		gridPane.add(willkommen, 1, 4, 6, 1);
		gridPane.add(start,7, 4);
	}
	
	public void textStyle(Text text) {
		text.setFont(new Font("Arial", 30));
	}
	
	public void buttonStyle(Button button) {
		button.setMinWidth(115);
		button.setMinHeight(50);
		button.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		button.getStyle();
	}
	
	public void gridpaneStyle(GridPane gridPane) {
		gridPane.setStyle("-fx-background-color: #F7819F");
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
	}

	public Scene getScene() {	
		return new Scene(gridPane, 1000, 500);
	}


}

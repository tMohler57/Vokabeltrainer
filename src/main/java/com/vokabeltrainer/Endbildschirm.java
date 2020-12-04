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
import javafx.scene.text.Text;

public class Endbildschirm implements View {
	
	private GridPane gridPane = new GridPane();
	
	public Endbildschirm(int korrekt, int gesamt, EventHandler<ActionEvent> startEvent) {
		Text wiedersehen = new Text("Das Vokabeltraining wurde beendet. Auf Wiedersehen!");
		Text count = new Text();
		Text feedback = new Text();
		Text glueckwunsch = new Text();
		
		double erfolgsquote = ( (double)korrekt / (double)gesamt ) * 100;
		count.setText("Sie haben " + korrekt + " von " + gesamt + " Vokabeln richtig übersetzt.");
		feedback.setText("Damit liegt Ihre Erfolgsquote bei " + String.format("%,.2f", erfolgsquote) + "%.");
		if (erfolgsquote >= 50.00) {
			glueckwunsch.setText("Herzlichen Glückwunsch!");
		}
		
		Button beenden = new Button("Programm beenden");
		beenden.setOnAction(startEvent);
		
		textStyle(wiedersehen);
		textStyle(feedback);
		textStyle(count);
		textStyle(glueckwunsch);
		buttonStyle(beenden);
		beenden.setMinWidth(100);
		gridpaneStyle(gridPane);
		
		gridPane.add(wiedersehen, 1, 2, 7, 1);
		gridPane.add(count, 2, 4, 6, 1);
		gridPane.add(feedback, 2, 5, 6, 1);
		gridPane.add(glueckwunsch, 2, 6, 6, 1);
		gridPane.add(beenden, 6, 7, 3, 1);
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

	@Override
	public Scene getScene() {
		
		return new Scene(gridPane, 1000, 500);
	}

}

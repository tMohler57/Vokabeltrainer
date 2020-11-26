package com.vokabeltrainer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Startbildschirm implements View {

	private GridPane gridPane = new GridPane();
	private String thema = null;

	public Startbildschirm(EventHandler<ActionEvent> startEvent) {
		Text willkommen = new Text("Willkommen zum Vokabeltraining!");
		Button start = new Button("Start");
		start.setOnAction(startEvent);

		Text themaText = new Text("Wählen Sie ein Thema: ");
		ComboBox<String> themaDrop = themaDropdownStyle();
		Button themaButton = new Button("Thema wählen");
		Text fehlermeldung = new Text("");

		themaButton.setOnAction(new EventHandler <ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				if (themaDrop.getValue() != null && !themaDrop.getValue().isEmpty()) {
					setThema(themaDrop.getValue()); 
					fehlermeldung.setText("");
				}
				else {
					fehlermeldung.setText("Sie haben kein Thema ausgewählt!"); 
				}	
			}
		});

		textStyle(willkommen);
		textStyle(themaText);
		textStyle(fehlermeldung);
		buttonStyle(start);
		buttonStyle(themaButton);
		gridpaneStyle(gridPane);

		gridPane.add(willkommen, 1, 2, 6, 1);
		gridPane.add(start, 7, 2, 2, 1);
		gridPane.add(themaText, 1, 4, 3, 1);
		gridPane.add(themaDrop, 5, 4);
		gridPane.add(themaButton, 7, 4, 2, 1);
		gridPane.add(fehlermeldung, 0, 10, 5, 1);
	}

	public void textStyle(Text text) {
		text.setFont(new Font("Arial", 30));
	}

	public void buttonStyle(Button button) {
		button.setMinWidth(150);
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

	public ComboBox<String> themaDropdownStyle() {
		ObservableList<String> thema = 
				FXCollections.observableArrayList(
						"Tiere",
						"Essen"
						);

		final ComboBox<String> comboBox = new ComboBox<String>(thema);

		return comboBox;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public Scene getScene() {	
		return new Scene(gridPane, 1000, 500);
	}

}

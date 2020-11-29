package com.vokabeltrainer;

import java.util.function.Consumer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Startbildschirm implements View {

	private GridPane gridPane = new GridPane();
	private String thema = null;

	public Startbildschirm(Consumer<SetVokabeln> startEvent) {
		Text willkommen = new Text("Willkommen zum Vokabeltraining!");
		Button start = new Button("Start");
		start.setDisable(true);
		start.setVisible(false);
		start.setOnAction(event -> {
			SetVokabeln loadSet = new SetVokabeln();
			loadSet.textdateiEinlesen(thema);
			startEvent.accept(loadSet);
		});

		Text themaText = new Text("Wählen Sie ein Thema: ");
		ComboBox<String> themaDrop = themaDropdownStyle();

		themaDrop.setOnAction(new EventHandler <ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				String choiceThema = themaDrop.getValue();
				if (choiceThema != null && !choiceThema.isEmpty()) {
					thema = choiceThema;
					start.setDisable(false);
					start.setVisible(true);
				}
				else {		
					start.setDisable(true);
					start.setVisible(false);
				}	
			}
		});

		willkommen.setFont(new Font("Arial", 30));
		textStyle(themaText);
		buttonStyle(start);
		gridpaneStyle(gridPane);

		gridPane.add(willkommen, 1, 1, 6, 1);
		gridPane.add(start, 7, 8, 2, 1);
		gridPane.add(themaText, 1, 3, 3, 1);
		gridPane.add(themaDrop, 7, 3, 2, 1);
	}

	private void textStyle(Text text) {
		text.setFont(new Font("Arial", 22));
	}

	private void buttonStyle(Button button) {
		button.setMinWidth(190);
		button.setMinHeight(50);
		button.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		button.getStyle();
	}

	private void gridpaneStyle(GridPane gridPane) {
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

	private ComboBox<String> themaDropdownStyle() {
		ObservableList<String> thema = 
				FXCollections.observableArrayList(
						"Tiere",
						"Essen"
						);

		final ComboBox<String> comboBox = new ComboBox<String>(thema);
		
		comboBox.setPromptText("Thema wählen");
		comboBox.setMinWidth(190);
		comboBox.setMinHeight(50);
		comboBox.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		comboBox.getStyle();

		return comboBox;
	}

	public Scene getScene() {	
		return new Scene(gridPane, 1000, 500);
	}

}

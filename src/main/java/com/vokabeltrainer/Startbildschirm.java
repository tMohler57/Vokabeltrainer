package com.vokabeltrainer;

import java.util.function.BiConsumer;
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
	private String sprache = null;
	private String richtung = null;
	private boolean themaGewaehlt = false;
	private boolean spracheGewaehlt = false;
	private boolean richtungGewaehlt = false;

	public Startbildschirm(Consumer<SetVokabeln> startEvent) {
		Text willkommen = new Text("Willkommen zum Vokabeltraining!");
		Button start = new Button("Start");
		start.setDisable(true);
		start.setVisible(false);
		start.setOnAction(event -> {
			SetVokabeln loadSet = new SetVokabeln();
			loadSet.textdateiEinlesen(thema, sprache, richtung);
			startEvent.accept(loadSet);
		});

		Text themaText = new Text("Wählen Sie ein Thema: ");
		ComboBox<String> themaDrop = themaDropdown();
		Text spracheText = new Text("Wählen Sie eine Sprache: ");
		ComboBox<String> spracheDrop = spracheDropdown();
		Text richtungText = new Text("Wählen Sie die Übersetzungsrichtung: ");
		ComboBox<String> richtungDrop = richtungDropdown();

		themaDrop.setOnAction(new EventHandler <ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				String choiceThema = themaDrop.getValue();
				if (choiceThema != null && !choiceThema.isEmpty()) {
					thema = choiceThema;
					themaGewaehlt = true;
					if(spracheGewaehlt == true && richtungGewaehlt == true) {
						start.setDisable(false);
						start.setVisible(true);
					}
				}
			}
		});

		spracheDrop.setOnAction(new EventHandler <ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				String choiceSprache = spracheDrop.getValue();
				if (choiceSprache != null && !choiceSprache.isEmpty()) {
					sprache = choiceSprache;
					spracheGewaehlt = true;
					if(themaGewaehlt == true && richtungGewaehlt) {
						start.setDisable(false);
						start.setVisible(true);
					}
				}	
			}
		});
		
		richtungDrop.setOnAction(new EventHandler <ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				String choiceRichtung = richtungDrop.getValue();
				if (choiceRichtung != null && !choiceRichtung.isEmpty()) {
					richtung = choiceRichtung;
					richtungGewaehlt = true;
					if(themaGewaehlt == true && spracheGewaehlt == true) {
						start.setDisable(false);
						start.setVisible(true);
					}
				}	
			}
		});

		willkommen.setFont(new Font("Arial", 30));
		textStyle(themaText);
		textStyle(spracheText);
		textStyle(richtungText);
		buttonStyle(start);
		gridpaneStyle(gridPane);

		gridPane.add(willkommen, 1, 1, 6, 1);
		gridPane.add(start, 7, 9, 2, 1);
		gridPane.add(themaText, 1, 3, 3, 1);
		gridPane.add(themaDrop, 7, 3, 2, 1);
		gridPane.add(spracheText, 1, 5, 3, 1);
		gridPane.add(spracheDrop, 7, 5, 2, 1);
		gridPane.add(richtungText, 1, 7, 3, 1);
		gridPane.add(richtungDrop, 7, 7, 2, 1);
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
		for (int i = 0; i < 11; i++) {
			if (i < 10) {
				gridPane.getColumnConstraints().add(columnConstraints);
			}
			gridPane.getRowConstraints().add(rowConstraints);
		}
	}
	
	private void dropdownStyle(ComboBox<String> comboBox) {
		comboBox.setPromptText("Thema wählen");
		comboBox.setMinWidth(190);
		comboBox.setMinHeight(50);
		comboBox.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		comboBox.getStyle();
	}

	private ComboBox<String> themaDropdown() {
		ObservableList<String> thema = 
				FXCollections.observableArrayList(
						"Tiere",
						"Tourismus",
						"Beruf"
						);

		final ComboBox<String> comboBox = new ComboBox<String>(thema);
		dropdownStyle(comboBox);
		
		return comboBox;
	}
	
	private ComboBox<String> spracheDropdown() {
		ObservableList<String> sprache = 
				FXCollections.observableArrayList(
						"Englisch",
						"Französisch"
						);

		final ComboBox<String> comboBox = new ComboBox<String>(sprache);
		dropdownStyle(comboBox);
		
		return comboBox;
	}
	
	private ComboBox<String> richtungDropdown() {
		ObservableList<String> richtung = 
				FXCollections.observableArrayList(
						"Deutsch --> Fremdsprache",
						"Fremdsprache --> Deutsch"
						);

		final ComboBox<String> comboBox = new ComboBox<String>(richtung);
		dropdownStyle(comboBox);
		
		return comboBox;
	}

	public Scene getScene() {	
		return new Scene(gridPane, 1000, 500);
	}
}

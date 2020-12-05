package com.vokabeltrainer.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.vokabeltrainer.model.Thema;
import com.vokabeltrainer.model.VokabelModel;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartView extends View {
	
	private final ComboBox<String> spracheDrop, themaDrop, richtungDrop;
	private final Button start;
	private final Scene scene;

	public StartView(VokabelModel mdl, Runnable startEvent, Runnable dropdownEvent) {
		super(mdl);

		Text willkommen = createText("Willkommen zum Vokabeltraining!");
		willkommen.setFont(new Font("Arial", 30));

		start = createButton("startButton", "Start");
		start.setDisable(true);
		start.setVisible(false);
		start.setOnAction(event -> startEvent.run());

		Text themaText = createText("Wählen Sie ein Thema: ");
		List<String> themaNamen = Arrays.stream(Thema.values()).map(t -> t.name()).collect(Collectors.toList());
		themaDrop = createComboBox("themaDropdown", "Thema wählen", themaNamen, dropdownEvent);

		Text spracheText = createText("Wählen Sie eine Sprache: ");
		spracheDrop = createComboBox("spracheDropdown", "Sprache wählen", model.getVerfuegbareSprachen(), dropdownEvent);

		Text richtungText = createText("Wählen Sie die Übersetzungsrichtung: ");
		richtungDrop = createComboBox("richtungDropdown", "Richtung wählen",
				Arrays.asList("Deutsch -> Fremdsprache", "Fremdsprache -> Deutsch"), dropdownEvent);
		
		GridPane gridPane = createGridPane();
		gridPane.add(willkommen, 1, 1, 6, 1);
		gridPane.add(start, 7, 9, 2, 1);
		gridPane.add(themaText, 1, 3, 3, 1);
		gridPane.add(themaDrop, 7, 3, 2, 1);
		gridPane.add(spracheText, 1, 5, 3, 1);
		gridPane.add(spracheDrop, 7, 5, 2, 1);
		gridPane.add(richtungText, 1, 7, 3, 1);
		gridPane.add(richtungDrop, 7, 7, 2, 1);
		
		scene = new Scene(gridPane, 1000, 500);
	}

	public Boolean isRichtungUmkehren() {
		String richtung = richtungDrop.getValue();
		return richtung == null ? null : richtung.startsWith("Fremdsprache");
	}

	public Thema getThema() {
		String thema = themaDrop.getValue();
		return thema == null ? null : Thema.valueOf(thema);
	}

	public String getSprache() {
		return spracheDrop.getValue();
	}
	
	public void enableStartButton(boolean enabled) {
		start.setDisable(!enabled);
		start.setVisible(enabled);
	}

	protected GridPane createGridPane() {
		GridPane gridPane = new GridPane();
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
		return gridPane;
	}

	protected ComboBox<String> createComboBox(String id, String prompt, List<String> items, Runnable event) {
		ComboBox<String> drop = new ComboBox<String>(FXCollections.observableList(items));
		drop.setId(id);
		drop.setPromptText(prompt);
		drop.setOnAction(action -> event.run());
		drop.setMinWidth(250);
		drop.setMinHeight(50);
		drop.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		return drop;
	}

	public Scene getScene() {
		return scene;
	}
}

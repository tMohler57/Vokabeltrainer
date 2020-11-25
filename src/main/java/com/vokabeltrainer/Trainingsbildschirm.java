package com.vokabeltrainer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Trainingsbildschirm implements View {

	//private final GridPane gridPane = new GridPane();
	private final Scene scene;
	private SetVokabeln wörtli = new SetVokabeln();
	private int index = 0;

	public Trainingsbildschirm(EventHandler<ActionEvent> trainingBeenden) {
		wörtli.textdateiEinlesen();
		
		Text frage = new Text(), lösung = new Text(), geprüfteEingabe = new Text();
		TextField antwort = new TextField();
		Button weiter = new Button("Weiter"), ende = new Button("Beenden"), bestätigen = new Button("Bestätigen");
		
		ende.setOnAction(trainingBeenden);
		
		weiter.setOnAction(event -> {
			if (index >= wörtli.getWort().size()) {
				trainingBeenden.handle(event);
			}
			antwort.clear();
			antwort.setDisable(false);
			lösung.setText(null);
			geprüfteEingabe.setText(null);
			bestätigen.setDisable(false);
			weiter.setVisible(false);
			ende.setVisible(false);
			frage.setText("Was heißt '" + wörtli.getWort().get(index).getVokabel() + "' auf französisch?");
		});
		weiter.getOnAction().handle(null);
		
		bestätigen.setOnAction(event -> {
			String eingabe = antwort.getText();
			if (!eingabe.matches(".*[a-zA-Z].*")) {
				geprüfteEingabe.setText("Die Eingabe ist ungültig!");
				return;
			}
			geprüfteEingabe.setText(null);
			antwort.setDisable(true);
			bestätigen.setDisable(true);
			weiter.setVisible(true);
			ende.setVisible(true);
			lösung.setText("Die richtige Lösung ist '" + wörtli.getWort().get(index).getUebersetzung() + "'.");
			if (eingabe.trim().equals(wörtli.getWort().get(index).getUebersetzung())) {
				geprüfteEingabe.setText("Ihre Antwort ist richtig.");
			}
			else {
				geprüfteEingabe.setText("Ihre Antwort ist falsch.");
			}
			index++;
		});
		
		textStyle(frage);
		textStyle(lösung);
		textStyle(geprüfteEingabe);
		
		buttonStyle(bestätigen);
		buttonStyle(weiter);
		buttonStyle(ende);
		
		HBox hbox1 = new HBox(antwort, bestätigen);
		HBox hbox2 = new HBox(weiter, ende);
		HBox hbox3 = new HBox(geprüfteEingabe);
		hboxStyle(hbox1);hboxStyle(hbox2);hboxStyle(hbox3);
		VBox vbox1 = new VBox(frage, hbox1, lösung, hbox2, hbox3);
		vboxStyle(vbox1);
		
		scene = new Scene(vbox1, 1000, 500);
		
	}
	
	public void buttonStyle(Button button) {
		button.setMinWidth(115);
		button.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		button.getStyle();
	}
	
	public void textStyle(Text text) {
		text.setStyle("-fx-background-color: #F7819F");	
		text.setFont(new Font("Arial", 20));
	}
	
	public void vboxStyle(VBox vbox) {
		vbox.setStyle("-fx-background-color: #F7819F");
		vbox.setAlignment(Pos.CENTER);
	}
	
	public void hboxStyle(HBox hbox) {
		hbox.setAlignment(Pos.CENTER);
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}

}

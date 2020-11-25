package com.vokabeltrainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Trainingsbildschirm implements View {

	private final Scene scene;
	private SetVokabeln wörtli = new SetVokabeln();
	private int index = 0;
	private int countKorrekt = 0;
	private int countGesamt = 0;

	// BiConsumer gibt zwei Integer mit, imgegensatz zu EventHandler<ActionEvent> 
	public Trainingsbildschirm(BiConsumer<Integer,Integer> trainingBeenden) {
		wörtli.textdateiEinlesen();
		
		List <Vokabel> aktuelleVokabeln = wörtli.getWort();
		List <Vokabel> falscheVokabeln = new ArrayList<>();
		
		Collections.shuffle(aktuelleVokabeln);
		
		Text frage = new Text(), lösung = new Text(), geprüfteEingabe = new Text();
		TextField antwort = new TextField();
		Button weiter = new Button("Weiter"), ende = new Button("Beenden"), bestätigen = new Button("Bestätigen");
		
		ende.setOnAction(action -> trainingBeenden.accept(countKorrekt, countGesamt));
		
		weiter.setOnAction(event -> {
			if (index >= aktuelleVokabeln.size()) {
				trainingBeenden.accept(countKorrekt, countGesamt);
			}
			antwort.clear();
			antwort.setDisable(false);
			lösung.setText(null);
			geprüfteEingabe.setText(null);
			bestätigen.setDisable(false);
			weiter.setVisible(false);
			ende.setVisible(false);
			frage.setText("Was heißt '" + aktuelleVokabeln.get(index).getVokabel() + "' auf französisch?");
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
			lösung.setText("Die richtige Lösung ist '" + aktuelleVokabeln.get(index).getUebersetzung() + "'.");
			if (eingabe.trim().equals(aktuelleVokabeln.get(index).getUebersetzung())) {
				geprüfteEingabe.setText("Ihre Antwort ist richtig.");
				countKorrekt++;
			}
			else {
				geprüfteEingabe.setText("Ihre Antwort ist falsch.");
			}
			countGesamt++;
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

//	public SetVokabeln getWörtli() {
//		return wörtli;
//	}
//
//	public int getIndex() {
//		return index;
//	}	

}

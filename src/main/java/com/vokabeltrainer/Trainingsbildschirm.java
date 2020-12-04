package com.vokabeltrainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

import javafx.geometry.Insets;
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
	private int index = 0;
	private int countKorrekt = 0;
	private int countGesamt = 0;
	private List<Vokabel> aktuelleVokabeln, falscheVokabeln;
	private Button weiter = new Button("Weiter");
	private String sprache;
	private String richtung;

	public void setWoertli(SetVokabeln woertli) {
		aktuelleVokabeln = woertli.getWort();
		falscheVokabeln = new ArrayList<>();
		Collections.shuffle(aktuelleVokabeln);
		
		if(woertli.getFile() == "src/main/java/com/vokabeltrainer/Animaux.txt" 
				|| woertli.getFile() == "src/main/java/com/vokabeltrainer/Tourisme-et-transport.txt" 
				|| woertli.getFile() == "src/main/java/com/vokabeltrainer/Professions-et-bureau.txt") {
			this.sprache = "französisch";
		}
		else if(woertli.getFile() == "src/main/java/com/vokabeltrainer/Animals.txt" || 
				woertli.getFile() == "src/main/java/com/vokabeltrainer/Tourism-and-transport.txt" || 
				woertli.getFile() == "src/main/java/com/vokabeltrainer/Professions-and-office.txt") {
			this.sprache = "englisch";
		}		
		this.richtung = woertli.getRichtung();
		
		weiter.getOnAction().handle(null);
	}

	// BiConsumer gibt zwei Integer mit, im Gegensatz zu EventHandler<ActionEvent> 
	public Trainingsbildschirm(BiConsumer<Integer,Integer> trainingBeenden) {
		Text frage = new Text(), loesung = new Text(), gepruefteEingabe = new Text();
		TextField antwort = new TextField();
		Button ende = new Button("Beenden"), bestaetigen = new Button("Bestätigen");

		ende.setOnAction(action -> trainingBeenden.accept(countKorrekt, countGesamt));

		weiter.setOnAction(event -> {
			if (index >= aktuelleVokabeln.size()) {
				aktuelleVokabeln = falscheVokabeln;
				falscheVokabeln = new ArrayList<>();
				Collections.shuffle(aktuelleVokabeln);
				index = 0;

				if (aktuelleVokabeln.isEmpty()) {
					trainingBeenden.accept(countKorrekt, countGesamt);
					return;
				}
			}
			antwort.clear();
			antwort.setDisable(false);
			loesung.setText(null);
			gepruefteEingabe.setText(null);
			bestaetigen.setDisable(false);
			weiter.setVisible(false);
			ende.setVisible(false);
			if(richtung == "Deutsch --> Fremdsprache") {
				frage.setText("Was heißt '" + aktuelleVokabeln.get(index).getVokabel() + "' auf " + sprache + "?");
			}
			else if(richtung == "Fremdsprache --> Deutsch") {
				frage.setText("Was heißt '" + aktuelleVokabeln.get(index).getVokabel() + "' auf deutsch?");
			}
		});

		bestaetigen.setOnAction(event -> {
			String eingabe = antwort.getText();
			if (!eingabe.matches(".*[a-zA-Z].*")) {
				gepruefteEingabe.setText("Die Eingabe ist ungültig!");
				return;
			}
			gepruefteEingabe.setText(null);
			antwort.setDisable(true);
			bestaetigen.setDisable(true);
			weiter.setVisible(true);
			ende.setVisible(true);
			loesung.setText("Die richtige Lösung ist '" + aktuelleVokabeln.get(index).getUebersetzung() + "'.");
			
			if (eingabe.trim().equals(aktuelleVokabeln.get(index).getUebersetzung())) {
				gepruefteEingabe.setText("Ihre Antwort ist richtig.");
				loesung.setVisible(false);
				countKorrekt++;
			}
			else {
				gepruefteEingabe.setText("Ihre Antwort ist leider falsch.");
				falscheVokabeln.add(aktuelleVokabeln.get(index));
				loesung.setVisible(true);
			}
			countGesamt++;
			index++;
		});

		textStyle(frage);
		textStyle(loesung);
		textStyle(gepruefteEingabe);

		buttonStyle(bestaetigen);
		buttonStyle(weiter);
		buttonStyle(ende);

		HBox hbox1 = new HBox(15,antwort, bestaetigen);
		HBox hbox2 = new HBox(90, weiter, ende);
		HBox hbox3 = new HBox(15, gepruefteEingabe);
		hboxStyle(hbox1);
		hboxStyle(hbox2);
		hboxStyle(hbox3);
		VBox vbox1 = new VBox(frage, hbox1, hbox3, loesung, hbox2);
		vboxStyle(vbox1);

		scene = new Scene(vbox1, 1000, 500);
	}

	private void buttonStyle(Button button) {
		button.setMinWidth(115);
		button.setStyle("-fx-background-color: #FAAC58; -fx-text-fill: #610B0B; -fx-font-size: 1.3em; -fx-border-color: #B40404; -fx-border-width: 2px;");
		button.getStyle();
	}

	private void textStyle(Text text) {
		text.setStyle("-fx-background-color: #F7819F");	
		text.setFont(new Font("Arial", 20));
	}

	private void vboxStyle(VBox vbox) {
		vbox.setStyle("-fx-background-color: #F7819F");
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10,20,20,20));
		vbox.setSpacing(15);
	}

	private void hboxStyle(HBox hbox) {
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10,20,20,20));
	}

	@Override
	public Scene getScene() {
		return scene;
	}
}

package com.vokabeltrainer.view;

import java.util.function.Consumer;

import com.vokabeltrainer.model.VokabelModel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TrainingsView extends View {

	private final Scene scene;
	private final Text frage, loesung, gepruefteEingabe;
	private final TextField antwort;
	private final Button endeButton, bestaetigenButton, weiterButton;

	public TrainingsView(VokabelModel mdl, Consumer<String> bestaetigen, Runnable weiter, Runnable trainingBeenden) {
		this(true, mdl, bestaetigen, weiter, trainingBeenden);
	}

	TrainingsView(boolean shuffle, VokabelModel mdl, Consumer<String> bestaetigen, Runnable weiter, Runnable trainingBeenden) {
		super(mdl);
		frage = createText("");
		loesung = createText("");
		gepruefteEingabe = createText("");
		antwort = new TextField();
		
		bestaetigenButton = createButton("bestätigenButton", "Bestätigen");
		bestaetigenButton.setMinWidth(100);
		bestaetigenButton.setMinHeight(30);
		bestaetigenButton.setOnAction(event-> bestaetigen.accept(antwort.getText()));
		weiterButton = createButton("weiterButton", "Weiter");
		weiterButton.setOnAction(event -> weiter.run());
		endeButton = createButton("beendenButton", "Beenden");
		endeButton.setOnAction(action -> trainingBeenden.run());
		
		// Auf dem Trainingsbildschirm wird dem Benutzer angezeigt, welche Vokabeln er übersetzen soll. 
		// Es gibt ein Textfeld, in welches er die Übersetzung eingeben kann.
		// Seine Eingabe kann er mit einem Button bestätigen.
		// Nach dem die richtige Übersetzung angezeigt wurde, kann der Benutzer entweder eine weitere Vokabel übersetzen oder das Programm beenden.
		HBox hbox1 = createHBox(15, antwort, bestaetigenButton);
		HBox hbox2 = createHBox(90, weiterButton, endeButton);
		HBox hbox3 = createHBox(15, gepruefteEingabe);
		VBox vbox1 = createVBox(frage, hbox1, hbox3, loesung, hbox2);
		
		scene = new Scene(vbox1, 1000, 500);
		
		nextVokabel();
	}
	
	public void nextVokabel() {
		antwort.clear();
		antwort.setDisable(false);
		loesung.setText(null);
		gepruefteEingabe.setText(null);
		bestaetigenButton.setDisable(false);
		weiterButton.setVisible(false);
		endeButton.setVisible(false);
		
		String sprache = model.isRichtungUmkehren() ? "Deutsch" : model.getSprache(); 
		frage.setText("Was heißt '" + model.getAktuelleVokabeln().get(model.getIndex()).getVokabel() + "' auf " + sprache + "?");
	}
	
	public void eingabeUngueltig() {
		gepruefteEingabe.setText("Die Eingabe ist ungültig!");
	}
	
	public void antwortAnzeigen(boolean richtig) {
		gepruefteEingabe.setText(null);
		antwort.setDisable(true);
		bestaetigenButton.setDisable(true);
		weiterButton.setVisible(true);
		endeButton.setVisible(true);
		loesung.setText("Die richtige Lösung ist '" + model.getAktuelleVokabeln().get(model.getIndex()).getUebersetzung() + "'.");
		
		String korrekt = richtig ? "richtig" : "falsch";
		gepruefteEingabe.setText("Ihre Antwort ist " + korrekt + ".");
		loesung.setVisible(!richtig);
	}

	@Override
	protected Button createButton(String id, String text) {
		Button button = super.createButton(id, text);
		return button;
	}

	@Override
	protected Text createText(String text) {
		Text t = super.createText(text);
		t.setFont(new Font("Arial", 20));
		return t;
	}

	protected VBox createVBox(Node... children) {
		VBox vbox = new VBox(children);
		vbox.setStyle("-fx-background-color: #48d1CC");
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10,20,20,20));
		vbox.setSpacing(15);
		return vbox;
	}

	protected HBox createHBox(double spacing, Node... children) {
		HBox hbox = new HBox(spacing, children);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10,20,20,20));
		return hbox;
	}

	@Override
	public Scene getScene() {
		return scene;
	}
}

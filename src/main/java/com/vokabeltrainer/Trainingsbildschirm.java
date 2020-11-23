package com.vokabeltrainer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Trainingsbildschirm implements View {

	//private final GridPane gridPane = new GridPane();
	private final Scene scene;
	private SetVokabeln wörtli = new SetVokabeln();
	private int index = 0;

	public Trainingsbildschirm(EventHandler<ActionEvent> trainingBeenden) {
		wörtli.textdateiEinlesen();
		
		Text frage = new Text(), lösung = new Text();
		TextField antwort = new TextField();
		Button weiter = new Button("weiter"), ende = new Button("beenden"), bestätigen = new Button("bestätigen");
		
		ende.setOnAction(trainingBeenden);
		
		weiter.setOnAction(event -> {
			if (index >= wörtli.getWort().size()) {
				trainingBeenden.handle(event);
			}
			antwort.clear();
			lösung.setText(null);
			bestätigen.setVisible(true);
			weiter.setVisible(false);
			ende.setVisible(false);
			frage.setText("Was heißt '" + wörtli.getWort().get(index).getVokabel() + "' auf französisch?");
		});
		weiter.getOnAction().handle(null);
		
		bestätigen.setOnAction(event -> {
			bestätigen.setVisible(false);
			weiter.setVisible(true);
			ende.setVisible(true);
			lösung.setText("Die richtige Lösung ist '" + wörtli.getWort().get(index).getUebersetzung() + "'.");
			index++;
		});
		
		VBox pane = new VBox(frage, new HBox(antwort, bestätigen), lösung, new HBox(weiter, ende));
		scene = new Scene(pane);
	}
	

	@Override
	public Scene getScene() {
		return scene;
	}

}

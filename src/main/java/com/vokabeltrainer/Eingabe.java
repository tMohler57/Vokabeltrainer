package com.vokabeltrainer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Eingabe implements View{
	
	private final GridPane gridPane = new GridPane();
	private final Scene scene;

	public Eingabe(EventHandler<ActionEvent> startEvent) {
		Label losgehts = new Label("Los gehts. Wir trainieren jetzt Vokabeln!");
		
		Button kontrolle = new Button("Kontrolle");
		kontrolle.setOnAction(startEvent);
		
		gridPane.add(losgehts, 2, 3);
		gridPane.add(kontrolle, 3, 2);
		scene = new Scene(gridPane);
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}

}

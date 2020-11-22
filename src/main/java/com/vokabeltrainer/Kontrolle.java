package com.vokabeltrainer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Kontrolle implements View {
	
	private final GridPane gridPane = new GridPane();
	private final Scene scene;
	
	public Kontrolle(EventHandler<ActionEvent> startEvent, EventHandler<ActionEvent> endEvent) {
		Label loesung = new Label("Dies ist die korrekte Lösung");
		
		Button neueVokabel = new Button("weiter Lernen");
		neueVokabel.setOnAction(startEvent);
		Button ende = new Button("lernen beenden");
		ende.setOnAction(endEvent);
		
		gridPane.add(loesung, 0, 1);
		gridPane.add(neueVokabel, 2, 0);
		gridPane.add(ende, 2, 2);
		
		scene = new Scene(gridPane);
	}

	@Override
	public Scene getScene() {

		return scene;
	}

}

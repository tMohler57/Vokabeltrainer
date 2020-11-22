package com.vokabeltrainer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Endbildschirm implements View {
	
	private GridPane gridPane = new GridPane();
	
	public Endbildschirm(EventHandler<ActionEvent> startEvent) {
		Label wiedersehen = new Label("Das Vokabeltraining wurde beendet. Auf Wiedersehen!");
		
		Button beenden = new Button("Programm beenden");
		beenden.setOnAction(startEvent);
		
		gridPane.add(wiedersehen, 2, 3);
		gridPane.add(beenden, 3, 2);
	}

	@Override
	public Scene getScene() {
		
		return new Scene(gridPane);
	}

}

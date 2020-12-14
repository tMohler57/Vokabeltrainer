package com.vokabeltrainer.view;

import java.util.Locale;

import com.vokabeltrainer.model.VokabelModel;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EndView extends View {
	
	private final Scene scene;	
	private final Text glueckwunsch;
	
	public EndView(VokabelModel mdl, Runnable programmBeenden, Runnable programmNeustarten) {
		super(mdl);
		
		glueckwunsch = createText("");
		glueckwunsch.setId("glueckwunschAusgabe");
		Text wiedersehen = createText("Das Vokabeltraining wurde beendet. Auf Wiedersehen!");
		Text count = createText("");
		count.setId("countAusgabe");
		Text feedback = createText("");
		feedback.setId("feedbackAusgabe");

		count.setText("Sie haben " + model.getCountKorrekt() + " von " + model.getCountGesamt() + " Vokabeln richtig übersetzt.");
		feedback.setText("Damit haben Sie eine Erfolgsquote von " + String.format(Locale.ENGLISH, "%.2f", model.erfolgsquote()) + "%");
				
		Button beenden = createButton("beendenButton", "Programm beenden");
		beenden.setOnAction(event -> programmBeenden.run());
		Button neustarten = createButton("neustartenButton", "Zurück zum Hauptmenu");
		neustarten.setOnAction(event -> programmNeustarten.run());
		
		// Auf dem Endbildschirm erscheint ein Text, der dem Benutzer seine Erfolgsquote anzeigt. 
		// Es gibt einen Button, mit dem das Training neugestartet wird, und einen, mit dem es beendet wird.
		GridPane gridPane = createGridPane();		
		gridPane.add(wiedersehen, 1, 2, 7, 1);
		gridPane.add(count, 1, 4, 6, 1);
		gridPane.add(feedback, 1, 5, 6, 1);
		gridPane.add(glueckwunsch, 1, 6, 6, 1);
		gridPane.add(beenden, 7, 7, 3, 1);
		gridPane.add(neustarten, 5, 7, 3, 1);
		
		scene = new Scene(gridPane, 1000, 500);
	}
	
	public void wuenscheGlueck() {
		glueckwunsch.setText("Herzlichen Glückwunsch!");
	}
	
	@Override
	protected Text createText(String t) {
		Text text = super.createText(t);
		text.setFont(new Font("Arial", 30));
		return text;
	}
	
	@Override
	protected Button createButton(String id, String text) {
		Button button = super.createButton(id, text);
		return button;
	}
	
	protected GridPane createGridPane() {
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color: #48d1CC");
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setPercentWidth(10);
		RowConstraints rowConstraints = new RowConstraints();
		rowConstraints.setPercentHeight(20);
		for (int i = 0; i < 10; i++) {
			gridPane.getColumnConstraints().add(columnConstraints);
			gridPane.getRowConstraints().add(rowConstraints);
		}
		return gridPane;
	}

	@Override
	public Scene getScene() {
		return scene;
	}
}

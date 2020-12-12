package com.vokabeltrainer.controller;

import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.StartView;

import javafx.stage.Stage;

public class StartController extends Controller<StartView>{
	
	// Konstruktor des StartControllers
	public StartController(VokabelModel mdl, Stage stage) { 		
		super(mdl, stage);
	}
	
	// Das Layout des Startbildschirms ist in der Klasse StartView definiert und wird hier aufgerufen.
	@Override
	protected StartView createView() { 	
		return new StartView(model, this::weiter, this::dropdown);
	}
	
	// Wird der Start-Button gedrückt, so wechselt das Programm vom Startbildschirm zum Trainingsbildschirm.
	void weiter() {
		model.ladeDatei();		
		new TrainingsController(model, stage); 
		
	}
	
	// Auf dem Startbildschirm gibt es drei Dropdown-Menus zum Auswählen von Thema, Sprache und Übersetzungsrichtung sowie einen Start-Button.
	void dropdown() { 	
		model.setThema(view.getThema());
		model.setSprache(view.getSprache());
		model.setRichtungUmkehren(view.isRichtungUmkehren());
		// Sobald Thema, Sprache und Übersetzungsrichtung ausgewählt wurden, erhält der Start-Button seine Funktionalität.
		view.enableStartButton(model.getThema() != null && model.getSprache() != null && model.isRichtungUmkehren() != null); 	
	}
}

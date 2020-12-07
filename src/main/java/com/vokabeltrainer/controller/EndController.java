package com.vokabeltrainer.controller;

import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.EndView;

import javafx.application.Platform;
import javafx.stage.Stage;

public class EndController extends Controller<EndView> {
	
	// Konstrunktor des EndControllers
	public EndController(VokabelModel model, Stage stage) {		
		super(model, stage);
	}
	
	// Das Layout des Endbildschirms ist in der Klasse EndView definiert und wird hier aufgerufen.
	@Override
	protected EndView createView() {
		EndView view = new EndView(model, this::programmBeenden, this::programmNeustarten);
		
		// Bei gutem Erfolg (Erfolgsqoute über 50%) wird dem Benutzer zu seiner Leistung gratuliert.
		if (model.erfolgsquote() >= 50.00) view.wuenscheGlueck();
		
		return view;
	}
	
	// Wird der Beenden-Button gedrückt, so wird das Programm geschlossen.
	void programmBeenden() {	
		Platform.exit();
		System.exit(0);
	}
	
	// Wird der Neustart-Button gedrückt, so kehrt der Benutzer zurück zum Startbildschirm.
	void programmNeustarten() {	
		new StartController(new VokabelModel(), stage);	
	}

}

package com.vokabeltrainer.controller;

import java.util.Collections;
import java.util.List;

import com.vokabeltrainer.model.Vokabel;
import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.TrainingsView;

import javafx.stage.Stage;

public class TrainingsController extends Controller<TrainingsView> {
	
	// Konstruktor des TrainingsControllers
	protected TrainingsController(VokabelModel model, Stage stage) {	
		super(model, stage);
	}
	
	// Das Layout des Trainingsbildschirms ist in der Klasse TrainingsView definiert und wird hier aufgerufen.
	@Override
	protected TrainingsView createView() {		
		shuffle();
		return new TrainingsView(model, this::bestaetigen, this::weiter, this::beenden);
	}

	private void bestaetigen(String eingabe) {
		// Die Eingabe ist ungültig, wenn das Textfeld leer ist.
		if (!eingabe.matches(".*[a-zA-Z].*")) {
			view.eingabeUngueltig();	
			return;
		}
		
		//Es wird geprüft, ob die eingegebene Übersetzung richtig ist.
		boolean richtig = eingabe.trim().equals(model.getAktuelleVokabeln().get(model.getIndex()).getUebersetzung());
		view.antwortAnzeigen(richtig);
		
		List<Vokabel> aktuell = model.getAktuelleVokabeln(), falsch = model.getFalscheVokabeln();
		
		if(richtig) model.setCountKorrekt(model.getCountKorrekt() + 1);
		else falsch.add(aktuell.get(model.getIndex()));
		
		model.setCountGesamt(model.getCountGesamt() + 1);
		model.setIndex(model.getIndex() + 1);;
	}

	private void weiter() {
		List<Vokabel> aktuell = model.getAktuelleVokabeln(), falsch = model.getFalscheVokabeln();
		if (model.getIndex() >= aktuell.size()) {
			// Wenn alle Vokabeln einmal richtig übersetzt wurden, wird das Vokabeltraining beendet.
			if (falsch.isEmpty()) {
				beenden();	
				return;
			}
			
			aktuell.clear();
			aktuell.addAll(falsch);
			falsch.clear();
			shuffle();
			model.setIndex(0);
		}
		
		view.nextVokabel();
	}
	// Wird der Beenden-Button gedrückt oder wurden alle Vokabeln richtig beantwortet, so wechselt das Programm vom Trainingsbildschirm zum Endbildschirm.
	private void beenden() {
		new EndController(model, stage);	
	}
	
	// Die Vokabeln werden in einer zufälligen Reihenfolge abgefragt.
	void shuffle() {
		Collections.shuffle(model.getAktuelleVokabeln());	
	}
}

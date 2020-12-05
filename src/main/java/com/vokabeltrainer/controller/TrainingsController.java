package com.vokabeltrainer.controller;

import java.util.Collections;
import java.util.List;

import com.vokabeltrainer.model.Vokabel;
import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.TrainingsView;

import javafx.stage.Stage;

public class TrainingsController extends Controller<TrainingsView> {

	protected TrainingsController(VokabelModel model, Stage stage) {
		super(model, stage);
	}

	@Override
	protected TrainingsView createView() {
		shuffle();
		return new TrainingsView(model, this::bestaetigen, this::weiter, this::beenden);
	}

	private void bestaetigen(String eingabe) {
		if (!eingabe.matches(".*[a-zA-Z].*")) {
			view.eingabeUngueltig();
			return;
		}
		
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

	private void beenden() {
		new EndController(model, stage);
	}

	void shuffle() {
		Collections.shuffle(model.getAktuelleVokabeln());
	}
}

package com.vokabeltrainer.controller;

import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.StartView;

import javafx.stage.Stage;

public class StartController extends Controller<StartView>{

	public StartController(VokabelModel mdl, Stage stage) {
		super(mdl, stage);
	}
	
	@Override
	protected StartView createView() {
		return new StartView(model, this::weiter, this::dropdown);
	}
	
	void weiter() {
		model.ladeDatei();
		new TrainingsController(model, stage);
	}
	
	private void dropdown() {
		model.setThema(view.getThema());
		model.setSprache(view.getSprache());
		model.setRichtungUmkehren(view.isRichtungUmkehren());
		view.enableStartButton(model.getThema() != null && model.getSprache() != null && model.isRichtungUmkehren() != null);
	}
}

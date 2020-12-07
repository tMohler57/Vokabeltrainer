package com.vokabeltrainer.controller;

import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.EndView;

import javafx.application.Platform;
import javafx.stage.Stage;

public class EndController extends Controller<EndView> {

	public EndController(VokabelModel model, Stage stage) {
		super(model, stage);
	}

	@Override
	protected EndView createView() {
		EndView view = new EndView(model, this::programmBeenden, this::programmNeustarten);
		if (model.erfolgsquote() >= 50.00) view.wuenscheGlueck();
		return view;
	}

	void programmBeenden() {
		Platform.exit();
		System.exit(0);
	}

	void programmNeustarten() {
		new StartController(new VokabelModel(), stage);	
	}

}

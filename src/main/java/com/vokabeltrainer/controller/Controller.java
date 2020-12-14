package com.vokabeltrainer.controller;

import com.vokabeltrainer.model.VokabelModel;
import com.vokabeltrainer.view.View;

import javafx.stage.Stage;

public abstract class Controller<V extends View> {

	protected final VokabelModel model;
	protected final V view;
	protected final Stage stage;
	
	protected Controller(VokabelModel model, Stage stage) {
		this.model = model;
		this.stage = stage;
		// Die Ansichten der verschiedenen Bildschirme werden angezeigt.
		view = createView();
		view.showOn(stage); 		
	}
	
	protected abstract V createView();
}

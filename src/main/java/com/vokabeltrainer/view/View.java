package com.vokabeltrainer.view;

import com.vokabeltrainer.model.VokabelModel;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class View {
	
	protected final VokabelModel model;
	
	protected View(VokabelModel model) {
		this.model = model;
	}

	protected Button createButton(String id, String text) {
		Button button = new Button(text);
		button.setId(id);
		button.setMinWidth(115);
		button.setMinHeight(50);
		button.setStyle("-fx-background-color: #008080; -fx-text-fill: #FFFFFF; -fx-font-size: 1.3em; -fx-border-color: #FFFFFF; -fx-border-width: 2px");
		button.getStyle();
		return button;
	}
	
	protected abstract Scene getScene();
	
	protected String getTitle() {
		return "Vokabeltrainer";
	}
	
	public void showOn(Stage stage) {
		stage.setTitle(getTitle());
		stage.setScene(getScene());
	}
	
	protected Text createText(String text) {
		Text t = new Text(text);
		t.setFont(new Font("Arial", 22));
		return t;
	}
}

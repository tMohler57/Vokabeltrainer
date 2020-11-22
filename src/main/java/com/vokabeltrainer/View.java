package com.vokabeltrainer;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public interface View {

	public Scene getScene();
	
	public default String getTitle() {
		return "Vokabeltrainer";
	}
}

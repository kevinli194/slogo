package view;

import javafx.scene.layout.Pane;

public abstract class PaneView extends Pane {

	public void setView(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
	}

}

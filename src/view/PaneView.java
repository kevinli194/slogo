package view;

import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;


public abstract class PaneView extends Pane {

	public void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

}

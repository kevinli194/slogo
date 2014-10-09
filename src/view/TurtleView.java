package view;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TurtleView extends Pane {
	private static final double width = 600;
	private static final double height = 600;

	public TurtleView() {

		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
		setStyle("-fx-background-color:black;");

	}

	public void update(Node node) {
		this.getChildren().clear();
		this.getChildren().add(node);

	}
}

package view;

import javafx.scene.Node;

public class TurtleView extends PaneView {
	private static final double TURTLEVIEW_WIDTH = 600;
	private static final double TURTLEVIEW_HEIGHT = 600;

	public TurtleView() {
		setView(TURTLEVIEW_WIDTH, TURTLEVIEW_HEIGHT);
		setStyle("-fx-background-color:black;");

	}

	public void changeColor(String color) {
		setStyle("-fx-background-color:" + color + ";");
	}

	public void update(Node node) {
		this.getChildren().clear();
		this.getChildren().add(node);

	}

	@Override
	public void setView(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
	}
}

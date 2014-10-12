package view;

import model.Turtle;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class TurtleView extends Pane {
	private static final double width = 600;
	private static final double height = 600;

	public TurtleView() {

		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
		setStyle("-fx-background-color:black;");

	}

	public void changeColor(String color) {
		setStyle("-fx-background-color:" + color + ";");
	}

	public void update(Node node) {
		// / this.getChildren().clear();
		this.getChildren().add(node);

	}
}

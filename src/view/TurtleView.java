package view;

import model.Turtle;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		this.getChildren().add(node);

	}
}

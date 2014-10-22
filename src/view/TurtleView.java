package view;

import model.Feature;
import model.Turtle;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class TurtleView extends Pane implements View, Feature {
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

    @Override
    public void clear () {
        // TODO Auto-generated method stub
        
    }
}

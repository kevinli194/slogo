package view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

public class TurtleView extends PaneView {

	public TurtleView(double width, double height) {
		setView(width * 3 / 5, height * 11 / 16);
		setStyle("-fx-background-color:black;");
	}

	public void changeColor(String color) {
		setStyle("-fx-background-color:" + color + ";");
	}

	public void update(Node node) {
		this.getChildren().clear();
		this.getChildren().add(node);

	}

}

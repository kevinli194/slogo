package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class TurtleView extends PaneView {

	public TurtleView(double width, double height) {
		setView(width * 3 / 5, height * 11 / 16);
		setBackground(new Background(new BackgroundFill(Color.BLACK,
				CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void changeColor(Color color) {
		setBackground(new Background(new BackgroundFill(color,
				CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void update(Node node) {
		this.getChildren().clear();
		this.getChildren().add(node);

	}

}

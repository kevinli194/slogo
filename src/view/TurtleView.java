package view;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class TurtleView extends PaneView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6613430284719479884L;
	Group myGrid;
	Group myLines;

	public TurtleView(double width, double height) {
		setView(width * 3 / 5, height * 11 / 16);
		setBackground(new Background(new BackgroundFill(Color.BLACK,
				CornerRadii.EMPTY, Insets.EMPTY)));
		myGrid = new Group();
		myLines = makeGrid(width * 3 / 5, height * 11 / 16);
	}

	private Group makeGrid(double width, double height) {
		Group grid = new Group();
		for (double i = 0; i < width; i = i + 20) {
			Line line = new Line(i, 0, i, height);
			line.setStroke(Color.LIGHTGRAY);
			grid.getChildren().add(line);
		}
		for (double i = 0; i < height; i = i + 20) {
			Line line = new Line(0, i, width, i);
			line.setStroke(Color.LIGHTGRAY);
			grid.getChildren().add(line);
		}
		return grid;
	}

	public void toggleGrid() {
		if (myGrid.getChildren().isEmpty()) {
			myGrid.getChildren().add(myLines);
		} else {
			myGrid.getChildren().clear();
		}
	}

	public void changeColor(Color color) {
		setBackground(new Background(new BackgroundFill(color,
				CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void update(Node node) {
		this.getChildren().clear();
		this.getChildren().add(myGrid);
		this.getChildren().add(node);

	}

}

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

/**
 * Component of SlogoWindow which shows turtle, lines, and grid.
 * @author Kevin Li
 *
 */
public class TurtleView extends PaneView {

	private static final long serialVersionUID = -6613430284719479884L;
	private static final int GRIDLINE_INTERVAL = 20;
	private static final double VIEW_HEIGHT_RATIO = 0.6875;
	private static final double VIEW_WIDTH_RATIO = 0.6;
	private Group myGrid;
	private Group myLines;

	/**
	 * The view in the center of the window with black background.
	 * Show the action of turtle, the lines drawn,
	 * and toggle whether or not to show the "reference" grid in light gray.
	 * @param width width of TurtleView
	 * @param height height of TurtleView
	 */
	public TurtleView(double width, double height) {
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		setBackground(new Background(new BackgroundFill(Color.BLACK,
				CornerRadii.EMPTY, Insets.EMPTY)));
		myGrid = new Group();
		myLines = makeGrid(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
	}

	/**
	 * Make the "reference" grid.
	 * @param width width of TurtleView
	 * @param height height of TurtleView
	 * @return Groups of light gray lines which consists of "reference" grid
	 */
	private Group makeGrid(double width, double height) {
		Group grid = new Group();
		for (double i = 0; i < width; i = i + GRIDLINE_INTERVAL) {
			Line line = new Line(i, 0, i, height);
			line.setStroke(Color.LIGHTGRAY);
			grid.getChildren().add(line);
		}
		for (double i = 0; i < height; i = i + GRIDLINE_INTERVAL) {
			Line line = new Line(0, i, width, i);
			line.setStroke(Color.LIGHTGRAY);
			grid.getChildren().add(line);
		}
		return grid;
	}

	/**
	 * If the grid is on, turn it off; if not, turn it on.
	 */
	public void toggleGrid() {
		if (myGrid.getChildren().isEmpty()) {
			myGrid.getChildren().add(myLines);
		} else {
			myGrid.getChildren().clear();
		}
	}

	/**
	 * Change the background color of the TurtleView.
	 * @param color background color
	 */
	public void changeColor(Color color) {
		setBackground(new Background(new BackgroundFill(color,
				CornerRadii.EMPTY, Insets.EMPTY)));
	}

	/**
	 * Update as part of Observer. Update when the Observable data changes
	 * @param node Node contains turtle, lines and stamp, passed from
	 * Turtle in model package
	 */
	public void update(Node node) {
		this.getChildren().clear();
		this.getChildren().add(myGrid);
		this.getChildren().add(node);

	}

}

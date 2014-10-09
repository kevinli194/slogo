package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TurtleView implements DisplayElement, Observer {
	private static final double width = 600;
	private static final double height = 600;
	private Pane myMainDisplay;

	public TurtleView() {

		myMainDisplay = new Pane();
		myMainDisplay.setStyle("-fx-background-color: black;");
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node generatePane() {
		// TODO Auto-generated method stub
		return myMainDisplay;
	}
}

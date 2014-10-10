package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class History extends Feature {

	private List<String> myHistory;
	private VBox myView;

	public History() {
		myHistory = new LinkedList<String>();
		// myView = new VBox();
		myView = new VBox();
		// myView.getChildren().add(text);

	}

	public void add(String element) {
		myHistory.add(element);
		myView.getChildren().add(new Text(element));
	}

	public void clear() {
		myHistory.clear();
		myView.getChildren().clear();
	}

	@Override
	public Node generateNode() {

		return myView;
	}
}

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
// NEEDS TO GET MOVED TO THE VIEW PACKAGE
public class History implements Feature {

	private List<String> myHistory;
	private VBox myView;

	public History() {
		myHistory = new LinkedList<String>();
		myView = new VBox();
	}

	public void add(String element) {
		myHistory.add(element);
		myView.getChildren().add(new Text(element));
	}

	@Override
	public void clear() {
		myHistory.clear();
		myView.getChildren().clear();
	}
	
	public Node generateNode() {

		return myView;
	}
}

package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import view.InputView;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

// NEEDS TO GET MOVED TO THE VIEW PACKAGE
public class History implements Feature {

	private List<String> myHistory;
	private InputView myInput;

	public History() {
		myHistory = new LinkedList<String>();
	}

	public void add(String element) {
		myHistory.add(element);
	}

	@Override
	public void clear() {
		myHistory.clear();
	}

	public List<String> generateNode() {
		return myHistory;
	}
}

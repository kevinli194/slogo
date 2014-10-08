package model;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.Node;

public class History extends Feature {

	private List<String> myHistory;

	public History() {
		myHistory = new LinkedList<String>();
	}

	public void add(String element) {
		myHistory.add(element);
	}

	public void clear() {
		myHistory.clear();
	}

	@Override
	public Node generateNode() {
		// TODO Auto-generated method stub
		return null;
	}

}

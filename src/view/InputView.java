package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

public class InputView implements DisplayElement, Observer {
	private static final double WIDTH = 1000;
	private static final double HEIGHT = 200;
	public TextArea myInputArea;

	public InputView() {
		myInputArea = new TextArea();
		myInputArea.setPrefHeight(HEIGHT);
		myInputArea.setPrefWidth(WIDTH);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node generatePane() {
		// TODO Auto-generated method stub
		return myInputArea;
	}

}

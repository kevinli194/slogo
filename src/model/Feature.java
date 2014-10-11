package model;

import view.InputView;
import javafx.scene.Node;

public abstract class Feature {

	Node myDisplay;

	public abstract Node generateNode();

	public Node generateNode(InputView myInputView) {
		return null;
	}

	public abstract void clear();
}

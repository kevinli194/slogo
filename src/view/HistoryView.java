package view;

import java.util.Map;

import model.Feature;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HistoryView extends ScrollPane {

	private static final double HISTORYVIEW_WIDTH = 200;
	private static final double HISTORYVIEW_HEIGHT = 600;

	// Test by setting myText as a string

	public HistoryView() {
		setPrefWidth(HISTORYVIEW_WIDTH);
		setPrefHeight(HISTORYVIEW_HEIGHT);
		setMaxSize(HISTORYVIEW_WIDTH, HISTORYVIEW_HEIGHT);
		
		// setText(myText);

	}

	public void update(Node node) {
		// Get the display contents from a class where all the history and
		// output value are stored.
		// myText=display.getContents();

		this.setContent(node);
	}
}

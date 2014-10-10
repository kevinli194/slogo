package view;

import java.util.Map;

import model.Feature;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HistoryView extends Pane {

	private static final double width = 200;
	private static final double height = 600;
	// Test by setting myText as a string
	private String myText = "forward 50\nRight 90\n";

	public HistoryView() {
		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
		

		VBox myGroup = new VBox();
		myGroup.getChildren().add(new Text("hi"));
		myGroup.getChildren().add(new Text("hi"));
		myGroup.getChildren().add(new Text("hi"));
		myGroup.getChildren().add(new Text("hi"));
		this.getChildren().add(myGroup);

		// setText(myText);

	}

	public void update(Node node) {
		// Get the display contents from a class where all the history and
		// output value are stored.
		// myText=display.getContents();
		this.getChildren().clear();
		this.getChildren().add(node);
	}
}

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

public class HistoryView extends ScrollPane implements View{

	private static final double HISTORYVIEW_WIDTH = 200;
	private static final double HISTORYVIEW_HEIGHT = 600;

	public HistoryView() {
		setView(HISTORYVIEW_WIDTH, HISTORYVIEW_HEIGHT);
	}

	@Override
	public void update(Node node) {
		this.setContent(node);
	}

	@Override
	public void setView(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
	}
}

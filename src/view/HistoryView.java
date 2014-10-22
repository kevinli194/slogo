package view;

import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HistoryView extends ScrollPane implements View {

	private static final double HISTORYVIEW_WIDTH = 200;
	private static final double HISTORYVIEW_HEIGHT = 600;
	private VBox myView;
	private InputView myInput;

	public HistoryView(InputView inputView) {
		setView(HISTORYVIEW_WIDTH, HISTORYVIEW_HEIGHT);
		myView = new VBox();
		myInput = inputView;
		this.setContent(myView);
	}

	// Takes the history and converts it into a graphical element
	public void update(List<String> history) {
		myView.getChildren().clear();
		for (String i : history) {
			addTextBox(i);
		}
	}

	@Override
	public void setView(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
	}

	// Duplicated code as in InstructionList. Refactor after combining model to
	// view;

	public void addTextBox(String s) {
		HBox row = new HBox();
		Text t = new Text();
		t.setText(s);

		t.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				myInput.addAndShowText(s);
			}
		});
		row.getChildren().add(t);
		myView.getChildren().add(row);
	}

}

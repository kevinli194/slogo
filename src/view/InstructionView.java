package view;

import instructions.Instruction;

import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InstructionView extends ScrollPane implements View {

	private static final double INSTRUCTIONVIEW_WIDTH = 200;
	private static final double INSTRUCTIONVIEW_HEIGHT = 600;
	private VBox myView;
	private InputView myInput;

	public InstructionView(InputView input) {
		setView(INSTRUCTIONVIEW_WIDTH, INSTRUCTIONVIEW_HEIGHT);
		myInput = input;
	}

	public void update(Map<String, Instruction> instructions) {
		myView.getChildren().clear();
		for (String s : instructions.keySet()) {
			HBox row = preDefinedInstructionRow(s);
			myView.getChildren().add(row);
		}
		this.setContent(myView);
	}

	@Override
	public void setView(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);

	}

	public HBox preDefinedInstructionRow(String s) {
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
		return row;
	}
}

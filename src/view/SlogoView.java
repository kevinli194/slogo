package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Feature;
import model.History;
import model.ObservableData;
import model.SlogoModel;

public class SlogoView extends BorderPane implements Observer {
	TurtleView myTurtleView;
	InputView myInputView;
	InstructionView myInstructionView;
	HistoryView myHistoryView;
	SlogoModel myModel;

	public SlogoView(String language, SlogoModel model) {
		myTurtleView = new TurtleView();
		myInputView = new InputView();
		myInstructionView = new InstructionView();
		myHistoryView = new HistoryView();
		myModel = model;

		setCenter(myTurtleView);
		setRight(myInstructionView);
		setBottom(myInputView);
		setLeft(myHistoryView);
		setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {

		setCenter(((ObservableData) arg).get("turtle").generateNode());
		setRight(((ObservableData) arg).get("instructions").generateNode());
		setBottom(((ObservableData) arg).get("input").generateNode());
		setLeft(((ObservableData) arg).get("history").generateNode());

	}
	// Updates the display based on the changes that occurred in the
	// environment.
	// @Override
	// public void update(Observable o, Object arg) {
	// }

}

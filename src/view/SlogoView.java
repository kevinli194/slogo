package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Feature;
import model.History;
import model.ObservableData;
import model.SlogoModel;

public class SlogoView extends BorderPane {
	TurtleView myTurtleView;
	InputView myInputView;
	InstructionView myInstructionView;
	HistoryView myHistoryView;
	SlogoModel myModel;
	ObservableData myOD;

	public SlogoView(String language, SlogoModel model) {
		myTurtleView = new TurtleView();
		myInputView = new InputView();
		myInstructionView = new InstructionView();
		myHistoryView = new HistoryView();
		myOD = new ObservableData();
		myModel = model;

		setCenter(myTurtleView.generatePane());
		setRight(myInstructionView.generatePane());
		setBottom(myInputView.generatePane());
		setLeft(myHistoryView.generatePane());
		setVisible(true);

		// Button to test code.
		setTop(makeButton("Move", new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myModel.moveTurtle();
			}
		}));

	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}

}

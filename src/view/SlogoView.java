package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.BorderPane;
import javafx.scene.Node;
import model.Feature;
import model.History;
import model.InstructionList;
import model.ObservableData;
import model.SlogoModel;
import model.Turtle;

public class SlogoView extends BorderPane implements Observer {
	TurtleView myTurtleView;
	InputView myInputView;
	InstructionView myInstructionView;
	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;
	ObservableData myOD;

	public SlogoView(String language, SlogoModel model) {
		myTurtleView = new TurtleView();
		myInputView = new InputView(model);
		myInstructionView = new InstructionView(myInputView);
		myHistoryView = new HistoryView(myInputView);
		mySettingsView = new SettingsView(model, myTurtleView);
		myOD = new ObservableData();
		myModel = model;

		setCenter(myTurtleView);
		setRight(myInstructionView);
		setBottom(myInputView);
		setLeft(myHistoryView);
		setTop(mySettingsView);
		setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {

		if (!arg.equals(myOD)) {
			myOD = (ObservableData) arg;
			Turtle turtle = (Turtle) ((ObservableData) arg).get("turtle");
			Node drawing = turtle.generateNode();
			myTurtleView.update(drawing);

			// InstructionList instrList=(InstructionList)((ObservableData)
			// arg).get("InstructionList");
			// Node instructionBox=instrList.generateNode(myInputView);
			// myInstructionView.update(instructionBox);
			myInstructionView.update(((InstructionList) ((ObservableData) arg)
					.get("InstructionList")).generate());
			myHistoryView.update(((History) ((ObservableData) arg)
					.get("history")).generate());
		}

	}

}

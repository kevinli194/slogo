package view;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.CommandsList;
import model.History;
import model.InstructionList;
import model.ObservableData;
import model.SlogoModel;
import model.Turtle;

public class SlogoWindow extends BorderPane implements Observer {
	KeyControls myControls;
	TurtleView myTurtleView;
	InputView myInputView;
	InstructionView myInstructionView;
	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;
	ObservableData myOD;

	public SlogoWindow(String language, double width, double height) {
		myModel = new SlogoModel();
		myModel.addObserver(this);
		myTurtleView = new TurtleView(width, height);
		myInputView = new InputView(myModel, width, height);
		myInstructionView = new InstructionView(myInputView, width, height);
		myHistoryView = new HistoryView(myInputView, width, height);
		mySettingsView = new SettingsView(myModel, myTurtleView, width, height);
		myOD = new ObservableData();

		setCenter(myTurtleView);
		setRight(myInstructionView);
		setBottom(myInputView);
		setLeft(myHistoryView);
		setTop(mySettingsView);
		setVisible(true);

		myControls = new KeyControls(myModel, this);

	}

	@Override
	public void update(Observable o, Object arg) {

		if (!arg.equals(myOD)) {
			myOD = (ObservableData) arg;
		}

		myTurtleView.update(( ((ObservableData) arg).getTurtle())
				.generate());
		
		// InstructionList instrList=(InstructionList)((ObservableData)
		// arg).get("InstructionList");
		// Node instructionBox=instrList.generateNode(myInputView);
		// myInstructionView.update(instructionBox);
		myInstructionView.update(((CommandsList) ((ObservableData) arg)
				.get("CommandsList")).generate());
		myHistoryView.update(((History) ((ObservableData) arg).get("history"))
				.generate());
	}

}

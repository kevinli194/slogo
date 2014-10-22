package view;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
//import main.KeyControls;
import model.CommandsList;

import model.History;
import model.InstructionList;
import model.ObservableData;
import model.SlogoModel;
import model.Turtle;

public class SlogoView implements Observer {
	Scene myScene;
	KeyControls myControls;
	BorderPane myView;
	TurtleView myTurtleView;
	InputView myInputView;
	InstructionView myInstructionView;
	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;
	ObservableData myOD;

	public SlogoView(String language, SlogoModel model, double width,
			double height) {
		myModel = model;
		myTurtleView = new TurtleView(width, height);
		myInputView = new InputView(myModel, width, height);
		myInstructionView = new InstructionView(myInputView, width, height);
		myHistoryView = new HistoryView(myInputView, width, height);
		mySettingsView = new SettingsView(myModel, myTurtleView, width, height);
		myOD = new ObservableData();

		myView = new BorderPane();
		myView.setCenter(myTurtleView);
		myView.setRight(myInstructionView);
		myView.setBottom(myInputView);
		myView.setLeft(myHistoryView);
		myView.setTop(mySettingsView);
		myView.setVisible(true);

		myScene = new Scene(myView, width, height);
		myControls = new KeyControls(myModel, myScene);

	}

	@Override
	public void update(Observable o, Object arg) {

		if (!arg.equals(myOD)) {
			myOD = (ObservableData) arg;
		}

		myTurtleView.update(((Turtle) ((ObservableData) arg).get("turtle"))
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

	public Scene generateScene() {

		return myScene;
	}

}

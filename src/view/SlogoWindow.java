package view;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.BorderPane;
import model.BackgroundColor;
import model.CommandsList;
import model.History;
import model.ObservableData;
import model.SlogoModel;

public class SlogoWindow extends BorderPane implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4532547099439124045L;
	KeyControls myControls;
	TurtleView myTurtleView;
	InputView myInputView;
	CommandsView myInstructionView;
	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;
	ObservableData myOD;

	public SlogoWindow(String language, double width, double height) {
		myModel = new SlogoModel();
		myModel.addObserver(this);
		myTurtleView = new TurtleView(width, height);
		myInputView = new InputView(myModel, width, height);
		myInstructionView = new CommandsView(myInputView, width, height);
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
		myModel.load();

	}

	@Override
	public void update(Observable o, Object arg) {

		if (!arg.equals(myOD)) {
			myOD = (ObservableData) arg;
		}

		myTurtleView.update((((ObservableData) arg).getTurtle()).generate());

		// InstructionList instrList=(InstructionList)((ObservableData)
		// arg).get("InstructionList");
		// Node instructionBox=instrList.generateNode(myInputView);
		// myInstructionView.update(instructionBox);
		myInstructionView.update(((CommandsList) ((ObservableData) arg)
				.get("CommandsList")).generate());
		myHistoryView.update(((History) ((ObservableData) arg).get("history"))
				.generate());
		myTurtleView.changeColor(((BackgroundColor) ((ObservableData) arg)
				.get("backgroundcolor")).generate());
		mySettingsView.changeBGPicked(((BackgroundColor) ((ObservableData) arg)
				.get("backgroundcolor")).generate());
		mySettingsView.changePenPicked(((ObservableData) arg)
				.getTurtle().getPen().getPenColor());
	}

}

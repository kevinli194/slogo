package view;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.BackgroundColor;
import model.CommandsList;
import model.History;
import model.InstructionList;
import model.ObservableData;
import model.SlogoModel;
import model.Turtle;
import model.VariablesList;

public class SlogoWindow extends BorderPane implements Observer {
	KeyControls myControls;
	TurtleView myTurtleView;
	InputView myInputView;
	CommandsView myCommandsView;
	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;
	ObservableData myOD;

	public SlogoWindow(String language, double width, double height) {
		myModel = new SlogoModel();
		myModel.addObserver(this);
		myTurtleView = new TurtleView(width, height);
		myInputView = new InputView(myModel, width, height);
		myCommandsView = new CommandsView(myInputView, width, height);
		myHistoryView = new HistoryView(myInputView, width, height);
		mySettingsView = new SettingsView(myModel, myTurtleView, width, height);
		myOD = new ObservableData();

		setCenter(myTurtleView);
		setRight(myCommandsView);
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
		myCommandsView.update(((CommandsList) ((ObservableData) arg)
				.get("CommandsList")).generate(), 
				((VariablesList) ((ObservableData) arg)
						.get("VariablesList")).generate());
		myHistoryView.update(((History) ((ObservableData) arg).get("history"))
				.generate());
		myTurtleView.changeColor(((BackgroundColor) ((ObservableData) arg)
				.get("backgroundcolor")).generate());
	}

}

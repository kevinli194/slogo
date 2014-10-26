package view;

import java.io.Serializable;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.BorderPane;
import model.BackgroundColor;
import model.CommandsList;
import model.History;
import model.ObservableData;
import model.SlogoModel;
import model.Turtle;
import model.VariablesList;

public class SlogoWindow extends BorderPane implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4532547099439124045L;
	KeyControls myControls;
	TurtleView myTurtleView;
	InputView myInputView;
	CommandsView myCommandsView;
	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;

	public SlogoWindow(Locale locale, double width, double height) {
		myModel = new SlogoModel(locale);
		myModel.addObserver(this);
		myTurtleView = new TurtleView(width, height);
		myInputView = new InputView(myModel, width, height);
		myCommandsView = new CommandsView(myInputView, width, height);
		myHistoryView = new HistoryView(myInputView, width, height);
		mySettingsView = new SettingsView(myModel, myTurtleView, width, height);

		setCenter(myTurtleView);
		setRight(myCommandsView);
		setBottom(myInputView);
		setLeft(myHistoryView);
		setTop(mySettingsView);
		setVisible(true);

//		myControls = new KeyControls(myModel, this);
		myModel.load();

	}

	@Override
	public void update(Observable o, Object arg) {

		myTurtleView.update((((ObservableData) arg).getTurtle()).generate());
		myCommandsView.update(
				((CommandsList) ((ObservableData) arg).get("CommandsList")),
				((VariablesList) ((ObservableData) arg).get("VariablesList")));
		myHistoryView.update(((History) ((ObservableData) arg).get("history"))
				.generate());
		myTurtleView.changeColor(((BackgroundColor) ((ObservableData) arg)
				.get("backgroundcolor")).generate());
		mySettingsView.changeBGPicked(((BackgroundColor) ((ObservableData) arg)
				.get("backgroundcolor")).generate());
		mySettingsView.changePenPicked(((ObservableData) arg).getTurtle()
				.getPen().getPenColor());
	}

}

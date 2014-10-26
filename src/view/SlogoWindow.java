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
import model.VariablesList;

public class SlogoWindow extends BorderPane implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4532547099439124045L;
	KeyControls myControls;
	TurtleView myTurtleView;
	InputView myInputView;
	DataView myDataView;
	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;

	public SlogoWindow(String language, double width, double height) {
		myModel = new SlogoModel();
		myModel.addObserver(this);
		myTurtleView = new TurtleView(width, height);
		myInputView = new InputView(myModel, width, height);
		myDataView = new DataView(myInputView, width, height);
		myHistoryView = new HistoryView(myInputView, width, height);
		mySettingsView = new SettingsView(myModel, myTurtleView, width, height);

		setCenter(myTurtleView);
		setRight(myDataView);
		setBottom(myInputView);
		setLeft(myHistoryView);
		setTop(mySettingsView);
		setVisible(true);
		myModel.load();
		myControls = new KeyControls(myModel, this);

	}

	@Override
	public void update(Observable o, Object arg) {

		myTurtleView.update((((ObservableData) arg).getTurtles()).generate());
		myDataView.update(
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

	public SlogoModel getModel() {
		return myModel;
	}

	public void loadFile(History history) {
		myModel.getMyData().loadFile(history);

	}

}

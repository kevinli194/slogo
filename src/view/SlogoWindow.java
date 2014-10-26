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
	HistoryResultsView myHistoryResultsView;
	SettingsView mySettingsView;
	SlogoModel myModel;

	public SlogoWindow(Locale locale, double width, double height) {
		myModel = new SlogoModel(locale);
		myModel.addObserver(this);
		myTurtleView = new TurtleView(width, height);
		myInputView = new InputView(myModel, width, height,locale);
		myDataView = new DataView(myInputView, width, height,locale);
		myHistoryResultsView = new HistoryResultsView(myInputView, width,
				height,locale);
		mySettingsView = new SettingsView(myModel, myTurtleView, width, height,locale);

		setCenter(myTurtleView);
		setRight(myDataView);
		setBottom(myInputView);
		setLeft(myHistoryResultsView);
		setTop(mySettingsView);
		setVisible(true);

		myModel.load();
		myControls = new KeyControls(myModel, this);

	}

	@Override
	public void update(Observable o, Object arg) {

		myTurtleView.update((((ObservableData) arg).getTurtle()).generate());
		myDataView.update(
				((CommandsList) ((ObservableData) arg).get("CommandsList")),
				((VariablesList) ((ObservableData) arg).get("VariablesList")));
		myHistoryResultsView.update(
				((History) ((ObservableData) arg).get("history")).generate(),
				((ObservableData) arg).getReturn());
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

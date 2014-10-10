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
		myInstructionView = new InstructionView();
		myHistoryView = new HistoryView();
		mySettingsView = new SettingsView(model);
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
		if (arg != myOD) {
			myOD = (ObservableData) arg;
			myTurtleView.update(((ObservableData) arg).get("turtle")
					.generateNode());
			myInstructionView.update();
			myHistoryView.update(((ObservableData) arg).get("history")
					.generateNode());
		}

	}

}

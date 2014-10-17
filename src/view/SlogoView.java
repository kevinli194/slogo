package view;

import java.util.Observable;
import java.util.Observer;



import javafx.scene.layout.BorderPane;
import javafx.scene.Node;
import model.Feature;
import model.ObservableData;
import model.SlogoModel;
import model.Turtle;

public class SlogoView extends BorderPane implements Observer {
	TurtleView myTurtleView;
	InputView myInputView;
//	InstructionView myInstructionView;
//	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;
	ObservableData myOD;

	public SlogoView(String language, SlogoModel model) {
		myTurtleView = new TurtleView();
		myInputView = new InputView(model);
//		myInstructionView = new InstructionView();
//		myHistoryView = new HistoryView();
		mySettingsView = new SettingsView(model, myTurtleView);
		myOD = new ObservableData();
		myModel = model;
	
		setCenter(myTurtleView);
//		setRight(myInstructionView);
		setBottom(myInputView);
//		setLeft(myHistoryView);
		setTop(mySettingsView);
		setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {

		if (arg != myOD) {
			myOD = (ObservableData) arg;
			Turtle turtle = (Turtle) ((ObservableData) arg).get("turtle");
			Node drawing = turtle.generateNode();
			myTurtleView.update(drawing);
//			myInstructionView.update(((ObservableData) arg).get("instructions").generateNode(myInputView));
//			myHistoryView.update(((ObservableData) arg).get("history")
//					.generateNode());
		}

	}

}

package view;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import model.Feature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class HistoryView implements DisplayElement, Observer {

	private static final double WIDTH = 200;
	private static final double HEIGHT = 600;
	private VBox myHistoryDisplay;


	public HistoryView() {
		myHistoryDisplay = new VBox();
		myHistoryDisplay.getChildren().add(makeButton("Move", new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			}
		}));
		myHistoryDisplay.setPrefHeight(HEIGHT);
		myHistoryDisplay.setPrefWidth(WIDTH);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}



	@Override
	public Node generatePane() {
		// TODO Auto-generated method stub
		return myHistoryDisplay;
	}
}

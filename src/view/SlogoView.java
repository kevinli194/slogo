package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Feature;
import model.SlogoModel;

public class SlogoView extends BorderPane implements Observer {
	Map<String, Feature> myData;
	Pane myTurtleView;
	TextArea myInputView;
	TableView<Button> myInstructionView;
	
	

	public SlogoView(String language, SlogoModel model) {
		setCenter(addPane());
		setRight(addCommandTable());
		setBottom(addInputTextArea());
		setLeft(addDisplayArea());
		setVisible(true);
		myData = new HashMap<String, Feature>();
	}

	private Pane addPane() {
		Pane pane = new TurtleView();
		return pane;
	}

	private TableView<Button> addCommandTable() {
		TableView<Button> commandTable = new InstructionView();
		return commandTable;
	}

	private TextArea addInputTextArea() {
		TextArea inputArea = new InputView();
		return inputArea;
	}

	private TextArea addDisplayArea() {
		TextArea displayArea = new HistoryView();
		return displayArea;
	}

	@Override
	public void update(Observable o, Object arg) {
		myData = (Map<String, Feature>) arg;

	}

	// Updates the display based on the changes that occurred in the
	// environment.
	// @Override
	// public void update(Observable o, Object arg) {
	// }

}

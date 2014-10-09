package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InstructionView implements DisplayElement, Observer {

	private static final double WIDTH = 200;
	private static final double HEIGHT = 600;
	private TableView<Button> myInstructionList;

	public InstructionView() {

		myInstructionList = new TableView<Button>();
		myInstructionList.setPrefHeight(HEIGHT);
		myInstructionList.setPrefWidth(WIDTH);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node generatePane() {
		// TODO Auto-generated method stub
		return myInstructionList;
	}
}

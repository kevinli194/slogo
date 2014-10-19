package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import view.InputView;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
// NEEDS TO GET MOVED TO THE VIEW PACKAGE
public class History implements Feature {

	private List<String> myHistory;
	private VBox myView;
	private InputView myInput;

	public History() {
		myHistory = new LinkedList<String>();
		myView = new VBox();
	}

	public void add(String element) {
		myHistory.add(element);
		myView.getChildren().add(new Text(element));
	}

	@Override
	public void clear() {
		myHistory.clear();
		myView.getChildren().clear();
	}
	
	public Node generateNode(InputView inputView) {
		myInput=inputView;
		return myView;
	}

	//Duplicated code as in InstructionList. Refactor after combining model to view;
	public void addTextBox(String s) {
		HBox row=new HBox();
		Text t=new Text();
		t.setText(s);

		t.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				myInput.addAndShowText(s);
			}
		});
		row.getChildren().add(t);
		myView.getChildren().add(row);
	}
}

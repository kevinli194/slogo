package view;

import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.SlogoModel;
import model.Turtle;

public class SlogoView extends BorderPane {
	

	public SlogoView(String language, SlogoModel model) {
		setCenter(addPane());
		setRight(addCommandTable());
		setBottom(addInputTextArea());
		setLeft(addDisplayArea());
		setVisible(true);
	}

	private Node addPane(){
		Node pane=new Spane();
		return pane;
	}
	
	private Node addCommandTable(){
		Node commandTable=new CommandTable();
		return commandTable;
	}
	
	private Node addInputTextArea(){
		Node inputArea=new InputTextArea();
		return inputArea;
	}
	
	private Node addDisplayArea() {
		Node displayArea=new DisplayTextArea();
		return displayArea;
	}
	
	
	// Updates the display based on the changes that occurred in the
	// environment.
//	@Override
//	public void update(Observable o, Object arg) {
//	}

}

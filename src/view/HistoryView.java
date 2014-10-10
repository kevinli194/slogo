package view;

import java.util.Map;

import model.Feature;
import javafx.scene.control.TextArea;

public class HistoryView extends TextArea {

	private static final double width = 200;
	private static final double height = 600;
	//Test by setting myText as a string
	private String myText="forward 50\nRight 90\n";

	public HistoryView() {
		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
		
		setText(myText);
		
	}

	public void update() {
		//Get the display contents from a class where all the history and 
		//output value are stored.
//		myText=display.getContents();
	}
	
}

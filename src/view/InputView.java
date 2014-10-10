package view;

import javafx.scene.control.TextArea;

public class InputView extends TextArea {
	private static final double width = 1000;
	private static final double height = 500;
	
	private String myText;

	public InputView() {
		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
	}

	public void addAndShowText(String text){
		myText+=text+"\n";
		setText(myText);

	}

}

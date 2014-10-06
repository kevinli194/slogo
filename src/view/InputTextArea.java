package view;

import javafx.scene.control.TextArea;

public class InputTextArea extends TextArea {
	private static final double width=1000;
	private static final double height=500;
	
	public InputTextArea(){
		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
	}
	
}

package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.TextArea;

public class DisplayTextArea extends TextArea implements Observer{

	private static final double width=200;
	private static final double height=600;
	
	public DisplayTextArea(){
		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}

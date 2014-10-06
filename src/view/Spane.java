package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;

public class Spane extends Pane implements Observer {
	private static final double width=600;
	private static final double height=600;
	
	public Spane(){
		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
		setStyle("-fx-background-color:black;");
	}

	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	
	
}

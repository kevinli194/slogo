package view;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;


public class InstructionView extends ScrollPane implements View{

	private static final double INSTRUCTIONVIEW_WIDTH = 200;
	private static final double INSTRUCTIONVIEW_HEIGHT = 600;

	public InstructionView() {
		setView(INSTRUCTIONVIEW_WIDTH,INSTRUCTIONVIEW_HEIGHT);
	}
	
	@Override
	public void update(Node node) {
		this.setContent(node);
	}

	@Override
	public void setView(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
		
	}
	
	
	        	
}

package view;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;


public class InstructionView extends ScrollPane {

	private static final double INSTRUCTIONVIEW_WIDTH = 200;
	private static final double INSTRUCTIONVIEW_HEIGHT = 600;

	public InstructionView() {
		setPrefWidth(INSTRUCTIONVIEW_WIDTH);
		setPrefHeight(INSTRUCTIONVIEW_HEIGHT);
		setMinSize(INSTRUCTIONVIEW_WIDTH, INSTRUCTIONVIEW_HEIGHT);
		setMaxSize(INSTRUCTIONVIEW_WIDTH, INSTRUCTIONVIEW_HEIGHT);
		

	}
	
	public void update(Node node) {
		
		this.setContent(node);
	}
	
	
	        	
}

package view;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;


public class InstructionView extends ScrollPane {

	private static final double width = 200;
	private static final double height = 600;

	public InstructionView() {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
		setMaxSize(width, height);
		
//		Text b=new Text();
//		b.setText("TRY");
//		setContent(b);
	}
	
	public void update(Node node) {
		
		this.setContent(node);
	}
	
	
	        	
}

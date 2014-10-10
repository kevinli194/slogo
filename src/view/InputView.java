package view;

import parser.Tokenizer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class InputView extends Pane {
	private static final double VIEW_WIDTH = 1000;
	private static final double VIEW_HEIGHT = 500;
	
	private TextArea myInput;
	private Button mySubmitButton;
	private Tokenizer myToken;
	private String myText="Let's gooooo\nXD";

	public InputView() {
	
		setPrefWidth(VIEW_WIDTH);
		setPrefHeight(VIEW_HEIGHT);
		setMaxSize(VIEW_WIDTH, VIEW_HEIGHT);
		update();
		this.getChildren().add(myInput);
		this.getChildren().add(mySubmitButton);
	}

	private void update() {
		myInput=new TextArea();
		myInput.setPrefWidth(VIEW_WIDTH-70);
		myInput.setPrefHeight(VIEW_HEIGHT);
		myInput.setMaxSize(VIEW_WIDTH-70, VIEW_HEIGHT);
		
		mySubmitButton=new Button();
		mySubmitButton.setText("Submit");
		mySubmitButton.setLayoutX(930);
		mySubmitButton.setLayoutY(0);
		mySubmitButton.setMinSize(70, 70);
		mySubmitButton.setOnAction(new EventHandler<ActionEvent>(){
			// give the string to the back end parser
			@Override
			public void handle(ActionEvent event) {
				myToken=new Tokenizer();
				myToken.tokenize(myInput.getText());
				System.out.println(myInput.getText());
				myInput.clear();
			}
			
		});
	}

	public void addAndShowText(String text){
		myText+=text+"\n";
		myInput.setText(myText);

	}

}

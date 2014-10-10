package view;

import model.SlogoModel;
import parser.Tokenizer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class InputView extends Pane {
	private static final double VIEW_WIDTH = 1000;
	private static final double VIEW_HEIGHT = 70;
	
	private TextArea myInput;
	private Button mySubmitButton;
	private SlogoModel myModel;
	private String myText="";

	public InputView(SlogoModel model) {
	
		setPrefWidth(VIEW_WIDTH);
		setPrefHeight(VIEW_HEIGHT);
		setMaxSize(VIEW_WIDTH, VIEW_HEIGHT);
		update();
		this.getChildren().add(myInput);
		this.getChildren().add(mySubmitButton);
		myModel=model;
	}

	private void update() {
		myInput=new TextArea();
		myInput.setPrefWidth(VIEW_WIDTH-70);
		myInput.setPrefHeight(VIEW_HEIGHT);
		myInput.setMaxSize(VIEW_WIDTH-70, VIEW_HEIGHT);
		myInput.setScrollLeft(30);
		
		mySubmitButton=new Button();
		mySubmitButton.setText("Submit");
		mySubmitButton.setLayoutX(930);
		mySubmitButton.setLayoutY(0);
		mySubmitButton.setMinSize(70, 70);
		mySubmitButton.setOnAction(new EventHandler<ActionEvent>(){
			// give the string to the back end parser
			@Override
			public void handle(ActionEvent event) {
				myModel.parseAndExecute(myInput.getText());
				System.out.println(myInput.getText());
				myInput.clear();
			}
			
		});
	}

	public void addAndShowText(String text){
		myText=myInput.getText();
		myText+=text+"\n";
		myInput.clear();
		myInput.setText(myText);

	}

}

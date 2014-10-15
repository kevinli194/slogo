package view;

import model.SlogoModel;
import parser.Tokenizer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class InputView extends Pane implements View{
	private static final double VIEW_WIDTH = 1000;
	private static final double VIEW_HEIGHT = 70;
	private static final double INPUT_WIDTH = 930;
	private static final double SUBMIT_BUTTON_X_LAYOUT = 930;
	private static final double SUBMIT_BUTTON_Y_LAYOUT = 0;
	private static final double SUBMIT_BUTTON_SIZE = 70;


	
	private TextArea myInput;
	private Button mySubmitButton;
	private SlogoModel myModel;
	private String myText="";

	public InputView(SlogoModel model) {
		setView(VIEW_WIDTH,VIEW_HEIGHT);
		update();
		this.getChildren().add(myInput);
		this.getChildren().add(mySubmitButton);
		myModel=model;
	}

	private void update() {
		setInputArea();
		
		setSubmitButton();
	}

	private void setSubmitButton() {
		mySubmitButton=new Button();
		mySubmitButton.setText("Submit");
		mySubmitButton.setLayoutX(SUBMIT_BUTTON_X_LAYOUT);
		mySubmitButton.setLayoutY(SUBMIT_BUTTON_Y_LAYOUT);
		mySubmitButton.setMinSize(SUBMIT_BUTTON_SIZE, SUBMIT_BUTTON_SIZE);
		mySubmitButton.setOnAction(new EventHandler<ActionEvent>(){
			// give the string to the back end parser
			@Override
			public void handle(ActionEvent event) {
				myModel.parseAndExecute(myInput.getText());
				System.out.println(myInput.getText());
				myModel.showToHistoryView(myInput.getText());
				myInput.clear();
			}
			
		});
	}

	private void setInputArea() {
		myInput=new TextArea();
		myInput.setPrefWidth(INPUT_WIDTH);
		myInput.setPrefHeight(VIEW_HEIGHT);
		myInput.setMaxSize(INPUT_WIDTH, VIEW_HEIGHT);
	}

	public void addAndShowText(String text){
		myText=myInput.getText();
		myText+=text+"\n";
		myInput.clear();
		myInput.setText(myText);
	}

	@Override
	public void setView(double width, double height) {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);		
	}

	@Override
	public void update(Node node) {
		update();
	}

}

package model;

import instructions.Instruction;

import java.util.HashMap;
import java.util.Map;

import view.InputView;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
// NEEDS TO GET MOVED TO THE VIEW PACKAGE
public class InstructionList implements Feature{
	private Map<String, Instruction> myBasicInstructions;
	private Map<String, Instruction> myUserDefinedFunctions;
	
	private VBox myView;
	private InputView myInput;

	// When instantiating an instruction list. The basic instructions should be
	// created. Should we use reflections for this?
	public InstructionList() {
		myBasicInstructions = new HashMap<String, Instruction>();
		myUserDefinedFunctions = new HashMap<String, Instruction>();
		
		myView=new VBox();
		//Testing data
		myBasicInstructions.put("forward", null);
		myBasicInstructions.put("back", null);

		initiateInstructionTable();
		
	}

	private void initiateInstructionTable() {
		for (String s:myBasicInstructions.keySet()){
			HBox row=preDefinedInstructionRow(s,myInput);
			myView.getChildren().add(row);
		}
	}

	/**
	 * Adds a user defined function to the map of functions.
	 * 
	 * @param instructionName
	 *            function identifier
	 * @param instruction
	 *            user defined function to be stored
	 */
	public void add(String instructionName, Instruction instruction) {
		myUserDefinedFunctions.put(instructionName, instruction);
	}

	/**
	 * Deletes a user defined function to the map of functions.
	 * 
	 * @param instructionName
	 *            name of function to delete
	 */
	public void delete(String instructionName) {
		myUserDefinedFunctions.remove(instructionName);
	}

	@Override
	/**
	 * Clears the map of user defined functions.
	 */
	public void clear() {
		myUserDefinedFunctions.clear();
	}
	
	public HBox preDefinedInstructionRow(String s, InputView input){
		myInput=input;
		HBox row=new HBox();
		Text t=new Text();
		t.setText(s);

		t.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				myInput.addAndShowText(s);
			}
		});
		row.getChildren().add(t);
		return row;
	}
	
	public Node generateNode(InputView inputView) {
		myInput=inputView;
		myView.getChildren().clear();
		for (String s:myBasicInstructions.keySet()){
			HBox row=preDefinedInstructionRow(s,inputView);
			myView.getChildren().add(row);
		}
	return myView;
	}





}

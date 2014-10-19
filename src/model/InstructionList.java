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
public class InstructionList implements Feature {
	private Map<String, Instruction> myBasicInstructions;
	private Map<String, Instruction> myUserDefinedFunctions;

	// When instantiating an instruction list. The basic instructions should be
	// created. Should we use reflections for this?
	public InstructionList() {
		myBasicInstructions = new HashMap<String, Instruction>();
		myUserDefinedFunctions = new HashMap<String, Instruction>();

		// Testing data
		myBasicInstructions.put("forward", null);
		myBasicInstructions.put("back", null);

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

	// Make sure to add for UserDefined Functions

	public Map<String, Instruction> generate() {
		return myBasicInstructions;
	}

}

package model;

import java.util.HashMap;
import java.util.Map;

import Instructions.Instruction;
import javafx.scene.Node;

public class InstructionList extends Feature {
	private Map<String, Instruction> myBasicInstructions;
	private Map<String, Instruction> myUserDefinedFunctions;

	// When instantiating an instruction list. The basic instructions should be
	// created. Should we use reflections for this?
	public InstructionList() {
		myBasicInstructions = new HashMap<String, Instruction>();
		myUserDefinedFunctions = new HashMap<String, Instruction>();

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

	/**
	 * Clears the map of user defined functions.
	 */
	public void clear() {
		myUserDefinedFunctions.clear();
	}

	@Override
	public Node generateNode() {
		// TODO Auto-generated method stub
		return null;
	}

}

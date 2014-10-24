package model;

import instructions.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//OUT-DATED CLASS. LOOK AT COMMANDS LIST.
/**
 * This class generates and creates the data structure used to store the
 * instructions (basic and user-defined) for the program.
 * 
 * @author Kevin Li
 * @author Meng'en Huang
 *
 */
public class InstructionList implements Feature {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6885485349507274301L;
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
	public void clear() {
		myUserDefinedFunctions.clear();
	}

	/**
	 * Returns the data held in the InstructionList model as a list of maps.
	 * 
	 * @return List containing the two maps for basic and user defined
	 *         functions.
	 */
	public List<Map<String, Instruction>> generate() {
		List<Map<String, Instruction>> instructions = new ArrayList<Map<String, Instruction>>();
		instructions.add(myBasicInstructions);
		instructions.add(myUserDefinedFunctions);
		return instructions;
	}
}

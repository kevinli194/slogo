package model;

import instructions.Instruction;

import java.util.HashMap;
import java.util.Map;

/**
 * VariablesList class. Maps variables to values and error checks for those
 * variables. This class is to be accessed by the commands.
 * 
 * @author slogo_team02 a.k.a. TEAM ROCKET
 *
 */

public class VariablesList implements Feature {
	private Map<String, Instruction> myVariables;

	public VariablesList() {
		myVariables = new HashMap<String, Instruction>();
	}

	public void add(String variableName, Instruction value) {
		// TODO: Update to throwing better errors (window perhaps)
		// Could maybe update to ask user if they want to overwrite
		// the variable
		if (myVariables.containsKey(variableName)) {
			System.out.println("VARIABLE ALREADY EXISTS.");
			return;
		}
		myVariables.put(variableName, value);
	}

	public Instruction get(String variableName) {
		// TODO: Update to throwing better errors (window perhaps)
		// Same error as one in REMOVE method
		if (!myVariables.containsKey(variableName)) {
			System.out.println("VARIABLE DOES NOT EXIST. CANNOT GET.");
			return null;
		}
		return myVariables.get(variableName);
	}

	public Instruction remove(String variableName) {
		// TODO: Update to throwing better errors (window perhaps)
		if (!myVariables.containsKey(variableName)) {
			System.out.println("VARIABLE DOES NOT EXIST. CANNOT REMOVE.");
			return null;
		}
		return myVariables.remove(variableName);
	}

	/**
	 * Clears list of variables
	 */

	@Override
	public void clear() {
		myVariables.clear();
	}

}

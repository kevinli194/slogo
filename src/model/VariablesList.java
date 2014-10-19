package model;

import java.util.HashMap;
import java.util.Map;

/**
 * VariablesList class.
 * Maps variables to values and error checks for
 * those variables.
 * This class is to be accessed by the commands.
 * 
 * @author slogo_team02 a.k.a. TEAM ROCKET
 *
 */
public class VariablesList implements Feature {
	private Map<String, Double> myVariables;

	public VariablesList() {
		myVariables = new HashMap<String, Double>();
	}

	public void add(String variableName, Double value) {
		// TODO: Update to throwing better errors (window perhaps)
		// Could maybe update to ask user if they want to overwrite
		// the variable
		if (myVariables.containsKey(variableName)) {
			System.out.println("VARIABLE ALREADY EXISTS.");
			return;
		}
		myVariables.put(variableName, value);
	}

	public void remove(String variableName) {
		// TODO: Update to throwing better errors (window perhaps)
		if (!myVariables.containsKey(variableName)) {
			System.out.println("VARIABLE DOES NOT EXIST.");
			return;
		}
		myVariables.remove(variableName);
	}
	
	/**
	 * Clears list of variables
	 */
	@Override
	public void clear() {
		myVariables.clear();
	}

}

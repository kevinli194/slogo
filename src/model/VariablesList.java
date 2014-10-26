package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import error_checking.ErrorDialog;

// TODO: NEED TO PUT STRINGS INTO RESOURCES
/**
 * VariablesList class. Maps variables to values and error checks for those
 * variables. This class is to be accessed by the commands.
 * 
 * @author slogo_team02 a.k.a. TEAM ROCKET
 *
 */

public class VariablesList implements Feature {
	private Map<String, Double> myVariables;
	private Stack<Map<String, Double>> myScope;

	// what is this?
	/**
	 * 
	 */
	private static final long serialVersionUID = 3790539722809452079L;


	public VariablesList() {
		myVariables = new HashMap<String, Double>();
		myScope = new Stack<Map<String, Double>>();
	}

	public void add(String variableName, double value) {
		// TODO: Update to throwing better errors (window perhaps)
		// Could maybe update to ask user if they want to overwrite
		// the variable
		myVariables.put(variableName, value);
	}

	public void addScope() {
		myScope.push(myVariables);
		myVariables = new HashMap<String, Double>(myVariables);
	}

	@Override
	public void remove(Object variableName) {
		// TODO: Update to throwing better errors (window perhaps)
		if (!myVariables.containsKey(variableName)) {
			new ErrorDialog("Variable %s does not exist.", variableName);

			System.out.println("VARIABLE DOES NOT EXIST. CANNOT REMOVE.");
		}
		myVariables.remove(variableName);
	}

	public void removeScope() {
		myVariables = myScope.pop();
	}

	public double get(String variableName) {
		// TODO: Update to throwing better errors (window perhaps)
		// Same error as one in REMOVE method
		if (!myVariables.containsKey(variableName)) {
			new ErrorDialog("Variable %s does not exist.", variableName);
			return 0; // CHANGE THIS
		}
		return myVariables.get(variableName);
	}


	public List<String> generate() {
		List<String> variableList = new ArrayList<String>();
		for (String s : myVariables.keySet()) {
			System.out.println(s);
			String element=s.trim().substring(1)+" : "+myVariables.get(s);
			variableList.add(element);
		}
		return variableList;
	}

	/**
	 * Clears list of variables
	 */

	@Override
	public void clear() {
		myVariables.clear();
	}

}

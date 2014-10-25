package model;

import instructions.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * VariablesList class. Maps variables to values and error checks for those
 * variables. This class is to be accessed by the commands.
 * 
 * @author slogo_team02 a.k.a. TEAM ROCKET
 *
 */

public class VariablesList implements Feature {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3790539722809452079L;
	private Map<String, Instruction> myVariables;

	public VariablesList() {
		myVariables = new HashMap<String, Instruction>();
	}

	public void add(String variableName, Instruction value) {
		// TODO: Update to throwing better errors (window perhaps)
		// Could maybe update to ask user if they want to overwrite
		// the variable
		myVariables.put(variableName, value);
	}

	@Override
	public void remove(Object variableName) {
		// TODO: Update to throwing better errors (window perhaps)
		if (!myVariables.containsKey(variableName)) {
			System.out.println("VARIABLE DOES NOT EXIST. CANNOT REMOVE.");
		}
		else myVariables.remove(variableName);
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
	
	public String[] generate(){
		List<String> variableList=new ArrayList<String>();
		for (String s:myVariables.keySet()){
			System.out.println(s);
			String element=s.trim().substring(1)+" : "+myVariables.get(s).execute(new ObservableData());
			variableList.add(element);
		}
		return variableList.toArray(new String[variableList.size()]);
	}


	/**
	 * Clears list of variables
	 */

	@Override
	public void clear() {
		myVariables.clear();
	}

}

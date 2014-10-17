package model;

import Instructions.Instruction;

import java.util.HashMap;
import java.util.Map;


public class VariablesList implements Feature {
	private Map<String, Instruction> myVariables;

	public VariablesList() {
		myVariables = new HashMap<String, Instruction>();
	}

	public void add(String variableName, Instruction value) {
		myVariables.put(variableName, value);
	}

	public void remove(String variableName) {
		myVariables.remove(variableName);
	}
	
	@Override
	public void clear() {
		myVariables.clear();
	}

}

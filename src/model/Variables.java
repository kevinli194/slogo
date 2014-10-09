package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import Instructions.Instruction;
import javafx.scene.Node;

public class Variables extends Observable implements Feature {
	private Map<String, Instruction> myVariables;

	public Variables() {
		myVariables = new HashMap<String, Instruction>();
	}

	public void add(String variableName, Instruction value) {
		myVariables.put(variableName, value);
	}

	public void remove(String variableName) {
		myVariables.remove(variableName);
	}

	@Override
	public Node generateNode() {
		// TODO Auto-generated method stub
		return null;
	}

}

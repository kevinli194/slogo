package model;

import java.util.HashMap;
import java.util.Map;

import Instructions.Instruction;
import javafx.scene.Node;

public class Variables extends Feature {
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

	public void clear() {
		// TODO Auto-generated method stub
		
	}

}

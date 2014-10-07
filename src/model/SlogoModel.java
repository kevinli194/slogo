package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Stack;

import Instructions.Instruction;

public class SlogoModel extends Observable {
	private Map<String, Feature> ObservableData;

	public SlogoModel() {
		ObservableData = new HashMap<String, Feature>();
		ObservableData.put("History", new History());
		ObservableData.put("Instruction List", new InstructionList());
		ObservableData.put("Turtle", new Turtle());
		ObservableData.put("Variables", new Variables());

	}

	public void executeCommands(Stack<Instruction> commandStack) {
		while (!commandStack.isEmpty()) {
			Instruction current = commandStack.pop();
			current.execute(ObservableData);
			setChanged();
			notifyObservers(ObservableData);
		}

	}
}

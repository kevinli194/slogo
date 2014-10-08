package model;

import java.util.Observable;
import java.util.Stack;

import parser.Parser;
import Instructions.Instruction;

public class SlogoModel extends Observable {
	private ObservableData myData;
	Parser myParser;

	public SlogoModel() {
		myData = new ObservableData();
		myParser = new Parser();
	}

	public void parseAndExecute(String s) {
		executeCommands((myParser.parse(s)));
	}

	public void executeCommands(Stack<Instruction> commandStack) {
		while (!commandStack.isEmpty()) {
			Instruction current = commandStack.pop();
			current.execute(myData);
			setChanged();
			notifyObservers(myData);
		}

	}
}

package model;

import java.util.Observable;
import java.util.Random;
import java.util.Stack;

import parser.Parser;
import Instructions.Instruction;

public class SlogoModel{
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
			current.execute(myData);		}

	}

	// Test code without the parser.

	public void moveTurtle() {
		Random rn = new Random();
		double x = rn.nextInt(50);
		((Turtle) myData.get("turtle")).rotate(30);
		((Turtle) myData.get("turtle")).moveTurtleAndDrawLine(10);

	}
}

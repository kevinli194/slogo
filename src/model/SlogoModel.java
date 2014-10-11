package model;

import java.util.Observable;
import java.util.Random;
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

	// Test code without the parser.

	public void load(){
		setChanged();
		notifyObservers(myData);
	}
	public void testThings() {
		Random rn = new Random();
		double x = rn.nextInt(50);
		((Turtle) myData.get("turtle")).rotate(x);
		((Turtle) myData.get("turtle")).moveTurtleAndDrawLine(10);
		((History) myData.get("history")).add("Turtle Rotated By: " + x);  
	}
	
 
	public void clear() {
		myData.clear();

	}

	public void showToHistoryView(String text) {
		((History) myData.get("history")).add(text+"\n");  

		
	}
}

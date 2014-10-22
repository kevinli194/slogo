package model;

import instructions.Instruction;

import java.io.IOException;
import java.util.Observable;
import java.util.Random;
import java.util.Stack;

import parser.Parser;

public class SlogoModel extends Observable {
	private static final String HELP_URL = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
	private ObservableData myData;
	Parser myParser;

	public SlogoModel() {
		myData = new ObservableData();
		myParser = new Parser();
	}

	public void parseAndExecute(String s) {
		executeCommands((myParser.parse(s)));
		showToHistoryView(s);
	}

	public void executeCommands(Stack<Instruction> commandStack) {
		while (!commandStack.isEmpty()) {
			Instruction current = commandStack.pop();
			double returnValue = current.execute(myData);
			showOnView(returnValue);
			load();
		}
	}

	private void showOnView(double returnValue) {
		((History) myData.get("history")).add("Final Return: " + returnValue
				+ "\n");
		setChanged();
		notifyObservers(myData);
	}

	public void load() {
		setChanged();
		notifyObservers(myData);
	}

	public void testThings() {
		Random rn = new Random();
		double x = rn.nextInt(50);
		((Turtle) myData.get("turtle")).rotate(x);
		((Turtle) myData.get("turtle")).moveTurtleAndDrawLine(10);
		((History) myData.get("history")).add("Turtle Rotated By: " + x);
		setChanged();
		notifyObservers(myData);
	}

	public void clear() {
		myData.clear();
		setChanged();
		notifyObservers(myData);
	}

	public void showToHistoryView(String text) {
		((History) myData.get("history")).add(text);
		setChanged();
		notifyObservers(myData);

	}

	public void accessHelpHTML() {
		try {
			Runtime.getRuntime().exec(
					new String[] { "/usr/bin/open", HELP_URL });
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void changeInfoVis() {
		((Turtle) myData.get("turtle")).switchInfoVis();

	}

	public ObservableData getMyData() {
		return myData;
	}

	public Parser getParser() {
		return myParser;
	}


}

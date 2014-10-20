package model;

import instructions.Instruction;

import java.io.IOException;
import java.util.Observable;
import java.util.Random;
import java.util.Stack;

import javafx.application.Application;
import parser.Parser;

public class SlogoModel extends Observable {
	private static final String HELP_URL="http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
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
			double returnValue = current.execute(myData);
			showOnView(returnValue);
			setChanged();
			notifyObservers(myData);
		}
	}

	private void showOnView(double returnValue) {
		((History) myData.get("history")).add("final return:" + returnValue
				+ "\n");
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
	}

	public void clear() {
		myData.clear();
	}

	public void showToHistoryView(String text) {
		((History) myData.get("history")).add(text);

	}

	public void accessHelpHTML() {
		 try {
			 Runtime.getRuntime().exec(
					 new String[] {
					 "/usr/bin/open", HELP_URL
					 });
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}

}

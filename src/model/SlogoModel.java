package model;

import instructions.Instruction;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Observable;
import java.util.Random;
import java.util.Stack;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import parser.Parser;

public class SlogoModel extends Observable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7452943156645209670L;
	private static final String HELP_URL = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
	private ObservableData myData;
	private Locale myLocale;
	Parser myParser;

	public SlogoModel(Locale locale) {
		myLocale=locale;
		myData = new ObservableData(myLocale);
		myParser = new Parser(myData);
	}

	public void parseAndExecute(String s) {

		if (executeCommands((myParser.parse(s)))) {
			showToHistoryView(s);
		}
	}

	public boolean executeCommands(Stack<Instruction> commandStack) {
		if (commandStack.isEmpty()) {
			return false;
		} else {
			while (!commandStack.isEmpty()) {
				Instruction current = commandStack.pop();
				((History) myData.get("history")).addSaved(current);
				double returnValue = current.execute(myData);
				showOnView(returnValue);
			}
			return true;
		}
	}

	private void showOnView(double returnValue) {

		myData.changeReturn(returnValue);
		load();
	}

	public void load() {
		setChanged();
		notifyObservers(myData);
	}

	public void toggleTurtle() {
		myData.getTurtle().toggleVisible();
		load();
	}

	public void testThings() {
		Random rn = new Random();
		double x = rn.nextInt(50);
		myData.getTurtle().rotate(x);
		myData.getTurtle().moveTurtleAndDrawLine(10);
		load();
	}

	public void clear() {
		myData.clear();
		myData.getTurtle().getPen().clear();
		load();
	}

	public void showToHistoryView(String text) {
		((History) myData.get("history")).add(text);
		load();

	}

	public void accessHelpHTML() {
		try {
			Runtime.getRuntime().exec(
					new String[] { "/usr/bin/open", HELP_URL });

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObservableData getMyData() {
		return myData;
	}

	public Parser getParser() {
		return myParser;
	}

	public void initializeBGColor(ObservableList<Color> customColors) {
		((BackgroundColor) myData.get("backgroundcolor"))
				.setCustom(customColors);

	}

	public void initializePenColor(ObservableList<Color> customColors) {
		myData.getTurtle().setPenCustom(customColors);

	}

	public void rerun() {
		for (Instruction s : ((History) myData.get("history")).getSavedData()) {
			s.execute(myData);
		}
		setChanged();
		notifyObservers(myData);

	}

}

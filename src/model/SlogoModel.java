package model;

import instructions.Instruction;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Observable;
import java.util.Random;
import java.util.Stack;

import error_checking.ErrorDialog;
import error_checking.InstructionDefineException;
import error_checking.InvalidArgumentsException;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import parser.Parser;

/**
 * The model class of the program. The Observable class that notifies
 * the observer when elements get changed.
 * @author Kevin Li
 * @author Mengen Huang
 *
 */
public class SlogoModel extends Observable{

	private static final long serialVersionUID = -7452943156645209670L;
	private static final String HELP_URL = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
	private ObservableData myData;
	private Locale myLocale;
	Parser myParser;

	/**
	 * Create the model.
	 * @param locale the language and locale the model uses
	 */
	public SlogoModel(Locale locale) {
		myLocale = locale;
		myData = new ObservableData(myLocale);
		myParser = new Parser(myData, myLocale);
	}

	/**
	 * Parse and execute the input passed from the front-end view package.
	 * @param s Command user typed in and passed from view
	 * @throws InvalidArgumentsException throw the exception
	 * when the command is invalid
	 */
	public void parseAndExecute(String s) throws InvalidArgumentsException {

		if (executeCommands(myParser.parse(s))) {
			showToHistoryView(s);
		}
	}

	/**
	 * Execute the command in the commandStack.
	 * @param commandStack The stack where stores all the commands to be processed
	 * @return If the stack is empty
	 * @throws InvalidArgumentsException throw the exception
	 * when the command in invalid
	 */
	public boolean executeCommands(Stack<Instruction> commandStack) {
		if (commandStack.isEmpty()) {
			return false;
		} else {
			try {
				while (!commandStack.isEmpty()) {
					Instruction current = commandStack.pop();
					double returnValue = current.execute(myData);
					showOnView(returnValue);
					((History) myData.get("history")).addSaved(current);
				}
				return true;
			} catch (InvalidArgumentsException | InstructionDefineException e) {
				new ErrorDialog(e.getMessage());
				return false;
			}
		}
	}

	/**
	 * Show the command return value on view.
	 * @param returnValue command return value
	 */
	private void showOnView(double returnValue) {

		myData.changeReturn(returnValue);
		load();
	}

	/**
	 * Notify the observers about the change and passed in the observable data.
	 */
	public void load() {
		setChanged();
		notifyObservers(myData);
	}

	/**
	 * Set the reference grid visible.
	 */
	public void toggleTurtle() {
		myData.getTurtle().toggleVisible();
		load();
	}

	/**
	 * Clear the data in Observable Data.
	 */
	public void clear() {
		myData.clear();
		myData.getTurtle().getPen().clear();
		load();
	}

	/**
	 * Display the string to the History view.
	 * @param text The text to show in history view
	 */
	public void showToHistoryView(String text) {
		((History) myData.get("history")).add(text);
		load();

	}

	/**
	 * Access the Help HTML page.
	 */
	public void accessHelpHTML() {
		try {
			Runtime.getRuntime().exec(
					new String[] {"/usr/bin/open", HELP_URL });

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the observable data.
	 * @return the observable data
	 */
	public ObservableData getMyData() {
		return myData;
	}

	/**
	 * Get the parser of the model.
	 * @return the parser of the model
	 */
	public Parser getParser() {
		return myParser;
	}

	/**
	 * Get the locale of the model.
	 * @return the locale of the model
	 */
	public Locale getLocale() {
		return myLocale;
	}

	/**
	 * Initialize the background color.
	 * @param customColors The list of custom colors
	 */
	public void initializeBGColor(ObservableList<Color> customColors) {
		((BackgroundColor) myData.get("backgroundcolor"))
		.setCustom(customColors);

	}

	/**
	 * Initialize the  pen color.
	 * @param customColors list of customized colo
	 */
	public void initializePenColor(ObservableList<Color> customColors) {
		myData.getTurtle().setPenCustom(customColors);

	}

	/**
	 * Get the saved history commands and rerun all the commands.
	 * @throws InvalidArgumentsException Throw the exception
	 * when the commands is invalid
	 */
	public void rerun() throws InvalidArgumentsException {
		for (Instruction s : ((History) myData.get("history")).getSavedData()) {
			s.execute(myData);
		}
		load();

	}

	/**
	 * Set the size of the pen stroke.
	 * @param width width of the pen stroke
	 */
	public void setPenSize(double width) {
		myData.getTurtle().getPen().setStrokeWidth(width);

	}

}

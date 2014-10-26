package model;

import instructions.Instruction;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that contains the data storing the history of all the commands used.
 * 
 * @author Kevin Li
 *
 */
public class History implements Feature {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6540827775550421541L;
	private List<String> myDisplayedHistory;
	private List<Instruction> mySavedHistory;

	public History() {
		myDisplayedHistory = new LinkedList<String>();
		mySavedHistory = new LinkedList<Instruction>();
	}

	/**
	 * Adds a history element to the history list.
	 * 
	 * @param element
	 *            history element
	 */

	public void add(String element) {
		myDisplayedHistory.add(element);
	}

	public void addSaved(Instruction element) {
		mySavedHistory.add(element);
	}

	@Override
	public void clear() {
		myDisplayedHistory.clear();
		mySavedHistory.clear();
	}

	/**
	 * Returns the data structure containing the history to be displayed.
	 * 
	 * @return myHistory - a list of strings containing the displayed history.
	 */

	public List<String> generate() {
		return myDisplayedHistory;
	}

	public List<Instruction> getSavedData() {
		return mySavedHistory;
	}

	@Override
	public void remove(Object n) {
		myDisplayedHistory.remove(n);
	}
}

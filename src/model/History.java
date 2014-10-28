package model;

import instructions.Instruction;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that contains the data storing the history of all the commands used.
 * @author Kevin Li
 *
 */
public class History implements Feature {

	private static final long serialVersionUID = 6540827775550421541L;
	private List<String> myDisplayedHistory;
	private List<Instruction> mySavedHistory;

	/**
	 * History model that saved typed-in commands history and history
	 * of commands from all sources(inputView, keyboard).
	 */
	public History() {
		myDisplayedHistory = new LinkedList<String>();
		mySavedHistory = new LinkedList<Instruction>();
	}

	/**
	 * Add a history element to the displayed history list.
	 * @param element history element
	 */

	public void add(String element) {
		myDisplayedHistory.add(element);
	}

	/**
	 * Add a history element to the overall history list.
	 * @param element
	 */
	public void addSaved(Instruction element) {
		mySavedHistory.add(element);
//		System.out.println("Saved Correct Element");
	}


	/**
	 * Clear all the elements in history lists.
	 */
	@Override
	public void clear() {
		myDisplayedHistory.clear();
		mySavedHistory.clear();
	}

	/**
	 * Returns the data structure containing the history to be displayed.
	 * @return myHistory  a list of strings containing the displayed history.
	 */
	public List<String> generate() {
		return myDisplayedHistory;
	}

	/**
	 * Get the list of overall commands history.
	 * @return the overall commands history 
	 */
	public List<Instruction> getSavedData() {
		return mySavedHistory;
	}

	/**
	 * Remove an element from the displayed history list.
	 */
	@Override
	public void remove(Object n) {
		myDisplayedHistory.remove(n);
	}
}

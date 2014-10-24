package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that contains the data storing the history of all the commands used.
 * 
 * @author Kevin Li
 *
 */
public class History implements Feature {

	private List<String> myHistory;

	public History() {
		myHistory = new LinkedList<String>();
	}

	/**
	 * Adds a history element to the history list.
	 * 
	 * @param element
	 *            history element
	 */

	public void add(String element) {
		myHistory.add(element);
	}

	@Override
	public void clear() {
		myHistory.clear();
	}

	/**
	 * Returns the data structure containing the history.
	 * 
	 * @return myHistory - a list of strings containing the history.
	 */

	public List<String> generate() {
		return myHistory;
	}

	@Override
	public void remove(Object n) {
		myHistory.remove(n);
	}
}

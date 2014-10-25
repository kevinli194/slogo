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

	/**
	 * 
	 */
	private static final long serialVersionUID = 6540827775550421541L;
	private List<String> myDisplayedHistory;
	private List<String> myCompleteHistory;

	public History() {
		myDisplayedHistory = new LinkedList<String>();
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

	@Override
	public void clear() {
		myDisplayedHistory.clear();
	}

	/**
	 * Returns the data structure containing the history.
	 * 
	 * @return myHistory - a list of strings containing the history.
	 */

	public List<String> generate() {
		return myDisplayedHistory;
	}

	@Override
	public void remove(Object n) {
		myDisplayedHistory.remove(n);
	}
}

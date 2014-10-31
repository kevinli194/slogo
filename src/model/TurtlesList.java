package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The list of turtles representing multiple turtles in one tab.
 * @author Kevin Li
 *
 */
public class TurtlesList implements Feature {

	private static final long serialVersionUID = 7316151669215320429L;
	private List<Turtle> allTurtles;
	private List<Integer> activeIDs;
	private Stack<List<Integer>> turtleScope;

	/**
	 * Instantiate the turtlesList.
	 */
	public TurtlesList() {
		allTurtles = new ArrayList<Turtle>();
		activeIDs = new ArrayList<Integer>();
		turtleScope = new Stack<List<Integer>>();
		addTurtle();
	}

	/**
	 * Get the number of the turtles in the list.
	 * @return number of the turtles in the list
	 */
	public double getNumTurtles() {
		return (double) allTurtles.size();
	}

	/**
	 * Add in turtle in the list.
	 */
	public void addTurtle() {
		allTurtles.add(new Turtle());
		activeIDs.add(allTurtles.size());
	}

	/**
	 * Add active turtles to the scope.
	 * @param active
	 */
	public void addScope(List<Integer> active) {
		turtleScope.push(activeIDs);
		setActive(active);
	}

	/**
	 * Remove turtle in the turtleScop.
	 */
	public void removeScope() {
		activeIDs = turtleScope.pop();
	}

	/**
	 * Set the active turtle list.
	 * @param active list of active turtle's ID
	 */
	public void setActive(List<Integer> active) {
		activeIDs = active;
	}

	/**
	 * Set the turtles inactive.
	 * @param inactive list of inactive turtles
	 */
	public void setInactive(List<Integer> inactive) {
		activeIDs.removeAll(inactive);
	}

	/**
	 * Get the active ID of the turtle.
	 * @return the ID of the active turtle
	 */
	public double getActiveID() {
		return (double) activeIDs.get(activeIDs.size()-1);
	}

	/**
	 * Clear and initiate the turtle list.
	 */
	@Override
	public void clear() {
		allTurtles.clear();
		activeIDs.clear();
		addTurtle();
	}

	@Override
	public void remove(Object n) {

	}

}

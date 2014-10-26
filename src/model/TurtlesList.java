package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TurtlesList implements Feature {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7316151669215320429L;
	private List<Turtle> allTurtles;
	private List<Integer> activeIDs;
	private Stack<List<Integer>> turtleScope;
	
	public TurtlesList() {
		allTurtles = new ArrayList<Turtle>();
		activeIDs = new ArrayList<Integer>();
		turtleScope = new Stack<List<Integer>>();
		addTurtle();
	}
	
	public void addTurtle() {
		allTurtles.add(new Turtle());
		activeIDs.add(allTurtles.size());
	}
	
	public void addScope(List<Integer> active) {
		turtleScope.push(activeIDs);
		setActive(active);
	}
	
	public void removeScope() {
		activeIDs = turtleScope.pop();
	}
	
	public void setActive(List<Integer> active) {
		activeIDs = active;
	}
	
	public void setInactive(List<Integer> inactive) {
		activeIDs.removeAll(inactive);
	}

	public double getActiveID() {
		return (double) activeIDs.get(activeIDs.size()-1);
	}
	
	@Override
	public void clear() {
		allTurtles.clear();
		activeIDs.clear();
		addTurtle();
	}

	@Override
	public void remove(Object n) {
		// TODO Auto-generated method stub

	}

}

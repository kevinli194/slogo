package model;

import java.util.ArrayList;
import java.util.List;

public class TurtlesList implements Feature {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7316151669215320429L;
	private List<Turtle> allTurtles;
	private List<Integer> activeTurtles;
	
	public TurtlesList() {
		allTurtles = new ArrayList<Turtle>();
		activeTurtles = new ArrayList<Integer>();
		addTurtle();
	}
	
	public void addTurtle() {
		allTurtles.add(new Turtle());
		activeTurtles.add(allTurtles.size());
	}
	
	public void setActive(List<Integer> active) {
		activeTurtles = active;
	}
	
	public void setInactive(List<Integer> inactive) {
		activeTurtles.removeAll(inactive);
	}
	
	public List<Integer> getActiveIDs() {
		return new ArrayList<Integer>(activeTurtles);
	}
	
	@Override
	public void clear() {
		allTurtles.clear();
		activeTurtles.clear();
		addTurtle();
	}

	@Override
	public void remove(Object n) {
		// TODO Auto-generated method stub

	}

}

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class TurtlesList extends TurtleAbstract {
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

	public List<Turtle> getActiveTurtles() {
		List<Turtle> activeTurtles = new ArrayList<Turtle>();
		for (int id : activeIDs) {
			activeTurtles.add(allTurtles.get(id));
		}
		return activeTurtles;
	}

	public double getNumTurtles() {
		return (double) allTurtles.size();
	}

	public void addTurtle() {
		allTurtles.add(new Turtle());
		activeIDs.add(allTurtles.size()-1);
		
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
		while (Collections.max(active) >= allTurtles.size()) {
			allTurtles.add(new Turtle());
		}
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

	}

	public void runTurtleMethod(Consumer<Turtle> lambda) {
		activeIDs.forEach((id) -> lambda.accept(allTurtles.get(id)));
	}

	public ImageView getTurtleImg() {
		int currID = activeIDs.get(activeIDs.size() - 1);
		return allTurtles.get(currID).getTurtleImg();
	}

	@Override
	public Node generate() {
		Group root = new Group();
		for (int i = 0; i < allTurtles.size(); i++) {
			if (activeIDs.contains(i)) {
				allTurtles.get(i).setState(true);
			} else {
				allTurtles.get(i).setState(false);
			}
			root.getChildren().add(allTurtles.get(i).generate());
		}
		return root;
	}

	@Override
	public void toggleVisible() {
		activeIDs.forEach((id) -> allTurtles.get(id).toggleVisible());
	}

	public void clearPens() {
		activeIDs.forEach((id) -> allTurtles.get(id).getPen().clear());
	}

	public Color getPenColor() {
		int currID = activeIDs.get(activeIDs.size()-1);
		return allTurtles.get(currID).getPen().getPenColor();
	}

	public void changePenColor(Color value) {
		activeIDs.forEach((id) -> allTurtles.get(id).changePenColor(value));
	}
	

	
}

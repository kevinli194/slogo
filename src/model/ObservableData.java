package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 
 * @author Jennie Ju
 * @author Kevin Li
 *
 */
public class ObservableData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8636982923572910062L;
	private Map<String, Feature> myFeatures;
	private Turtle myTurtle;

	private Locale myLocale;

	private double myReturn;
	private TurtlesList myTurtles;

	public ObservableData(Locale locale) {
		myFeatures = new HashMap<String, Feature>();
		myTurtle = new Turtle();
		myLocale=locale;

		myReturn = new Double(0);
		myTurtles = new TurtlesList();

		// Add new features to this list
		addAllToMyFeatures(new History(), new VariablesList(),
				new CommandsList(myLocale), new BackgroundColor());
	}

	private void addAllToMyFeatures(Feature... features) {
		for (Feature f : features) {
			String classKey = f.getClass().getSimpleName();
			classKey = classKey.toLowerCase();
			myFeatures.put(classKey, f);
		}
	}

	public Turtle getTurtle() {
		return myTurtle;
	}

	/**
	 * Gets the TurtlesList for all turtles in the current program
	 * 
	 * @return TurtlesList for the current program
	 */
	public TurtlesList getTurtles() {
		return myTurtles;
	}

	// If feature needed, get feature by class name
	public Feature get(String classKey) {
		classKey = classKey.toLowerCase();
		if (myFeatures.containsKey(classKey)) {
			return myFeatures.get(classKey);
		}
		return null;
	}

	public void clear() {

		for (String key : myFeatures.keySet()) {
			myFeatures.get(key).clear();
		}
		myTurtle.clear();

	}

	public void loadFile(History history) {
		myFeatures.put("history", history);
	}

	public void changeReturn(double returnValue) {
		myReturn = returnValue;

	}

	public double getReturn() {
		return myReturn;
	}
}

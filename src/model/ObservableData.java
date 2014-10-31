package model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * All the data that can be observed by the front-end view package.
 * @author Jennie Ju
 * @author Kevin Li
 *
 */
public class ObservableData {
	private Map<String, Feature> myFeatures;
	private Turtle myTurtle;

	private Locale myLocale;

	private String myReturn;

	private TurtlesList myTurtles;

	/**
	 * Create the ObservableData class.
	 * @param locale language and locale the current model uses
	 */
	public ObservableData(Locale locale) {
		myFeatures = new HashMap<String, Feature>();
		myTurtle = new Turtle();

		myLocale = locale;

		myReturn = new String("");

		myTurtles = new TurtlesList();

		// Add new features to this list
		addAllToMyFeatures(new History(), new VariablesList(),
				new CommandsList(myLocale), new BackgroundColor());
	}

	/**
	 * Add all the observable class in model package to the feature map.
	 * @param features features to add into the feature map
	 */
	private void addAllToMyFeatures(Feature... features) {
		for (Feature f : features) {
			String classKey = f.getClass().getSimpleName();
			classKey = classKey.toLowerCase();
			myFeatures.put(classKey, f);
		}
	}

	/**
	 * Get the Turtle class in model package.
	 * @return Turtle class
	 */
	public Turtle getTurtle() {
		return myTurtle;
	}

	/**
	 * Gets the TurtlesList for all turtles in the current program.
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

	/**
	 * Clear the feature map.
	 */
	public void clear() {

		for (String key : myFeatures.keySet()) {
			myFeatures.get(key).clear();
		}
		myTurtle.clear();
		myReturn = new String("");

	}

	/**
	 * Load the window by taking in History.
	 * @param history
	 */
	public void loadFile(History history) {
		myFeatures.put("history", history);
	}

	/**
	 * Update the content of Return Value View.
	 * @param returnValue the updated command return value
	 */
	public void changeReturn(double returnValue) {
		myReturn = new String("" + returnValue);

	}

	/**
	 * Get the updated command return value.
	 * @return updated command return value
	 */
	public String getReturn() {
		return myReturn;
	}
}

package model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jennie Ju
 * @author Kevin Li
 *
 */
public class ObservableData {
	private Map<String, Feature> myFeatures;

	public ObservableData() {
		myFeatures = new HashMap<String, Feature>();

		// Add new features to this list
		addAllToMyFeatures(new Turtle(), 
				new History(), 
				new InstructionList(),
				new VariablesList(),
				new CommandsList());
	}

	private void addAllToMyFeatures(Feature... features) {
		for (Feature f : features) {
			String classKey = f.getClass().getSimpleName();
			classKey = classKey.toLowerCase();
			myFeatures.put(classKey, f);
		}
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

	}
}

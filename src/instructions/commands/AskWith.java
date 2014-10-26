package instructions.commands;

import java.util.ArrayList;
import java.util.List;

import model.ObservableData;
import model.TurtlesList;

public class AskWith extends Ask {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4678770259623967913L;
	private static final int CONDITION_PARAM = 0;
	private static final int COMMANDS_PARAM = 0;
	
	
	@Override
	public double execute(ObservableData data) {
		TurtlesList turtles = data.getTurtles();
		List<Integer> tryTurtles = new ArrayList<Integer>();
		List<Integer> acceptedTurtles = new ArrayList<Integer>();
		for (int i = 0; i < turtles.getNumTurtles(); i++) {
			tryTurtles.set(0, i);
			double bool = super.askTurtles(acceptedTurtles, CONDITION_PARAM, data);
			if (bool == 1) {
				acceptedTurtles.add(i);
			}
		}
		
		return super.askTurtles(acceptedTurtles, COMMANDS_PARAM, data);
	}
}

package instructions.commands;

import java.util.List;

import model.ObservableData;
import model.TurtlesList;

public class Ask extends Tell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2864842923015655374L;

	public Ask() {
		super.numParams = 2; // make constant
	}

	@Override
	public double execute(ObservableData data) {
		List<Integer> askedIdInts = super.getAskedIDs(data,0);
		return askTurtles(askedIdInts, 1, data);
	}
	
	protected double askTurtles(List<Integer> askedIDs, int commandInd, ObservableData data) {
		TurtlesList turtles = data.getTurtles();
		turtles.addScope(askedIDs);
		double retVal = super.myParams.get(1).execute(data);
		turtles.removeScope();
		return retVal;
	}



}

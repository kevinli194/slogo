package instructions.commands;

import java.util.List;
import error_checking.InvalidArgumentsException;
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
	public double execute(ObservableData data) throws InvalidArgumentsException {
		List<Integer> askedIdInts = super.getAskedIDs(data,0);
		TurtlesList turtles = data.getTurtles();
		turtles.addScope(askedIdInts);
		double retVal = super.myParams.get(1).execute(data);
		turtles.removeScope();

		return retVal;
	}



}

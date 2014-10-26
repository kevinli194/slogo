package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.TurtlesList;

public class NumTurtles extends ZeroParamInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2617877968211692209L;

	@Override
	public double execute(ObservableData data) {
		TurtlesList turtles = data.getTurtles();
		return turtles.getNumTurtles();
	}

}

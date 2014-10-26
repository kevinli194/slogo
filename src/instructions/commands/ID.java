package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.TurtlesList;

public class ID extends ZeroParamInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6985883877093676233L;


	@Override
	public double execute(ObservableData data) {
		TurtlesList turtles = data.getTurtles();
		return turtles.getActiveID();
	}

}

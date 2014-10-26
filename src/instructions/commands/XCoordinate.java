package instructions.commands;

import java.util.List;

import instructions.Instruction;
import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class XCoordinate extends ZeroParamInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5266057220075691467L;

	@Override
	public double execute (ObservableData data) {
		double retVal = 0;
		List<Turtle> active = data.getTurtles().getActiveTurtles();
		for (Turtle turtle : active) {
			retVal = turtle.getCoordinates()[0];
		}
		return retVal;
	}
}

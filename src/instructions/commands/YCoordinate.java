package instructions.commands;

import java.util.List;

import instructions.Instruction;
import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class YCoordinate extends ZeroParamInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4503480543426574044L;

	@Override
	public double execute (ObservableData data) {
		double retVal = 0;
		List<Turtle> active = data.getTurtles().getActiveTurtles();
		for (Turtle turtle : active) {
			retVal = turtle.getCoordinates()[1];
		}
		return retVal;
	}


}

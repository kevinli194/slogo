package instructions.commands;

import java.util.List;

import instructions.Instruction;
import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class Heading extends ZeroParamInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7360594989540018283L;

	@Override
	public double execute (ObservableData data) {
		double retVal = 0;
		List<Turtle> active = data.getTurtles().getActiveTurtles();
		for (Turtle turtle : active) {
			retVal = turtle.getAngle();
		}
		return retVal;
	}

}

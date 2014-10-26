package instructions.commands;

import java.util.List;

import instructions.Instruction;
import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class Home extends ZeroParamInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1297315586197568684L;

	@Override
	public double execute (ObservableData data) {
		double retVal = 0;
		List<Turtle> active = data.getTurtles().getActiveTurtles();
		for (Turtle turtle : active) {
			List<double[]> coords = turtle.getCoordList(0, 0);
			retVal = turtle.calculateDistance(coords.get(0), coords.get(1));
		}
		return retVal;
	}



}

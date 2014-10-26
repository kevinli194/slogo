package instructions.commands;

import java.util.List;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class ClearScreen extends ZeroParamInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9069621001188698639L;

	@Override
	public double execute (ObservableData data) {
		
		double retVal = 0;
		List<Turtle> active = data.getTurtles().getActiveTurtles();
		for (Turtle turtle : active) {
			double[] prevCoords = turtle.getCoordinates().clone();
			turtle.clear();
			double[] currentCoords = turtle.getCoordinates().clone();
			retVal = turtle.calculateDistance(prevCoords, currentCoords);
		}
		return retVal;
	}

}

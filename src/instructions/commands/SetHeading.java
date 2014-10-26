package instructions.commands;

import java.util.List;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


public class SetHeading extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3070260495499522235L;

	@Override
	public double execute (ObservableData data) {
		double retVal = 0;
		double amount = myParams.get(0).execute(data);
		List<Turtle> active = data.getTurtles().getActiveTurtles();
		for (Turtle turtle : active) {
			double previousAngle = turtle.getAngle();
			turtle.setAngle(amount);
			retVal = Math.abs(previousAngle - amount);
		}
		return retVal;
	}
}

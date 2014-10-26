package instructions.commands;

import java.util.List;

import instructions.BinaryInstruction;
import model.ObservableData;
import model.Turtle;


public class SetTowards extends BinaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3869904194532624229L;

	@Override
	public double execute (ObservableData data) {
		double x = super.myParams.get(0).execute(data);
		double y = super.myParams.get(1).execute(data);

		double retVal = 0;
		List<Turtle> active = data.getTurtles().getActiveTurtles();
		for (Turtle turtle : active) {
			double targetAngle = turtle.calculateAngle(0, 0, x, y);
			turtle.setAngle(targetAngle);
			retVal = turtle.getAngle() - targetAngle;
		}
		return retVal;
	}
}

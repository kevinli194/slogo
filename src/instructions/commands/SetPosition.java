package instructions.commands;

import java.util.List;
import instructions.BinaryInstruction;
import model.ObservableData;
import model.Turtle;


public class SetPosition extends BinaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2267513548213834685L;

	@Override
	public double execute (ObservableData data) {
		// TODO Auto-generated method stub
		double x = super.myParams.get(0).execute(data);
		double y = super.myParams.get(1).execute(data);

		double retVal = 0;
		List<Turtle> active = data.getTurtles().getActiveTurtles();
		for (Turtle turtle : active) {
			List<double[]> coords = turtle.getCoordList(x, y);
			retVal = turtle.calculateDistance(coords.get(0), coords.get(1));
		}
		return retVal;
	}

}

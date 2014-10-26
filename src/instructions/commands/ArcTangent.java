package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;


public class ArcTangent extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4116547477204738575L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        // TODO Auto-generated method stub
        double radians = Math.toRadians(myParams.get(0).execute(data));
        return Math.atan(radians);

    }
}

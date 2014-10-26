package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;

public class Cosine extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3957854422806611035L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        // TODO Auto-generated method stub
        double radians = Math.toRadians(super.myParams.get(0).execute(data));
        return Math.cos(radians);

    }
}

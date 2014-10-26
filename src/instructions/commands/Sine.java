package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;


public class Sine extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5452125779174197011L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException{
        // TODO Auto-generated method stub
        double radians = Math.toRadians(myParams.get(0).execute(data));
        return Math.sin(radians);

    }
}

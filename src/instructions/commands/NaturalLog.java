package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;


public class NaturalLog extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2769255823616128690L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException{
        // TODO Auto-generated method stub
        return Math.log(myParams.get(0).execute(data));

    }
}

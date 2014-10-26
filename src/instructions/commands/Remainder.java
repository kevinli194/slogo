package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * Implements the Remainderfunction.
 * Returns the modulus of the left parameter's value and the right parameter's value.
 * 
 * @author Sandy Lee
 * 
 */
public class Remainder extends BinaryInstruction {

    private static final long serialVersionUID = 7983967352518517979L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        return myParams.get(1).execute(data) % myParams.get(0).execute(data);

    }
}

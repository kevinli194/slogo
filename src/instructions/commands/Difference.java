package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * Implements difference command.
 * Returns the second parameter's value - first parameter's value.
 * 
 * @author Sandy Lee
 *
 */

public class Difference extends BinaryInstruction {

    private static final long serialVersionUID = 4635477676879222224L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        return myParams.get(1).execute(data) - myParams.get(0).execute(data);

    }
}

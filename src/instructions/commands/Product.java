package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * Implements product command
 * returns product of parameters
 * @author Sandy Lee
 *
 */
public class Product extends BinaryInstruction {

    private static final long serialVersionUID = -4491278262876768177L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        return myParams.get(1).execute(data) * myParams.get(0).execute(data);

    }
}

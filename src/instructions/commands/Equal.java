package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * This implements an EQUAL boolean command.
 * Returns 1 if both parameters have equal value.
 * If not, returns 0.
 * 
 * @author Sandy Lee
 * 
 */

public class Equal extends BinaryInstruction {

    private static final long serialVersionUID = 3795221135714378685L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        if (myParams.get(0).execute(data) == myParams.get(1).execute(data)) { return 1; }
        return 0;
    }

}

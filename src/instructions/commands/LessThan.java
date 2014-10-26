package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * Implements a less than command.
 * Returns 1 if left parameter is less than the right parameter.
 * Otherwise returns 0.
 * 
 * @author Sandy Lee
 */
public class LessThan extends BinaryInstruction {

    private static final long serialVersionUID = 7742397306755261317L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        if (myParams.get(0).execute(data) < myParams.get(1).execute(data)) {
            return 1;
        }
        return 0;
    }

}

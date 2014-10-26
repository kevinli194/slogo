package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * This implements a NOT EQUAL command.
 * Returns 1 if left parameter and right parameter are not equal.
 * Otherwise returns 0.
 * 
 * @author Sandy Lee
 * 
 */
public class NotEqual extends BinaryInstruction {

    private static final long serialVersionUID = -8450966115873396428L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        if (myParams.get(0).execute(data) != myParams.get(1).execute(data)) { return 1; }
        return 0;
    }

}

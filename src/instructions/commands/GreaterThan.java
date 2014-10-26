package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * This implements greater than command.
 * Returns 1 if left parameter is greater than the right parameter.
 * Otherwise returns 0.
 * 
 * @author Sandy Lee
 * 
 */
public class GreaterThan extends BinaryInstruction {
    private static final long serialVersionUID = 2573993344177136137L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        if (myParams.get(0).execute(data) > myParams.get(1).execute(data)) { 
            return 1;
        }
        return 0;
    }

}

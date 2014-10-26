package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * This implements an AND boolean command.
 * Returns 1 if both parameters are equal to 1.
 * If not, return 0
 * 
 * @author Sandy Lee
 * 
 */
public class And extends BinaryInstruction {

    private static final long serialVersionUID = -4893827155183645397L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        if (myParams.get(0).execute(data) != 0
            && myParams.get(1).execute(data) != 0) {
            return 1;
            }
        return 0;
    }

}

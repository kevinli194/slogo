package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


/**
 * This implements an OR command.
 * Returns 1 if left parameter equals 1 or right parameter equals 1.
 * Otherwise returns 0.
 * 
 * @author Sandy Lee
 * 
 */
public class Or extends BinaryInstruction {

    private static final long serialVersionUID = -3036273052396731164L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        if (myParams.get(0).execute(data) != 0 || myParams.get(1).execute(data) != 0)
            return 1;
        return 0;
    }

}

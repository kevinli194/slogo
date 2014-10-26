package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;

/**
 * Implements quotient command
 * returns quotient of parameters
 * @author Sandy Lee
 *
 */
public class Quotient extends BinaryInstruction {

    private static final long serialVersionUID = 5307946185486757783L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        return myParams.get(1).execute(data) / myParams.get(0).execute(data);

    }
}

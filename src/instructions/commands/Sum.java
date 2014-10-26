package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import instructions.Instruction;
import model.ObservableData;


/**
 * Implements difference command.
 * Returns the second parameter's value + first parameter's value.
 * 
 * @author Sandy Lee
 *
 */
public class Sum extends BinaryInstruction {

    private static final long serialVersionUID = -2910753621943189298L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double sum = 0;
        for (Instruction parameter : super.myParams) {
            sum += parameter.execute(data);

        }
        return sum;

    }
}

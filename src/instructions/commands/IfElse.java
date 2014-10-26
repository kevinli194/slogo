package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.ParameterInstruction;
import model.ObservableData;


/**
 * Implements the If Else control structure.
 * If the left parameter's value is not 0, the list of commands in the middle runs.
 * Else, the list of commands to the right runs.
 * 
 * @author Sandy Lee
 * 
 */
public class IfElse extends ParameterInstruction {
    private static final long serialVersionUID = 8941988517555788455L;
    private static final int NUM_PARAM = 3;

    /**
     * Constructor for if else instruction.
     */
    public IfElse () {
        super.myNumParams = NUM_PARAM;
    }

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double returnAmt = 0;
        if (super.myParams.get(0).execute(data) != 0) {
            returnAmt = super.myParams.get(1).execute(data);
        }

        returnAmt = super.myParams.get(2).execute(data);
        return returnAmt;
    }
}

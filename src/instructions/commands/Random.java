package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;


/**
 * Implements the Random function.
 * Returns a random value with a maximum value provided by the parameter.
 * 
 * @author Sandy Lee
 * 
 */
public class Random extends UnaryInstruction {

    private static final long serialVersionUID = -5427849732298158737L;
    private java.util.Random myRand;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        myRand = new java.util.Random();

        int max = (int) myParams.get(0).execute(data);
        return (double) myRand.nextInt(max);

    }
}

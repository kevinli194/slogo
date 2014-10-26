package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Implements the Left function.
 * Turns the turtle left by the amount specified in the first param.
 * 
 * @author Sandy Lee
 * 
 */
public class Left extends UnaryInstruction {

    private static final long serialVersionUID = 1996997469609543230L;
    private static final int FULL_DEGREES = 360;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double amount = myParams.get(0).execute(data);

        Turtle myTurtle = data.getTurtle();

        myTurtle.rotate(FULL_DEGREES - amount);
        return amount;
    }
}

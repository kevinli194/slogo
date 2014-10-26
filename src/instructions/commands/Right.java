package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Implements the Right function.
 * Turns the turtle right by the amount specified in the first param.
 * 
 * @author Sandy Lee
 * 
 */
public class Right extends UnaryInstruction {

    private static final long serialVersionUID = 1567204232456371590L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double amount = myParams.get(0).execute(data);
        Turtle myTurtle = data.getTurtle();
        myTurtle.rotate(amount);
        return amount;
    }
}

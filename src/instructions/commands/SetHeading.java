package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Implements SetHeading command
 * sets the turtles heading to the given param angle
 * @author Sandy Lee
 *
 */
public class SetHeading extends UnaryInstruction {

    private static final long serialVersionUID = -3070260495499522235L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double amount = myParams.get(0).execute(data);

        Turtle myTurtle = data.getTurtle();
        double previousAngle = myTurtle.getAngle();
        myTurtle.setAngle(amount);
        return Math.abs(previousAngle - amount);

    }
}

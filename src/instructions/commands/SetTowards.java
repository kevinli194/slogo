package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Implements the Towards function.
 * Makes the turtle face towards the specified position (parameter)
 * 
 * @author Sandy Lee
 * 
 */
public class SetTowards extends BinaryInstruction {

    private static final long serialVersionUID = 3869904194532624229L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double x = super.myParams.get(0).execute(data);
        double y = super.myParams.get(1).execute(data);

        Turtle myTurtle = data.getTurtle();

        double targetAngle = myTurtle.calculateAngle(0, 0, x, y);
        System.out.println(targetAngle);

        myTurtle.setAngle(targetAngle);

        return myTurtle.getAngle() - targetAngle;
    }
}

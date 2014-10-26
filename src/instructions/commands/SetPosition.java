package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import java.util.List;
import model.ObservableData;
import model.Turtle;


/**
 * Implements the Set Position command
 * Moves the turtles to the specified X and Y position
 * 
 * @author Sandy Lee
 * 
 */
public class SetPosition extends BinaryInstruction {

    private static final long serialVersionUID = -2267513548213834685L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double x = super.myParams.get(0).execute(data);
        double y = super.myParams.get(1).execute(data);

        Turtle myTurtle = data.getTurtle();

        List<double[]> coords = myTurtle.getCoordList(x, y);

        return myTurtle.calculateDistance(coords.get(0), coords.get(1));
    }

}

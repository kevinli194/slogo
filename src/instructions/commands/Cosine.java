package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;


/**
 * This class implements cosine function on the first parameter of the command.
 * 
 * @author Sandy Lee
 *
 */
public class Cosine extends UnaryInstruction {

    private static final long serialVersionUID = 3957854422806611035L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double radians = Math.toRadians(super.myParams.get(0).execute(data));
        return Math.cos(radians);

    }
}

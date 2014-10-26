package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;


/**
 * This class implements arctan math command.
 * 
 * @author seungwonlee
 *
 */
public class ArcTangent extends UnaryInstruction {

    private static final long serialVersionUID = -4116547477204738575L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double radians = Math.toRadians(myParams.get(0).execute(data));
        return Math.atan(radians);

    }
}

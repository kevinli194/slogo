package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;


/**
 * @author implements tangent fuction
 *
 */
public class Tangent extends UnaryInstruction {

    private static final long serialVersionUID = -8289404842696391974L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double radians = Math.toRadians(super.myParams.get(0).execute(data));
        return Math.tan(radians);

    }
}

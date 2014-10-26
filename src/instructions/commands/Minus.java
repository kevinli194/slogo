package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;


/**
 * implements minus command.
 * returns negative of the parameter value
 * 
 * @author Sandy Lee
 *
 */
public class Minus extends UnaryInstruction {

    private static final long serialVersionUID = 448493569163243191L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        return -1 * myParams.get(0).execute(data);

    }
}

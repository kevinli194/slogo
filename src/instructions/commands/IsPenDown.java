package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;



/**
 * Returns 1 if pen is down.
 * @author Sandy Lee
 *
 */
public class IsPenDown extends ZeroParamInstruction {

    private static final long serialVersionUID = 1970520505448177846L;

    @Override
    public double execute (ObservableData data) {
        Turtle myTurtle = data.getTurtle();

        return myTurtle.getPen().isPenDown();
    }
}

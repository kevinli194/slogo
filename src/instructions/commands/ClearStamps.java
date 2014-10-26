package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Clears all the stamps on the screen.
 * 
 * @author Sandy Lee
 *
 */
public class ClearStamps extends ZeroParamInstruction {

    private static final long serialVersionUID = 4220049765458048980L;

    @Override
    public double execute (ObservableData data) {

        Turtle myTurtle = data.getTurtle();

        myTurtle.clearStamp();

        return 1;
    }

}

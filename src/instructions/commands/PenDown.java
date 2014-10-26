package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Returns 1 if pen is down
 * 0 otherwiser
 * 
 * @author Sandy Lee
 *
 */
public class PenDown extends ZeroParamInstruction {

    private static final long serialVersionUID = -119324447053840263L;

    @Override
    public double execute (ObservableData data) {
        Turtle myTurtle = data.getTurtle();
        myTurtle.getPen().setPenDown(true);
        return 1;
    }
}

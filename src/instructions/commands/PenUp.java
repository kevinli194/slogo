package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Returns 1 if pen is up
 * 0 otherwiser
 * @author Sandy Lee
 *
 */
public class PenUp extends ZeroParamInstruction {

    private static final long serialVersionUID = -533547100049501069L;

    @Override
    public double execute (ObservableData data) {
        Turtle myTurtle = data.getTurtle();
        myTurtle.getPen().setPenDown(false);
        return 0;
    }

}

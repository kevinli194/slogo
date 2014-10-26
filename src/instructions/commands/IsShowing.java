package instructions.commands;

import instructions.ZeroParamInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;


/**
 * Returns 1 if the turtle is shown on the screen.
 * 0 otherwise.
 * 
 * @author Sandy Lee
 * 
 **/

public class IsShowing extends ZeroParamInstruction {

    private static final long serialVersionUID = -7693953302633351729L;

    @Override
    public double execute (ObservableData data) {
        Feature myTurtle = data.get("turtle");

        return ((Turtle) myTurtle).isVisible();
    }
}

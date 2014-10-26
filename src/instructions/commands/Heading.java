package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Implements heading fuction.
 * returns the direction the turtle is heading
 * 
 * @author Sandy Lee
 *
 */
public class Heading extends ZeroParamInstruction {

    private static final long serialVersionUID = -7360594989540018283L;

    @Override
    public double execute (ObservableData data) {
        Turtle myTurtle = data.getTurtle();

        return myTurtle.getAngle();
    }

}

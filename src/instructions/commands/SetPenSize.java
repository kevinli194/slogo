package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;
import model.Pen;


/**
 * Implements the Set Pen Size function.
 * Sets the pen size of the turtle's pen to be the specified pixel
 * 
 * @author Sandy Lee
 * 
 */
public class SetPenSize extends UnaryInstruction {
    private static final long serialVersionUID = -4680673263835810284L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        Pen myPen = data.getTurtle().getPen();

        double pixel = super.myParams.get(0).execute(data);

        myPen.setStrokeWidth(pixel);

        return pixel;

    }
}

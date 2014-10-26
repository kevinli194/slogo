package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Returns Ycoord of the turtle's current position.
 * 
 * @author Sandy Lee
 *
 */
public class YCoordinate extends ZeroParamInstruction {

    private static final long serialVersionUID = 4503480543426574044L;

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
        return myTurtle.getCoordinates()[1];
    }

}

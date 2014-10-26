package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class XCoordinate extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5266057220075691467L;

	@Override
    public double execute (ObservableData data) {
        Turtle myTurtle = data.getTurtle();
        return myTurtle.getCoordinates()[0];
    }

   
}

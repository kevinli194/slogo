package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class HideTurtle extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5415300758229081324L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException{
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
        myTurtle.setVisible(false);

        return 0;
    }
}

package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;

public class IsPenDown extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1970520505448177846L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
        
        return myTurtle.getPen().isPenDown();
    }
}



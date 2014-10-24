package instructions.commands;

import instructions.ZeroParamInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;

public class IsShowing extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7693953302633351729L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Feature myTurtle = data.get("turtle");
        
        return ((Turtle) myTurtle).isVisible();
    }
}




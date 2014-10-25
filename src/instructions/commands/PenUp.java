package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class PenUp extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -533547100049501069L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
        myTurtle.getPen().setPenDown(false);
        return 0;
    }

}

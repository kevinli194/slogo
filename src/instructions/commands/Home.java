package instructions.commands;

import java.util.List;

import instructions.Instruction;
import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class Home extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1297315586197568684L;

	@Override
    public double execute (ObservableData data) {

        Turtle myTurtle = data.getTurtle();

        // list with prevcoords, currentcoords

        return myTurtle.setHome();
	}



}

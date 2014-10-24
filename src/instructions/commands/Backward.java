package instructions.commands;

import instructions.Instruction;
import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;

public class Backward extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4282136336006076328L;

	@Override
    public double execute (ObservableData od) {
        // TODO Auto-generated method stub
        double amount = 0;
        for (Instruction parameter : super.myParams) {
            amount = parameter.execute(od);
        }
        Turtle myTurtle = od.getTurtle();
        myTurtle.moveTurtleAndDrawLine(-amount);
        return amount;
    }
}

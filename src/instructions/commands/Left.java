package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


public class Left extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1996997469609543230L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException{
        // TODO Auto-generated method stub
        double amount = myParams.get(0).execute(data);

        Turtle myTurtle = data.getTurtle();

        myTurtle.rotate(360 - amount);
        return amount;
    }
}

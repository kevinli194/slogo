package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;

public class Right extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1567204232456371590L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double amount = myParams.get(0).execute(data);
        Turtle myTurtle = data.getTurtle();
        myTurtle.rotate(amount);
        return amount;
    }
}

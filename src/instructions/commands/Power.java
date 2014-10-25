package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;

public class Power extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6742220320875233199L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        return Math.pow(myParams.get(1).execute(data), myParams.get(0).execute(data));

    }
}

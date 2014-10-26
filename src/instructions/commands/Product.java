package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;

public class Product extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4491278262876768177L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        // TODO Auto-generated method stub

        return myParams.get(1).execute(data) * myParams.get(0).execute(data);

    }
}

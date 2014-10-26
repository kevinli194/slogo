package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;

public class Towards extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5612286132249929189L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        return numParams;
        // TODO Auto-generated method stub
        
}
}
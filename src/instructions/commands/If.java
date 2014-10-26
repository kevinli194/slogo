package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;


public class If extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3818430558387059565L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double returnAmt = 0;
        if (super.myParams.get(0).execute(data) != 0){
            returnAmt = super.myParams.get(1).execute(data);
        }

        return returnAmt;
    }

}

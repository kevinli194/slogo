package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.ObservableData;

public class Not extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5414888979727020593L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException{
        // TODO Auto-generated method stub
        if (myParams.get(0).execute(data)==0)
            return 1;
        return 0;
    }

}
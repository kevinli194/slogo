package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;

public class Equal extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3795221135714378685L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        if (myParams.get(0).execute(data) == myParams.get(1).execute(data))
            return 1;
        return 0;
    }

}
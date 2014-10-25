package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;

public class Difference extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4635477676879222224L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        return myParams.get(1).execute(data) - myParams.get(0).execute(data);

    }
}

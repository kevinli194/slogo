package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;

public class Remainder extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7983967352518517979L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        return myParams.get(1).execute(data) % myParams.get(0).execute(data);

    }
}

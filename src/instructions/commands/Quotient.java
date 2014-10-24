package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;

public class Quotient extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5307946185486757783L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        return myParams.get(1).execute(data) / myParams.get(0).execute(data);

    }
}

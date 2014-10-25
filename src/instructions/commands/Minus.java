package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;

public class Minus extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 448493569163243191L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        return -1 * myParams.get(0).execute(data);

    }
}

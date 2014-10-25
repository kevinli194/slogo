package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;


public class NaturalLog extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2769255823616128690L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        return Math.log(myParams.get(0).execute(data));

    }
}

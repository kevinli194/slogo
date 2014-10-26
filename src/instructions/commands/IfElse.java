package instructions.commands;

import error_checking.InvalidArgumentsException;
import model.ObservableData;
import instructions.ParameterInstruction;

public class IfElse extends ParameterInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8941988517555788455L;
	private final static int NUM_PARAM = 3;

	public IfElse() {
		super.numParams = NUM_PARAM;
	}

	@Override
	public double execute(ObservableData data)throws InvalidArgumentsException {
		double returnAmt = 0;
		if (super.myParams.get(0).execute(data) != 0) {
			returnAmt = super.myParams.get(1).execute(data);
		}

		returnAmt = super.myParams.get(2).execute(data);
		return returnAmt;
	}
}

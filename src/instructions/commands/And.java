package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;

public class And extends BinaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4893827155183645397L;

	@Override
	public double execute(ObservableData data) {
		// TODO Auto-generated method stub
		if (myParams.get(0).execute(data) != 0
				&& myParams.get(1).execute(data) != 0)
			return 1;
		return 0;
	}

}
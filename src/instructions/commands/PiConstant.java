package instructions.commands;

import model.ObservableData;
import instructions.ZeroParamInstruction;

/**
 * returns pi
 * @author Jennie Ju
 *
 */
public class PiConstant extends ZeroParamInstruction {


	private static final long serialVersionUID = 897687685585195155L;

	@Override
	public double execute(ObservableData data) {
		return Math.PI;
	}

}

package instructions.commands;

import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.ListInstruction;
import instructions.VariableInstruction;
import java.util.List;
import model.ObservableData;
import model.VariablesList;
import error_checking.InvalidArgumentsException;

public class For extends BinaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3794762190480724020L;

	@Override
	public double execute(ObservableData data) throws InvalidArgumentsException{

		// parametor 0 = lististr of (variable, start, end, increment)

		List<Instruction> instructionList = ((ListInstruction) super.myParams
				.get(0)).getInstructionList();
		VariableInstruction variable = (VariableInstruction) instructionList
				.get(0);
		double start = instructionList.get(1).execute(data);
		double end = instructionList.get(2).execute(data);
		double increment = instructionList.get(3).execute(data);

		VariablesList varList = (VariablesList) data.get("VariablesList");

		for (double i = start; i < end + 1; i = i + increment) {

			// parameter 1 = listinstr of commands
			varList.add(variable.getName(), i);
			super.myParams.get(1).execute(data);

		}
		return 0;
	}
}

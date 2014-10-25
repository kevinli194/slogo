package instructions.commands;

import java.util.List;

import model.CommandsList;
import model.ObservableData;
import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.ListInstruction;
import instructions.UserDefinedCommand;

public class DefineInstruction extends BinaryInstruction {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6978404722898484037L;

	@Override
	public double execute(ObservableData data) {
		CommandsList allCommands = (CommandsList) data.get("CommandsList");
		UserDefinedCommand udcommand = (UserDefinedCommand) super.myParams.get(0);
		// TODO: Check if list of variables
		ListInstruction listInstr = (ListInstruction) super.myParams.get(1);
		List<Instruction> variables = (List<Instruction>) listInstr.getInstructionList();
		udcommand.defineFunction(variables, null);
		// TODO: MAKE ADD COMMAND A BOOLEAN AND RETURN IT
		allCommands.add(udcommand.getName(), udcommand);
		return 1;
		// TODO: NEEDS ERROR CHECKING TO RETURN 0 IF NOT MADE
		// also this is copied from MakeUserInstruction
	}

}

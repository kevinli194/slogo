package instructions.commands;

import instructions.Instruction;
import instructions.ListInstruction;
import instructions.ParameterInstruction;
import instructions.UserDefinedCommand;
import java.util.List;
import error_checking.InvalidArgumentsException;
import model.CommandsList;
import model.ObservableData;

public class MakeUserInstruction extends ParameterInstruction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1938556879640825722L;
	// MAKE CONSTANTS
	private static final int USERDEFINEDCOMMAND_INDEX = 0;

	public MakeUserInstruction() {
		super.numParams = 3;
	}

	@Override
	public double execute(ObservableData data) throws InvalidArgumentsException{
		CommandsList allCommands = (CommandsList) data.get("CommandsList");
		try {
			// TODO: Check if UserDefinedCommand (error)
			UserDefinedCommand udcommand = (UserDefinedCommand) super.myParams.get(USERDEFINEDCOMMAND_INDEX);
			// TODO: Check if list of variables
			ListInstruction listInstr = (ListInstruction) super.myParams.get(1);
			List<Instruction> variables = (List<Instruction>) listInstr.getInstructionList();
			// TODO: Check if list of instructions
			Instruction commands = super.myParams.get(2);
			udcommand.defineFunction(variables, commands);
			
			// TODO: MAKE ADD COMMAND A BOOLEAN AND RETURN IT
			allCommands.add(udcommand.getName(), udcommand);
			return 1;
		}
		// TODO: CHANGE THIS ERROR CATCHING TO SOMETHING MORE RELEVANT
		catch (RuntimeException e){
			System.out.println("COULD NOT MAKE THE FUNCTION.");
			return 0;
		}
	}

}

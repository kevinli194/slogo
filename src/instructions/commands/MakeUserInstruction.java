package instructions.commands;

import model.ObservableData;
import instructions.ParameterInstruction;
import instructions.UnaryInstruction;
import instructions.UserDefinedCommand;

public class MakeUserInstruction extends ParameterInstruction {

	public MakeUserInstruction() {
		super.numParams = 3;
	}
	
	@Override
	public double execute(ObservableData data) {
		if (super.myParams.size() > 1) {
			System.out.println("TOO MANY INPUTS TO MAKEUSERINSTRUCTION.");
		}
		// TODO: Check if UserDefinedCommand (error)
		UserDefinedCommand udcommand = (UserDefinedCommand) super.myParams.get(0);
		// TODO: Check if list of variables
		return 0;
	}

}

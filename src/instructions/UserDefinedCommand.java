package instructions;


import java.util.List;

import error_checking.ErrorDialog;
import model.ObservableData;
import model.VariablesList;

public class UserDefinedCommand extends UserDefinedInstruction {
	private List<Instruction> myVariables;
	private Instruction myCommands;
	
	public UserDefinedCommand(String name) {
		super(name);
	}
	
	public UserDefinedCommand(UserDefinedCommand udcommand) {
		super(udcommand.myName);
		defineFunction(udcommand.myVariables, udcommand.myCommands);
	}

	public void defineFunction(List<Instruction> variables, Instruction commands) {
		myVariables = variables;
		super.numParams = myVariables.size();
		myCommands = commands;
	}
	
	@Override
	public double execute(ObservableData data) {
		double returnVal;
		VariablesList varList = (VariablesList) data.get("VariablesList");
		// add new variable scope
		varList.addScope();
		setVariables(varList);
		returnVal = myCommands.execute(data);
		// remove added variable scope
		varList.removeScope();
		return returnVal;
	}

	private void setVariables(VariablesList varList) {
		for (int i = 0; i < super.numParams; i++) {
			// TODO: NEEDS FURTHER ERROR CHECKING
			if (i >= myVariables.size()) {
				new ErrorDialog("Please define %s command first.",super.myName);
			}
			VariableInstruction var = (VariableInstruction) myVariables.get(i);
			Instruction value = super.myParams.get(i);
			// error check to make sure you have enough params
			varList.add(var.getName(), value);
		}
	}

}

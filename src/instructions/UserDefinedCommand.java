package instructions;


import java.util.List;

import model.ObservableData;
import model.VariablesList;

public class UserDefinedCommand extends UserDefinedInstruction {
	private List<VariableInstruction> myVariables;
	private ListInstruction myCommands;
	
	public UserDefinedCommand(String name) {
		super(name);
	}

	protected void defineFunction(List<VariableInstruction> variables, ListInstruction commands) {
		myVariables = variables;
		super.numParams = myVariables.size();
		myCommands = commands;
	}
	
	@Override
	public double execute(ObservableData data) {
		double returnVal;
		VariablesList varList = (VariablesList) data.get("VariablesList");
		setVariables(varList);
		returnVal = myCommands.execute(data);
		removeVariables(varList);
		return returnVal;
	}

	private void setVariables(VariablesList varList) {
		for (int i = 0; i < super.numParams; i++) {
			VariableInstruction var = myVariables.get(i);
			Instruction value = super.myParams.get(i);
			// error check to make sure you have enough params
			varList.add(var.getName(), value);
		}
	}

	private void removeVariables(VariablesList varList) {
		for (VariableInstruction var : myVariables) {
			varList.remove(var.getName());
		}
		
	}

}

package instructions;

import model.ObservableData;
import model.VariablesList;

public class VariableInstruction extends ZeroParamInstruction {
	String myName;
	
	public VariableInstruction(String name) {
		myName = name;
	}

	/**
	 * Gets value of variable from VariablesList
	 */
	@Override
	public double execute(ObservableData data) {
		VariablesList varList = (VariablesList) data.get("VariablesList");
		return varList.get(myName);
	}

}

package instructions;

import model.ObservableData;
import model.VariablesList;

public class VariableInstruction extends UserDefinedInstruction {

	public VariableInstruction(String name) {
		super(name);
	}

	protected String getName() {
		return myName;
	}
	
	/**
	 * Gets value of variable from VariablesList
	 */
	@Override
	public double execute(ObservableData data) {
		VariablesList varList = (VariablesList) data.get("VariablesList");
		return varList.get(super.myName);
	}

}

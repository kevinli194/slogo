package instructions;

import model.ObservableData;
import model.VariablesList;

public class VariableInstruction extends UserDefinedInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -197584065175920865L;

	public VariableInstruction(String name) {
		super(name);
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

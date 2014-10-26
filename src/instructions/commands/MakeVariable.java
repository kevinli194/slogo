package instructions.commands;

import model.ObservableData;
import model.VariablesList;
import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.VariableInstruction;
// NEED TO MAKE THIS CLASS
public class MakeVariable extends BinaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3545647644856338247L;

	@Override
	public double execute(ObservableData data) {
		VariablesList varList = (VariablesList) data.get("VariablesList");
		
		if (!(super.myParams.get(0) instanceof VariableInstruction)) {
			// ERROR CHECK
			System.out.println("NOT A VARIABLE.");
		}
		
		VariableInstruction var = (VariableInstruction) super.myParams.get(0);
		Instruction value = super.myParams.get(1);
		double doubleValue = value.execute(data);
		varList.add(var.getName(), doubleValue);
		return doubleValue;
	}

}

package instructions.commands;

import model.ObservableData;
import model.VariablesList;
import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.VariableInstruction;
// NEED TO MAKE THIS CLASS
public class MakeVariable extends BinaryInstruction {

	@Override
	public double execute(ObservableData data) {
		VariablesList varList = (VariablesList) data.get("VariablesList");
		
		if (!(super.myParams.get(0) instanceof VariableInstruction)) {
			// ERROR CHECK
			System.out.println("NOT A VARIABLE.");
		}
		
		VariableInstruction var = (VariableInstruction) super.myParams.get(0);
		Instruction value = super.myParams.get(1);
		varList.add(var.getName(), value);
		return value.execute(data);
	}

}

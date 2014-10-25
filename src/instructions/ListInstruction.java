package instructions;

import java.util.ArrayList;
import java.util.List;

import model.ObservableData;

public class ListInstruction extends ZeroParamInstruction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8768754397704316762L;
	private List<Instruction> myInstructionList = new ArrayList<Instruction>();

	public ListInstruction(List<Instruction> lst) {
		myInstructionList = lst;

	}

	public List<Instruction> getInstructionList() {
		return myInstructionList;
	}
	
	@Override
	public double execute(ObservableData od) {
		double returnAmt = 0;
		for (Instruction instr : myInstructionList) {
			returnAmt = instr.execute(od);
		}

		return returnAmt;

	}

}

package instructions;

import java.util.ArrayList;
import java.util.List;
import model.ObservableData;

public class ListInstruction implements Instruction {
	private List<Instruction> myInstructionList = new ArrayList<Instruction>();

	public ListInstruction(List<Instruction> lst) {
		myInstructionList = lst;

	}

	@Override
	public double execute(ObservableData od) {
		// TODO Auto-generated method stub
		double returnAmt = 0;
		for (Instruction instr : myInstructionList) {
			returnAmt = instr.execute(od);
		}

		return returnAmt;

	}

	@Override
	public int getNumParams() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addParam(Instruction param) {
		// TODO Auto-generated method stub
	}

}

package instructions.commands;

import java.util.ArrayList;
import java.util.List;

import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.ListInstruction;
import model.ObservableData;
import model.TurtlesList;

public class Ask extends BinaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2864842923015655374L;

	@Override
	public double execute(ObservableData data) {
		List<Integer> askedIdInts = getAskedIDs(data);
		TurtlesList turtles = data.getTurtles();
		turtles.addScope(askedIdInts);
		double retVal = super.myParams.get(1).execute(data);
		turtles.removeScope();
		
		return retVal;
	}
	
	private List<Integer> getAskedIDs(ObservableData data) {
		ListInstruction listInstr = (ListInstruction) super.myParams.get(0);
		List<Instruction> askedIDs = listInstr.getInstructionList();
		List<Integer> askedIdInts = new ArrayList<Integer>();
		for (Instruction constant : askedIDs) {
			//check if constant is integer
			askedIdInts.add((int) constant.execute(data));
		}
		return askedIdInts;
	}

}

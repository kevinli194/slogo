package instructions.commands;

import instructions.Instruction;
import instructions.ListInstruction;
import instructions.ParameterInstruction;
import java.util.ArrayList;
import java.util.List;
import error_checking.InvalidArgumentsException;
import model.ObservableData;
import model.TurtlesList;

public class Tell extends ParameterInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7176362370712108327L;

	@Override
	public double execute(ObservableData data) throws InvalidArgumentsException {
		List<Integer> askedIdInts = getAskedIDs(data,0);
		
		TurtlesList turtles = data.getTurtles();
		turtles.setActive(askedIdInts);
		return (double) askedIdInts.get(askedIdInts.size()-1);
	}
	
	protected List<Integer> getAskedIDs(ObservableData data, int index) throws InvalidArgumentsException {
		ListInstruction listInstr = (ListInstruction) super.myParams.get(index);
		List<Instruction> askedIDs = listInstr.getInstructionList();
		List<Integer> askedIdInts = new ArrayList<Integer>();
		for (Instruction constant : askedIDs) {
			//check if constant is integer
			askedIdInts.add((int) constant.execute(data));
		}
		return askedIdInts;
	}

}

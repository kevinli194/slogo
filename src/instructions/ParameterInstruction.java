package instructions;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the super class for instructions that have parameters. Has instance
 * variables indicating number of parameters needed, with a list of the
 * parameters
 * 
 */
public abstract class ParameterInstruction implements Instruction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1313766908935710341L;
	protected int numParams;
	protected List<Instruction> myParams;

	protected ParameterInstruction() {
		myParams = new LinkedList<Instruction>();
	}

	@Override
	public int getNumParams() {
		return numParams;
	}

	@Override
	public void addParam(Instruction param) {
		myParams.add(param);
	}
	
}

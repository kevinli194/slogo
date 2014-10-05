package Instructions;

import java.util.List;

/**
 * This is the super class for instructions that have parameters.
 * Has instance variables indicating number of parameters needed,
 * with a list of the parameters
 * 
 */
public abstract class ParameterInstruction implements Instruction {
	protected int numParams;
	protected List<Double> myParams;

	@Override
	public int getNumParams() {
		return numParams;
	}

	@Override
	public void addParam(double value) {
		myParams.add(value);
	}
}
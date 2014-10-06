package Instructions;

import model.ObservableData;

/**
 * This is the class for instructions that only store a constant value.
 * Its evaluate method will return its double value.
 * 
 */
public class ConstantInstruction implements Instruction{
	private double myValue;
	
	public ConstantInstruction(double value) {
		myValue = value;
	}

	@Override
	public double evaluate() {
		return myValue;
	}

	@Override
	public void execute(ObservableData od) {
	}

	@Override
	public int getNumParams() {
		return 0;
	}

	@Override
	public void addParam(Instruction instr) {
	}
	

}

package Instructions;

import model.ObservableData;

/**
 * This is the class for instructions that only store a constant value.
 * Its evaluate method will return its double value.
 * 
 */
public class ConstantInstruction implements Instruction{
	private double myValue;

	@Override
	public double evaluate() {
		return myValue;
	}

	@Override
	public void execute(ObservableData od) {
	}

	public void setParameter() {
		// TODO Auto-generated method stub
		
	}
	

}

package instructions;

public abstract class ZeroParamInstruction implements Instruction {

	/**
	 * Needs zero outside parameters
	 */
	@Override
	public int getNumParams() {
		return 0;
	}

	/**
	 * Does nothing when asked to add parameters
	 */
	@Override
	public void addParam(Instruction param) {
	}

}

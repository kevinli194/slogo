package instructions;

public abstract class ZeroParamInstruction implements Instruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6504932620355712311L;

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

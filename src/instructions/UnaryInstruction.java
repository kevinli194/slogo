package instructions;

/**
 * This represents the super class for instructions with one parameter
 * 
 */
public abstract class UnaryInstruction extends ParameterInstruction {
	/**
	 * 
	 * @param parameter
	 *            of the unary instruction.
	 */
	private final static int UNARY_NUM_PARAM = 1;

	public UnaryInstruction() {
		super.numParams = UNARY_NUM_PARAM;
	}

}

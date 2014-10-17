package Instructions;

/**
 * This represents the super class for instructions with two parameters
 * 
 */
public abstract class BinaryInstruction extends ParameterInstruction {

	/**
	 * 
	 * @param parameterOne
	 *            parameter of the binary instruction
	 * @param parameterTwo
	 *            parameter of the binary instruction
	 */
	private final static int BINARY_NUM_PARAM = 2;

	public BinaryInstruction() {
		super.numParams = BINARY_NUM_PARAM;
	}

}

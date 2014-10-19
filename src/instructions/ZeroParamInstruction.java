package instructions;

/**
 * Skeleton abstract class for commands
 * that have no parameters to execute on
 * @author slogo_team02 a.k.a. TEAM ROCKET
 *
 */

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

package instructions;

/**
 * Super class for all user defined commands.
 * @author Sandy Lee
 *
 */
public abstract class UserDefinedInstruction extends ParameterInstruction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7708851534217808268L;
	protected String myName;
	
	public UserDefinedInstruction(String name) {
		myName = name;
	}

	public String getName() {
		return myName;
	}

}

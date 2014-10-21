package instructions;

public abstract class UserDefinedInstruction extends ParameterInstruction {
	protected String myName;
	
	public UserDefinedInstruction(String name) {
		myName = name;
	}

	public String getName() {
		return myName;
	}
	

}

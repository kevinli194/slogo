package instructions;

import model.ObservableData;

public class VariableInstruction extends UnaryInstruction {
	String myName;
	
	public VariableInstruction(String name) {
		myName = name;
	}

	@Override
	public double execute(ObservableData data) {
		return myParams.get(0).execute(data);
	}

}

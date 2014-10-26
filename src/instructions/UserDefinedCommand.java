package instructions;


import java.util.List;
import error_checking.ErrorDialog;
import error_checking.InvalidArgumentsException;
import model.ObservableData;
import model.VariablesList;

public class UserDefinedCommand extends UserDefinedInstruction {
        /**
         * 
         */
        private static final long serialVersionUID = 241936480193090236L;
        private List<Instruction> myVariables;
        private Instruction myCommands;
        
        public UserDefinedCommand(String name) {
                super(name);
        }
        
        public UserDefinedCommand(UserDefinedCommand udcommand) {
                super(udcommand.myName);
                defineFunction(udcommand.myVariables, udcommand.myCommands);
        }


	public void defineFunction(List<Instruction> variables, Instruction commands) {
		myVariables = variables;
		super.numParams = myVariables.size();
		myCommands = commands;
	}
	
	@Override
	public double execute(ObservableData data) throws InvalidArgumentsException {
		double returnVal;
		VariablesList varList = (VariablesList) data.get("VariablesList");
		// add new variable scope
		varList.addScope();
		setVariables(varList, data);
		returnVal = myCommands.execute(data);
		// remove added variable scope
		varList.removeScope();
		return returnVal;
	}

	private void setVariables(VariablesList varList, ObservableData data) throws InvalidArgumentsException {
		for (int i = 0; i < super.numParams; i++) {
			// TODO: NEEDS FURTHER ERROR CHECKING
			if (i >= myVariables.size()) {
				new ErrorDialog("Please define %s command first.",super.myName);
			}
			VariableInstruction var = (VariableInstruction) myVariables.get(i);
			double value = super.myParams.get(i).execute(data);
			// error check to make sure you have enough params
			varList.add(var.getName(), value);
		}
	}

}

package instructions;

import error_checking.ErrorDialog;
import error_checking.InstructionDefineException;
import error_checking.InvalidArgumentsException;
import java.util.List;
import model.ObservableData;
import model.VariablesList;


/**
 * Class to create user defined commands.
 * 
 * @author Jennie Ju
 *
 */
public class UserDefinedCommand extends UserDefinedInstruction {

    private static final long serialVersionUID = 241936480193090236L;
    private List<Instruction> myVariables;
    private Instruction myCommands;

    /**
     * @param name
     */
    public UserDefinedCommand (String name) {
        super(name);
    }

    /**
     * @param udcommand user defined command
     */
    public UserDefinedCommand (UserDefinedCommand udcommand) {
        super(udcommand.myName);
        defineFunction(udcommand.myVariables, udcommand.myCommands);
    }

    /**
     * @param variables for user defined command
     * @param commands for the defined command
     */
    public void defineFunction (List<Instruction> variables, Instruction commands) {
        myVariables = variables;
        super.myNumParams = myVariables.size();
        myCommands = commands;
    }

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        double returnVal;
        VariablesList varList = (VariablesList) data.get("VariablesList");
        // add new variable scope
        varList.addScope();
        setVariables(varList, data);
        if (myCommands == null) {

            new ErrorDialog("Please define %s first.", super.myName);
            throw new InstructionDefineException("THERE IS NO SUCH COMMAND.");

        }
        returnVal = myCommands.execute(data);
        // remove added variable scope
        varList.removeScope();
        return returnVal;
    }

    /**
     * @param varList that contains all of the defined variables
     * @param data of observables
     * @throws InvalidArgumentsException throws when there is not enough parameters
     */
    private void setVariables (VariablesList varList, ObservableData data)
                                                                          throws InvalidArgumentsException {
        for (int i = 0; i < super.myNumParams; i++) {
            if (i >= myVariables.size()) {
                new ErrorDialog("Please define %s command first.", super.myName);
                throw new InstructionDefineException("THERE IS NO SUCH INSTRUCTION.");
            }
            VariableInstruction var = (VariableInstruction) myVariables.get(i);
            double value = super.myParams.get(i).execute(data);

            varList.add(var.getName(), value);
        }
    }

}

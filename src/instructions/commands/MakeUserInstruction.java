package instructions.commands;

import instructions.Instruction;
import instructions.ListInstruction;
import instructions.ParameterInstruction;
import instructions.UserDefinedCommand;
import java.util.List;
import model.CommandsList;
import model.ObservableData;
import error_checking.ErrorDialog;
import error_checking.InstructionDefineException;
import error_checking.InvalidArgumentsException;


/**
 * Implements creating user defined instruction.
 * 
 * @author Jennie Ju, Sandy Lee
 */
public class MakeUserInstruction extends ParameterInstruction {

    private static final long serialVersionUID = 1938556879640825722L;
    private static final int USERDEFINEDCOMMAND_INDEX = 0;
    private static final int NUM_PARAM = 3;
    private static final String PARAMETER_TYPE_2 =
            "SECOND PARMETER IS NOT A LIST OF VARIABLES";
    private static final String PARAMETER_TYPE_3 =
            "THIRD PARMETER IS NOT A LIST OF COMMANDS";

    /**
     * Constuctor for makeuserinstruction class
     */
    public MakeUserInstruction () {
        super.myNumParams = NUM_PARAM;
    }

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        CommandsList allCommands = (CommandsList) data.get("CommandsList");
        try {

            UserDefinedCommand udcommand =
                    (UserDefinedCommand) super.myParams.get(USERDEFINEDCOMMAND_INDEX);

            // TODO: error checking needs to be fixed.
            if (!(super.myParams.get(1) instanceof ListInstruction)) {
                new ErrorDialog(PARAMETER_TYPE_2);
                throw new InvalidArgumentsException(PARAMETER_TYPE_2, this.getClass()
                        .getCanonicalName());
            }
            ListInstruction listInstr = (ListInstruction) super.myParams.get(1);
            List<Instruction> variables = (List<Instruction>) listInstr.getInstructionList();

            if (!(super.myParams.get(2) instanceof Instruction)) {
                new ErrorDialog(PARAMETER_TYPE_3);
                throw new InvalidArgumentsException(PARAMETER_TYPE_3, this.getClass()
                        .getCanonicalName());
            }
            Instruction commands = super.myParams.get(2);
            udcommand.defineFunction(variables, commands);

            allCommands.add(udcommand.getName(), udcommand);
            return 1;
        }
        catch (InstructionDefineException e) {
            new ErrorDialog("COULD NOT MAKE THE FUNCTION.");
            return 0;
        }
    }

}

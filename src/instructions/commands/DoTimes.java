package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.ListInstruction;
import instructions.VariableInstruction;
import java.util.List;
import model.ObservableData;
import model.VariablesList;


/**
 * Implements the Do Times command.
 * Runs the specified command list a certain number of times.
 * Assigns the current count of the loop to the specified name of the variable.
 * 
 * @author Sandy Lee
 * 
 */
public class DoTimes extends BinaryInstruction {

    private static final long serialVersionUID = 8586670318984101878L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        ListInstruction listInstr = (ListInstruction) super.myParams.get(0);
        List<Instruction> instructionList = listInstr.getInstructionList();
        VariableInstruction variable = (VariableInstruction) instructionList.get(0);
        double limit = instructionList.get(1).execute(data);

        VariablesList varList = (VariablesList) data.get("VariablesList");

        for (int i = 1; i < limit + 1; i++) {
            varList.add(variable.getName(), i);
            super.myParams.get(1).execute(data);

        }
        return 0;
    }
}

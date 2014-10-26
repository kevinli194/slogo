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
 * Implements the For loop command.
 * Runs the specified command list a certain number of times.
 * The start, end and increment values of the loop are given in the first list.
 * The current loop number is assigned to the specified variable name.
 *
 * @author Sandy Lee
 *
 */
public class For extends BinaryInstruction {

    private static final long serialVersionUID = 3794762190480724020L;
    private static final int FIRST_PARAM = 1;
    private static final int SECOND_PARAM = 2;
    private static final int THIRD_PARAM = 3;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        List<Instruction> instructionList =
                ((ListInstruction) super.myParams.get(0)).getInstructionList();
        VariableInstruction variable = (VariableInstruction) instructionList.get(0);
        double start = instructionList.get(FIRST_PARAM).execute(data);
        double end = instructionList.get(SECOND_PARAM).execute(data);
        double increment = instructionList.get(THIRD_PARAM).execute(data);

        VariablesList varList = (VariablesList) data.get("VariablesList");

        for (double i = start; i < end + 1; i = i + increment) {

            varList.add(variable.getName(), i);
            super.myParams.get(1).execute(data);

        }
        return 0;
    }
}

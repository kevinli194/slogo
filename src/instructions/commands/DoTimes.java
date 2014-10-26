package instructions.commands;

import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.ListInstruction;
import instructions.VariableInstruction;
import java.util.List;
import model.ObservableData;
import model.VariablesList;
import error_checking.InvalidArgumentsException;


// need to clean up code

public class DoTimes extends BinaryInstruction {

    /**
	 * 
	 */
    private static final long serialVersionUID = 8586670318984101878L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        // parametor 0 = lististr of (variable, limit)
        ListInstruction listInstr = (ListInstruction) super.myParams.get(0);
        List<Instruction> instructionList = listInstr.getInstructionList();
        VariableInstruction variable = (VariableInstruction) instructionList.get(0);
        double limit = instructionList.get(1).execute(data);

        VariablesList varList = (VariablesList) data.get("VariablesList");

        for (int i = 1; i < limit + 1; i++) {
            // parameter 1 = listinstr of commands
            varList.add(variable.getName(), i);
            super.myParams.get(1).execute(data);

        }
        return 0;
    }
}

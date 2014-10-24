package instructions.commands;

import java.util.List;
import instructions.BinaryInstruction;
import instructions.ConstantInstruction;
import instructions.Instruction;
import instructions.ListInstruction;
import instructions.VariableInstruction;
import model.ObservableData;
import model.VariablesList;

//need to clean up code

public class DoTimes extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {

        // parametor 0 = lististr of (variable, limit)
        ListInstruction listInstr = (ListInstruction) super.myParams.get(0);
        List<Instruction> instructionList = listInstr.getInstructionList();
        VariableInstruction variable = (VariableInstruction) instructionList.get(0);
        double limit = instructionList.get(1).execute(data);

        VariablesList varList = (VariablesList) data.get("VariablesList");

        for (int i = 1; i < limit + 1; i++) {
            Instruction constant = new ConstantInstruction(i);
            // parameter 1 = listinstr of commands
            varList.add(variable.getName(), constant);
            super.myParams.get(1).execute(data);

        }
        return 0;
    }
}

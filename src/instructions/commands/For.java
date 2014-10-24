package instructions.commands;

import instructions.BinaryInstruction;
import instructions.ConstantInstruction;
import instructions.Instruction;
import instructions.ListInstruction;
import instructions.VariableInstruction;
import java.util.List;
import model.ObservableData;
import model.VariablesList;


public class For extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {

        // parametor 0 = lististr of (variable, start, end, increment)

        List<Instruction> instructionList = ((ListInstruction) super.myParams.get(0)).getInstructionList();
        VariableInstruction variable = (VariableInstruction) instructionList.get(0);
        double start = instructionList.get(1).execute(data);
        double end = instructionList.get(2).execute(data);
        double increment = instructionList.get(3).execute(data);



        VariablesList varList = (VariablesList) data.get("VariablesList");

        for (double i = start; i < end + 1; i = i + increment) {
            Instruction constant = new ConstantInstruction(i);
            
            // parameter 1 = listinstr of commands
            varList.add(variable.getName(), constant);
            super.myParams.get(1).execute(data);

        }
        return 0;
    }
}

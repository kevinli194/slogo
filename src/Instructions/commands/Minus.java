package instructions.commands;

import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.UnaryInstruction;
import model.ObservableData;

public class Minus extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        return -1 * myParams.get(0).execute(data);

    }
}

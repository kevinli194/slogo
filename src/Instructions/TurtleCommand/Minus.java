package Instructions.TurtleCommand;

import model.ObservableData;
import Instructions.BinaryInstruction;
import Instructions.Instruction;
import Instructions.UnaryInstruction;

public class Minus extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        return -1 * myParams.get(0).execute(data);

    }
}

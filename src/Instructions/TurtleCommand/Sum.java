package Instructions.TurtleCommand;

import model.ObservableData;
import Instructions.BinaryInstruction;
import Instructions.Instruction;


public class Sum extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double sum = 0;
        for (Instruction parameter : myParams) {
            sum += parameter.execute(data);

        }
        return sum;

    }
}

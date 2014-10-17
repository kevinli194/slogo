package Instructions.commands;

import Instructions.BinaryInstruction;
import model.ObservableData;

public class Power extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        return Math.pow(myParams.get(1).execute(data), myParams.get(0).execute(data));

    }
}

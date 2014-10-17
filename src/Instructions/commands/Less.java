package Instructions.commands;

import Instructions.BinaryInstruction;
import model.ObservableData;

public class Less extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        if (myParams.get(0).execute(data) < myParams.get(1).execute(data))
            return 1;
        return 0;
    }

}

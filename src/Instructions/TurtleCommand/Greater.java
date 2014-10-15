package Instructions.TurtleCommand;

import model.ObservableData;
import Instructions.BinaryInstruction;

public class Greater extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        if (myParams.get(0).execute(data) > myParams.get(1).execute(data))
            return 1;
        return 0;
    }

}
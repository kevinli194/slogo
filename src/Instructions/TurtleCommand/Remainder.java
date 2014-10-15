package Instructions.TurtleCommand;

import model.ObservableData;
import Instructions.BinaryInstruction;

public class Remainder extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        return myParams.get(1).execute(data) % myParams.get(0).execute(data);

    }
}

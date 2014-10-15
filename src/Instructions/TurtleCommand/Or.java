package Instructions.TurtleCommand;

import model.ObservableData;
import Instructions.BinaryInstruction;

public class Or extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        if (myParams.get(0).execute(data)!=0 ||  myParams.get(1).execute(data)!=0)
            return 1;
        return 0;
    }

}
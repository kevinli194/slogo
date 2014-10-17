package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;


public class If extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        double returnAmt = 0;
        if (myParams.get(0).execute(data) != 0){
            returnAmt = myParams.get(1).execute(data);
        }

        return returnAmt;
    }

}

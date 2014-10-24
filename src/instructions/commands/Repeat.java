package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;

public class Repeat extends BinaryInstruction{
    

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double repeatTimes = super.myParams.get(0).execute(data);
        double returnAmt = 0;
        for (int i = 0; i < repeatTimes; i++) {
            returnAmt = super.myParams.get(1).execute(data);
        }
        
        return returnAmt;
    }

}

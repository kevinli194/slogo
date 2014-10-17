package Instructions.commands;

import Instructions.BinaryInstruction;
import model.ObservableData;

public class Repeat extends BinaryInstruction{
    

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double repeatTimes = myParams.get(0).execute(data);
        double returnAmt = 0;
        for (int i = 0; i < repeatTimes; i++) {
            returnAmt = myParams.get(1).execute(data);
        }
        
        return returnAmt;
    }

}

package Instructions.commands;

import Instructions.UnaryInstruction;
import model.ObservableData;

public class Not extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        if (myParams.get(0).execute(data)==0)
            return 1;
        return 0;
    }

}
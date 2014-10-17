package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;


public class NaturalLog extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        return Math.log(myParams.get(0).execute(data));

    }
}

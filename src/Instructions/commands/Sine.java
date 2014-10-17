package Instructions.commands;

import Instructions.UnaryInstruction;
import model.ObservableData;


public class Sine extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double radians = Math.toRadians(myParams.get(0).execute(data));
        return Math.sin(radians);

    }
}

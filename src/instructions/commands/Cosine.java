package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;

public class Cosine extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double radians = Math.toRadians(super.myParams.get(0).execute(data));
        return Math.cos(radians);

    }
}

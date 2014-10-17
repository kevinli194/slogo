package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;


public class ArcTangent extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double radians = Math.toRadians(myParams.get(0).execute(data));
        return Math.atan(radians);

    }
}

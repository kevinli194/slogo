package instructions.commands;

import instructions.ZeroParamInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;

public class PenDown extends ZeroParamInstruction{

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Feature myTurtle = data.get("turtle");
        ((Turtle) myTurtle).getPen().setPenDown(true);
        return 1;
    }
}

package instructions.commands;

import instructions.ZeroParamInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;

public class IsPenDown extends ZeroParamInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Feature myTurtle = data.get("turtle");
        
        return ((Turtle) myTurtle).getPen().isPenDown();
    }
}



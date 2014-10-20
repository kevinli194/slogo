package instructions.commands;

import instructions.ZeroParamInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;


public class HideTurtle extends ZeroParamInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Feature myTurtle = data.get("turtle");
        ((Turtle) myTurtle).setVisible(false);
        return 0;
    }
}

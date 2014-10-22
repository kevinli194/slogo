package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class HideTurtle extends ZeroParamInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = (Turtle) data.get("turtle");
        myTurtle.setVisible(false);
        return 0;
    }
}

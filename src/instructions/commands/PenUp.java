package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class PenUp extends ZeroParamInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
        myTurtle.getPen().setPenDown(false);
        return 0;
    }

}

package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;



public class ClearStamps extends ZeroParamInstruction {

    @Override
    public double execute (ObservableData data) {
        
        Turtle myTurtle = data.getTurtle();
        
        myTurtle.clearStamp();
        
        return 1;
    }

}

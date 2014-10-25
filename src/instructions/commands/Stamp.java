package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;



public class Stamp extends ZeroParamInstruction {

    @Override
    public double execute (ObservableData data) {
        
        Turtle myTurtle = data.getTurtle();
        
        myTurtle.stampImage();
        return 0;
    }

}

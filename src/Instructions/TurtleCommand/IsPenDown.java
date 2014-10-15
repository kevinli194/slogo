package Instructions.TurtleCommand;

import model.Feature;
import model.ObservableData;
import model.Turtle;
import Instructions.Instruction;

public class IsPenDown implements Instruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Feature myTurtle = data.get("turtle");
        
        return ((Turtle) myTurtle).getPen().isPenDown();
    }

    @Override
    public int getNumParams () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addParam (Instruction param) {
        // TODO Auto-generated method stub

    }

}



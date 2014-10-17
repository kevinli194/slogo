package instructions.commands;

import instructions.Instruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;

public class PenDown implements Instruction{

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Feature myTurtle = data.get("turtle");
        ((Turtle) myTurtle).getPen().setPenDown(true);
        return 1;
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

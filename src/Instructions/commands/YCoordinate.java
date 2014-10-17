package instructions.commands;

import instructions.Instruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;

public class YCoordinate implements Instruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Feature myTurtle = data.get("turtle");
        
        return ((Turtle) myTurtle).getCoordinates()[1];
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



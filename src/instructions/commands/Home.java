package instructions.commands;

import instructions.Instruction;
import model.ObservableData;
import model.Turtle;


public class Home implements Instruction {

    @Override
    public double execute (ObservableData data) {

        Turtle myTurtle = (Turtle) data.get("turtle");

        double[] prevCoords = myTurtle.getCoordinates().clone();

        myTurtle.setCoordinates(0, 0);
        double[] currentCoords = myTurtle.getCoordinates().clone();

        return myTurtle.calculateDistance(prevCoords, currentCoords);
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

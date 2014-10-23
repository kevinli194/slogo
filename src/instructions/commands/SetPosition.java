package instructions.commands;

import instructions.BinaryInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;


public class SetPosition extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double x = myParams.get(0).execute(data);
        double y = myParams.get(1).execute(data);

        Turtle myTurtle = (Turtle) data.get("turtle");

        double[] prevCoords = myTurtle.getCoordinates().clone();
        myTurtle.setCoordinates(x, y);
        double[] currentCoords = myTurtle.getCoordinates().clone();

        return myTurtle.calculateDistance(prevCoords, currentCoords);
    }

}

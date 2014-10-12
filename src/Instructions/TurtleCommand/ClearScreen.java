package Instructions.TurtleCommand;

import model.Feature;
import model.ObservableData;
import model.Turtle;
import Instructions.Instruction;

public class ClearScreen implements Instruction{

    @Override
    public double execute (ObservableData data) {

        Feature myTurtle = data.get("turtle");

        double[] prevCoords = ((Turtle) myTurtle).getCoordinates().clone();
        ((Turtle) myTurtle).clear();
        double[] currentCoords = ((Turtle) myTurtle).getCoordinates().clone();

        return calculateDistance(prevCoords, currentCoords);
    }

    private double calculateDistance (double[] startCoords, double[] finalCoords) {
        double xDiff = finalCoords[0] - startCoords[0];
        double yDiff = finalCoords[1] - startCoords[1];

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
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

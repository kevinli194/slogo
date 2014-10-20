package instructions.commands;

import instructions.ZeroParamInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;

public class ClearScreen extends ZeroParamInstruction {

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

}

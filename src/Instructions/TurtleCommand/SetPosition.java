package Instructions.TurtleCommand;

import model.Feature;
import model.ObservableData;
import model.Turtle;
import Instructions.BinaryInstruction;

public class SetPosition extends BinaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double x = myParams.get(0).execute(data);
        double y = myParams.get(1).execute(data);

        Feature myTurtle = data.get("turtle");
        
        double[] prevCoords = ((Turtle) myTurtle).getCoordinates().clone();
               
        ((Turtle) myTurtle).setCoordinates(x, y);
        double[] currentCoords = ((Turtle) myTurtle).getCoordinates().clone();
    
        return calculateDistance(prevCoords, currentCoords);
    }
    
    private double calculateDistance(double[] startCoords, double[] finalCoords) {
        double xDiff = finalCoords[0] - startCoords[0];
        double yDiff = finalCoords[1] - startCoords[1];

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
}
}
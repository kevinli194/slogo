package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class ClearScreen extends ZeroParamInstruction {

    @Override
    public double execute (ObservableData data) {
        
        Turtle myTurtle = data.getTurtle();
        
        double[] prevCoords = myTurtle.getCoordinates().clone();
        myTurtle.clear();
        double[] currentCoords = myTurtle.getCoordinates().clone();

        return myTurtle.calculateDistance(prevCoords, currentCoords);
    }

}

package instructions.commands;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;



public class Stamp extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3066723995999889218L;

	@Override
    public double execute (ObservableData data) {
        
        Turtle myTurtle = data.getTurtle();
        
//        double[] prevCoords = myTurtle.getCoordinates().clone();
//        
//        myTurtle.clear();
//        double[] currentCoords = myTurtle.getCoordinates().clone();
        myTurtle.stampImage();
        return 0;
    }

}
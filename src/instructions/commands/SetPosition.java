package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;
import model.Turtle;


public class SetPosition extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2267513548213834685L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double x = super.myParams.get(0).execute(data);
        double y = super.myParams.get(1).execute(data);

        Turtle myTurtle = data.getTurtle();
        double[] prevCoords = myTurtle.getCoordinates().clone();
        myTurtle.setCoordinates(x, y);
        double[] currentCoords = myTurtle.getCoordinates().clone();

        return myTurtle.calculateDistance(prevCoords, currentCoords);
    }

}

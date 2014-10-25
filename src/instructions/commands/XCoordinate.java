package instructions.commands;

import instructions.Instruction;
import model.ObservableData;
import model.Turtle;


public class XCoordinate implements Instruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5266057220075691467L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
        return myTurtle.getCoordinates()[0];
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

package instructions.commands;

import java.util.List;
import instructions.Instruction;
import model.ObservableData;
import model.Turtle;


public class Home implements Instruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1297315586197568684L;

	@Override
    public double execute (ObservableData data) {

        Turtle myTurtle = data.getTurtle();

        // list with prevcoords, currentcoords
        List<double[]> coords = myTurtle.getCoordList(0, 0);

        return myTurtle.calculateDistance(coords.get(0), coords.get(1));
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

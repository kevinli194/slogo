package instructions.commands;

import instructions.ZeroParamInstruction;
import java.util.List;
import model.ObservableData;
import model.Turtle;


public class Home extends ZeroParamInstruction {

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



}
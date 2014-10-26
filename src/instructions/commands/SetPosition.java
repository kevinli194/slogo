package instructions.commands;

import java.util.List;
import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import model.ObservableData;
import model.Turtle;


public class SetPosition extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2267513548213834685L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        // TODO Auto-generated method stub
        double x = super.myParams.get(0).execute(data);
        double y = super.myParams.get(1).execute(data);

        Turtle myTurtle = data.getTurtle();

        List<double[]> coords = myTurtle.getCoordList(x, y);

        return myTurtle.calculateDistance(coords.get(0), coords.get(1));
    }

}

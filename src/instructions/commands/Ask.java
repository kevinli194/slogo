package instructions.commands;

import error_checking.InvalidArgumentsException;
import model.ObservableData;
import model.TurtlesList;
import java.util.List;


/**
 * This implements ask command for multiple turtles.
 * 
 * @author Jennie Ju
 *
 */
public class Ask extends Tell {

    private static final long serialVersionUID = 2864842923015655374L;

    /**
     * Constructor for ask command
     */
    public Ask () {
        super.myNumParams = 2;
    }

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        List<Integer> askedIdInts = super.getAskedIDs(data, 0);
        TurtlesList turtles = data.getTurtles();
        turtles.addScope(askedIdInts);
        double retVal = super.myParams.get(1).execute(data);
        turtles.removeScope();

        return retVal;
    }

}

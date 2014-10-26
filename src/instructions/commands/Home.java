package instructions.commands;

import instructions.ZeroParamInstruction;
import java.util.List;
import model.ObservableData;
import model.Turtle;


/**
 * Sets turtle back home (0,0)
 * Returns the amount of distance moved to go back home.
 * 
 * @author Sandy Lee
 *
 */
public class Home extends ZeroParamInstruction {
    private static final long serialVersionUID = -1297315586197568684L;

    @Override
    public double execute (ObservableData data) {

        Turtle myTurtle = data.getTurtle();
        List<double[]> coords = myTurtle.getCoordList(0, 0);

        return myTurtle.calculateDistance(coords.get(0), coords.get(1));
    }

}

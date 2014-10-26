package instructions.commands;

import java.util.function.Consumer;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;
import model.TurtlesList;

public class PenDown extends ZeroParamInstruction{

    /**
	 * 
	 */
	private static final long serialVersionUID = -119324447053840263L;

	@Override
    public double execute (ObservableData data) {
		TurtlesList turtles = data.getTurtles();	
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			turtle.getPen().setPenDown(true);;
		};
		turtles.runTurtleMethod(lambda);
        return 1;
    }
}

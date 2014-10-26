package instructions.commands;

import java.util.function.Consumer;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;
import model.TurtlesList;


public class PenUp extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -533547100049501069L;

	@Override
    public double execute (ObservableData data) {
		TurtlesList turtles = data.getTurtles();
		
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			turtle.getPen().setPenDown(false);
		};
		turtles.runTurtleMethod(lambda);
        return 0;
    }

}

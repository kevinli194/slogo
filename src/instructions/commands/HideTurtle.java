package instructions.commands;

import java.util.function.Consumer;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;
import model.TurtlesList;


public class HideTurtle extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5415300758229081324L;

	@Override
    public double execute (ObservableData data) {
		TurtlesList turtles = data.getTurtles();
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			turtle.setVisible(false);
		};
		turtles.runTurtleMethod(lambda);
        return 0;
    }
}

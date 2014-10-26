package instructions.commands;

import java.util.function.Consumer;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;
import model.TurtlesList;


public class Left extends UnaryInstruction {
	private static final int TOTAL_CIRCLE_DEGREES = 360;

    /**
	 * 
	 */
	private static final long serialVersionUID = 1996997469609543230L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double amount = myParams.get(0).execute(data);
		TurtlesList turtles = data.getTurtles();
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			turtle.rotate(TOTAL_CIRCLE_DEGREES - amount);
		};
		turtles.runTurtleMethod(lambda);
        return amount;
    }
}

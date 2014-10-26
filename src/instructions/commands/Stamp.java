package instructions.commands;

import java.util.function.Consumer;

import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;
import model.TurtlesList;



public class Stamp extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3066723995999889218L;

	@Override
    public double execute (ObservableData data) {
		TurtlesList turtles = data.getTurtles();
		Consumer<Turtle> lambda = (Turtle turtle) -> {
	        turtle.stampImage();
		};
		turtles.runTurtleMethod(lambda);
		//TODO:change return value
        return 0;
    }

}

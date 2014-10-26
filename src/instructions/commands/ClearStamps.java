package instructions.commands;

import instructions.ZeroParamInstruction;

import java.util.function.Consumer;

import model.ObservableData;
import model.Turtle;
import model.TurtlesList;



public class ClearStamps extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4220049765458048980L;

	@Override
    public double execute (ObservableData data) {
        
		TurtlesList turtles = data.getTurtles();
		Consumer<Turtle> lambda = (Turtle turtle) -> {
	        turtle.clearStamps();
		};
		turtles.runTurtleMethod(lambda);
        
        return 1;
    }

}

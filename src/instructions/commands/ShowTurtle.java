package instructions.commands;

import instructions.ZeroParamInstruction;

import java.util.function.Consumer;

import model.ObservableData;
import model.Turtle;
import model.TurtlesList;


public class ShowTurtle extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7056907549306719588L;

	@Override
    public double execute (ObservableData data) { 
		TurtlesList turtles = data.getTurtles();
		Consumer<Turtle> lambda = (Turtle turtle) -> {
	        turtle.setVisible(true);
		};
		turtles.runTurtleMethod(lambda);
        return 1;
    }
}

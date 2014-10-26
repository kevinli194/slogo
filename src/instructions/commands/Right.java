package instructions.commands;

import java.util.function.Consumer;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;
import model.TurtlesList;

public class Right extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1567204232456371590L;

	@Override
    public double execute (ObservableData data) {
        double amount = myParams.get(0).execute(data);
        
		TurtlesList turtles = data.getTurtles();
		
		Consumer<Turtle> lambda = (Turtle turtle) -> {
	        turtle.rotate(amount);
		};
		turtles.runTurtleMethod(lambda);
   
        return amount;
    }
}

package instructions.commands;

import instructions.UnaryInstruction;

import java.util.function.Consumer;

import model.ObservableData;
import model.Turtle;
import model.TurtlesList;


/**
 * This class implements the forward command.
 * The forward command moves the turtle forwards by specified amount.
 * 
 * @author
 * 
 */
public class Forward extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5013987356729528187L;

	@Override
	public double execute (ObservableData data) {
		// TODO get rid of duplicated code w/ backward
		double amount = super.myParams.get(0).execute(data);
		TurtlesList turtles = data.getTurtles();
		
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			turtle.moveTurtleAndDrawLine(amount);
		};
		turtles.runTurtleMethod(lambda);
		return amount;
	}
}

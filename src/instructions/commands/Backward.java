package instructions.commands;

import instructions.UnaryInstruction;

import java.util.function.Consumer;

import model.ObservableData;
import model.Turtle;
import model.TurtlesList;

public class Backward extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4282136336006076328L;

	@Override
	public double execute (ObservableData data) {
		// TODO Auto-generated method stub
		double amount = super.myParams.get(0).execute(data);
		TurtlesList turtles = data.getTurtles();
		
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			turtle.moveTurtleAndDrawLine(-amount);
		};
		turtles.runTurtleMethod(lambda);
		return amount;
	}
}

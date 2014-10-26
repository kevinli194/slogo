package instructions.commands;

import java.util.List;
import java.util.function.Consumer;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Pen;
import model.Turtle;
import model.TurtlesList;


public class SetPenSize extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4680673263835810284L;

	@Override
	public double execute (ObservableData data) {
		double pixel = super.myParams.get(0).execute(data);
		
		TurtlesList turtles = data.getTurtles();
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			Pen myPen = turtle.getPen();
			myPen.setStrokeWidth(pixel);
		};
		turtles.runTurtleMethod(lambda);
		
		return pixel;
	}
}


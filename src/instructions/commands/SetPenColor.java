package instructions.commands;

import instructions.UnaryInstruction;

import java.util.List;
import java.util.function.Consumer;

import javafx.scene.paint.Color;
import model.ObservableData;
import model.Pen;
import model.Turtle;
import model.TurtlesList;

public class SetPenColor extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6544906017218135628L;

	@Override
	public double execute(ObservableData data) {
		double index = super.myParams.get(0).execute(data);
		
		TurtlesList turtles = data.getTurtles();
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			Pen myPen = turtle.getPen();
			List<Color> colorList = myPen.getCustom();
			myPen.setPenColor(colorList.get((int) index - 1));
		};
		turtles.runTurtleMethod(lambda);


		return index;
	}
}

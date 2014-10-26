package instructions.commands;

import instructions.UnaryInstruction;

import java.util.List;
import java.util.function.Consumer;

import javafx.scene.image.ImageView;
import model.ObservableData;
import model.Turtle;
import model.TurtlesList;

public class SetShape extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8409776343446639835L;

	@Override
	public double execute(ObservableData data) {
		double index = super.myParams.get(0).execute(data);
		TurtlesList turtles = data.getTurtles();
		
		Consumer<Turtle> lambda = (Turtle turtle) -> {
			List<ImageView> shapeList = turtle.getShapeList();
			turtle.setShape(shapeList.get((int) index - 1));
		};
		turtles.runTurtleMethod(lambda);

		return index;
	}
}

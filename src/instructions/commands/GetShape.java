package instructions.commands;

import instructions.UnaryInstruction;

import java.util.List;

import javafx.scene.image.ImageView;
import model.ObservableData;
import model.Turtle;
import model.TurtlesList;

public class GetShape extends UnaryInstruction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2368059646482772369L;

	@Override
	public double execute (ObservableData data) {
		double retVal = 0;
		TurtlesList turtles = data.getTurtles();
		List<Turtle> active = turtles.getActiveTurtles();
	    List<ImageView> shapeList = turtles.getShapeList();
		for (Turtle turtle : active) {
			int shapeIndex = 0;
			for (int i = 0; i < shapeList.size(); i++) {
				if (shapeList.get(i).equals(turtle.getTurtleImg())) {
					shapeIndex = i;
				}

			}
			retVal = (double) shapeIndex + 1;
		}
		
		return retVal;
	}
}

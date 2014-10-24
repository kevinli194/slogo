package instructions.commands;

import instructions.UnaryInstruction;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Pen;
import model.Turtle;

public class SetPenColor extends UnaryInstruction {

	@Override
	public double execute(ObservableData data) {

		Turtle myTurtle = data.getTurtle();
		Pen myPen = myTurtle.getPen();
		ObservableList<Color> colorList = myPen.getCustom();
		double index = super.myParams.get(0).execute(data);
		myTurtle.getPen().setPenColor(colorList.get((int) index - 1));

		return index;
	}
}

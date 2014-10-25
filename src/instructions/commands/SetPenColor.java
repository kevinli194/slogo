package instructions.commands;

import instructions.UnaryInstruction;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Pen;

public class SetPenColor extends UnaryInstruction {

	@Override
	public double execute(ObservableData data) {

		Pen myPen = data.getTurtle().getPen();
		ObservableList<Color> colorList = myPen.getCustom();
		double index = super.myParams.get(0).execute(data);
		myPen.setPenColor(colorList.get((int) index - 1));

		return index;
	}
}

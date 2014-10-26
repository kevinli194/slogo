package instructions.commands;

import java.util.List;
import instructions.UnaryInstruction;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Pen;

public class SetPenColor extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6544906017218135628L;

	@Override
	public double execute(ObservableData data) {

		Pen myPen = data.getTurtle().getPen();
		List<Color> colorList = myPen.getCustom();
		double index = super.myParams.get(0).execute(data);
		myPen.setPenColor(colorList.get((int) index - 1));

		return index;
	}
}

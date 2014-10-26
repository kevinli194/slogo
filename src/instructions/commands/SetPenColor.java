package instructions.commands;

import instructions.UnaryInstruction;
import java.util.List;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Pen;
import error_checking.InvalidArgumentsException;

public class SetPenColor extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6544906017218135628L;

	@Override
	public double execute(ObservableData data) throws InvalidArgumentsException{

		Pen myPen = data.getTurtle().getPen();
		List<Color> colorList = myPen.getCustom();
		double index = super.myParams.get(0).execute(data);
		myPen.setPenColor(colorList.get((int) index - 1));

		return index;
	}
}

package instructions.commands;

import instructions.UnaryInstruction;

import java.util.List;

import javafx.scene.paint.Color;
import model.BackgroundColor;
import model.ObservableData;

public class SetBackground extends UnaryInstruction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7570832795819615234L;

	@Override
	public double execute(ObservableData data) {
		// TODO Auto-generated method stub
		BackgroundColor bgc = ((BackgroundColor) data.get("backgroundcolor"));
		List<Color> customColors = bgc.getCustom();

		double index = super.myParams.get(0).execute(data);
		bgc.set(customColors.get((int) index - 1));

		// exception needed for when index is out of bounds.

		return index;
	}
}

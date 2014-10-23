package instructions.commands;

import instructions.UnaryInstruction;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.BackgroundColor;
import model.ObservableData;

public class SetBackground extends UnaryInstruction {

	@Override
	public double execute(ObservableData data) {
		// TODO Auto-generated method stub
		BackgroundColor bgc = ((BackgroundColor) data.get("backgroundcolor"));
		ObservableList<Color> customColors = bgc.getCustom();

		double index = super.myParams.get(0).execute(data);
		bgc.set(customColors.get((int) index - 1));

		// exception needed for when index is out of bounds.

		return index;
	}
}

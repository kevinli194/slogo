package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import model.BackgroundColor;
import model.ObservableData;

import javafx.scene.paint.Color;
import java.util.List;

/**
 * Implements the SetBackgroud function.
 * Sets the background of the workspace to the specified color index
 * 
 * @author Sandy Lee, Kevin Li
 * 
 */
public class SetBackground extends UnaryInstruction {
    private static final long serialVersionUID = -7570832795819615234L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        BackgroundColor bgc = (BackgroundColor) data.get("backgroundcolor");
        List<Color> customColors = bgc.getCustom();

        double index = super.myParams.get(0).execute(data);
        bgc.set(customColors.get((int) index - 1));

        return index;
    }
}

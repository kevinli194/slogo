package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import java.util.List;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Pen;


/**
 * Implements the Pen Color function.
 * Returns the color index that the turtle's pen is drawing in.
 *
 * @author SandyLee
 *
 */
public class GetPenColor extends UnaryInstruction {
    private static final long serialVersionUID = -2368059646482772369L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        Pen myPen = data.getTurtle().getPen();
        List<Color> colorList = myPen.getCustom();
        int colorIndex = 0;
        for (int i = 0; i < colorList.size(); i++) {
            if (colorList.get(i).equals(myPen.getPenColor())) {
                colorIndex = i;
            }

        }
        return (double) colorIndex + 1;
    }
}

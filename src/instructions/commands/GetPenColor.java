package instructions.commands;

import java.util.List;
import instructions.UnaryInstruction;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Pen;



public class GetPenColor extends UnaryInstruction {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2368059646482772369L;

    @Override
    public double execute (ObservableData data) {

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

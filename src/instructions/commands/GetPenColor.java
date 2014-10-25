package instructions.commands;

import instructions.ZeroParamInstruction;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Pen;


public class GetPenColor extends ZeroParamInstruction {

    @Override
    public double execute (ObservableData data) {

        Pen myPen = data.getTurtle().getPen();
        ObservableList<Color> colorList = myPen.getCustom();
        int colorIndex = 0;
        for (int i = 0; i < colorList.size(); i++) {
            if (colorList.get(i).equals(myPen.getPenColor())) {
                colorIndex = i;
            }

        }
        return (double) colorIndex + 1;
    }
}

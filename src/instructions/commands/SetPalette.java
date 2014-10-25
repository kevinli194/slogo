package instructions.commands;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import instructions.ParameterInstruction;
import model.ObservableData;
import model.Pen;


public class SetPalette extends ParameterInstruction {
    private static final int COLOR_INDEX = 0;
    private static final int R_VALUE = 0;
    private static final int G_VALUE = 0;
    private static final int B_VALUE = 0;

    public SetPalette () {
        super.numParams = 4;
    }

    @Override
    public double execute (ObservableData data) {

        double index = (int) super.myParams.get(COLOR_INDEX).execute(data);
        double r = super.myParams.get(R_VALUE).execute(data);
        double g = super.myParams.get(G_VALUE).execute(data);
        double b = super.myParams.get(B_VALUE).execute(data);
                
        Pen myPen = data.getTurtle().getPen();
        ObservableList<Color> colorList = myPen.getCustom();
        
        Color color = new Color(r, g, b, 1.0);
        colorList.set((int) index-1, color);
   
        return index;
    }

}

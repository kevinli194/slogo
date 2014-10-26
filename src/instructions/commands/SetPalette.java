package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.ParameterInstruction;
import model.BackgroundColor;
import model.ObservableData;
import model.Pen;
import javafx.scene.paint.Color;
import java.util.List;
import java.util.ArrayList;


/**
 * Implements the SetPalette function.
 * Creates colors and adds them to the custom color list
 * 
 * @author Sandy Lee
 * 
 */
public class SetPalette extends ParameterInstruction {
    private static final long serialVersionUID = 7949829353535801393L;
    private static final int COLOR_INDEX = 0;
    private static final int R_VALUE = 1;
    private static final int G_VALUE = 2;
    private static final int B_VALUE = 3;
    private static final int NUM_PARAM = 4;

    /**
     * Constructo
     */
    public SetPalette () {
        super.myNumParams = NUM_PARAM;
    }

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        double index = (int) super.myParams.get(COLOR_INDEX).execute(data) - 1;
        int r = (int) super.myParams.get(R_VALUE).execute(data);
        int g = (int) super.myParams.get(G_VALUE).execute(data);
        int b = (int) super.myParams.get(B_VALUE).execute(data);

        List<List<Color>> colorLists = new ArrayList<List<Color>>();
        BackgroundColor bgc = (BackgroundColor) data.get("backgroundcolor");
        colorLists.add(bgc.getCustom());

        Pen myPen = data.getTurtle().getPen();
        colorLists.add(myPen.getCustom());

        Color defaultColor = Color.WHITE;
        Color c = Color.rgb(r, g, b);
        for (List<Color> colorList : colorLists) {
            while (colorList.size() <= index) {
                colorList.add(defaultColor);
            }
            colorList.set((int) index, c);
        }

        return index;
    }

}

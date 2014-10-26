package instructions.commands;

import instructions.ParameterInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.scene.paint.Color;
import model.BackgroundColor;
import model.ObservableData;
import model.Pen;
import model.Turtle;
import model.TurtlesList;


public class SetPalette extends ParameterInstruction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7949829353535801393L;
	private static final int COLOR_INDEX = 0;
    private static final int R_VALUE = 1;
    private static final int G_VALUE = 2;
    private static final int B_VALUE = 3;

    public SetPalette () {
        super.numParams = 4;
    }

    @Override
    public double execute (ObservableData data) {

        double index = (int) super.myParams.get(COLOR_INDEX).execute(data) - 1;
        int r = (int) super.myParams.get(R_VALUE).execute(data);
        int g = (int) super.myParams.get(G_VALUE).execute(data);
        int b = (int) super.myParams.get(B_VALUE).execute(data);
            
        
        
        List<List<Color>> colorLists = new ArrayList<List<Color>>();
        BackgroundColor bgc = ((BackgroundColor) data.get("backgroundcolor"));
        colorLists.add(bgc.getCustom());
		
		TurtlesList turtles = data.getTurtles();
		
		Consumer<Turtle> lambda = (Turtle turtle) -> {
	        Pen myPen = turtle.getPen();
	        colorLists.set(1,myPen.getCustom());

	        Color defaultColor = Color.WHITE;
	        Color c = Color.rgb(r, g, b);
	        for (List<Color> colorList : colorLists) {
	            while (colorList.size() <= index) {
	                colorList.add(defaultColor);
	            }
	            colorList.set((int) index, c);
	        }
		};
		turtles.runTurtleMethod(lambda);


        return index;
    }


}

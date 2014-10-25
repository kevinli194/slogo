package instructions.commands;

import instructions.UnaryInstruction;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Turtle;

//need to change it to return some index

public class GetPenColor extends UnaryInstruction {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2368059646482772369L;
	Color[] colorList = { Color.RED, Color.BLUE, Color.GREEN };

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
      
        return  0;
    }
}

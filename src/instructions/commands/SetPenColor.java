package instructions.commands;

import instructions.UnaryInstruction;
import javafx.scene.paint.Color;
import model.ObservableData;
import model.Turtle;


public class SetPenColor extends UnaryInstruction {
    Color[] colorList = { Color.RED, Color.BLUE, Color.GREEN };

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
        double index = super.myParams.get(0).execute(data);
        myTurtle.getPen().setPenColor(colorList[(int) index]);

        return index;
    }
}

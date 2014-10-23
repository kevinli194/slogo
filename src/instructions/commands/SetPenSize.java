package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


public class SetPenSize extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        Turtle myTurtle = data.getTurtle();

        double pixel = super.myParams.get(0).execute(data);

        myTurtle.getPen().setStrokeWidth(pixel);

        return pixel;

    }
}

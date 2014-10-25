package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Pen;


public class SetPenSize extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        Pen myPen = data.getTurtle().getPen();

        double pixel = super.myParams.get(0).execute(data);

        myPen.setStrokeWidth(pixel);

        return pixel;

    }
}

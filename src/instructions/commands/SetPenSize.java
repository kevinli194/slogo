package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Pen;


public class SetPenSize extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4680673263835810284L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub

        Pen myPen = data.getTurtle().getPen();

        double pixel = super.myParams.get(0).execute(data);

        myPen.setStrokeWidth(pixel);

        return pixel;

    }
}

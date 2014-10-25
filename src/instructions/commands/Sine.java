package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;


public class Sine extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5452125779174197011L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double radians = Math.toRadians(myParams.get(0).execute(data));
        return Math.sin(radians);

    }
}

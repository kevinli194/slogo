package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;

public class Tangent extends UnaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8289404842696391974L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double radians = Math.toRadians(super.myParams.get(0).execute(data));
        return Math.tan(radians);

    }
}

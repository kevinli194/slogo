package instructions.commands;

import instructions.BinaryInstruction;
import model.ObservableData;
import model.Turtle;


public class SetTowards extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3869904194532624229L;

	@Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double x = super.myParams.get(0).execute(data);
        double y = super.myParams.get(1).execute(data);

        Turtle myTurtle = data.getTurtle();

        double targetAngle = myTurtle.calculateAngle(0, 0, x, y);
        System.out.println(targetAngle);

        myTurtle.setAngle(targetAngle);

        return myTurtle.getAngle() - targetAngle;
    }
}

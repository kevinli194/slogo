package instructions.commands;

import instructions.UnaryInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;


public class SetHeading extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double amount = myParams.get(0).execute(data);

        Feature myTurtle = data.get("turtle");
		double previousAngle = ((Turtle) myTurtle).getAngle();
        ((Turtle) myTurtle).setAngle(amount);
        return Math.abs(previousAngle - amount);

    }
}

package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


public class SetHeading extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double amount = myParams.get(0).execute(data);

        Turtle myTurtle = (Turtle) data.get("turtle");
        double previousAngle = myTurtle.getAngle();
        myTurtle.setAngle(amount);
        return Math.abs(previousAngle - amount);

    }
}

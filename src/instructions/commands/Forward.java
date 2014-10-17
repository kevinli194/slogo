package instructions.commands;

import instructions.Instruction;
import instructions.UnaryInstruction;
import model.Feature;
import model.ObservableData;
import model.Turtle;


/**
 * This class implements the forward command.
 * The forward command moves the turtle forwards by specified amount.
 * 
 * @author
 * 
 */
public class Forward extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double amount = myParams.get(0).execute(data);
        Feature myTurtle = data.get("turtle");
        ((Turtle) myTurtle).moveTurtleAndDrawLine(amount);
        return amount;
    }
}

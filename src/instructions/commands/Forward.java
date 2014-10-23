package instructions.commands;

import instructions.UnaryInstruction;
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
        double amount = super.myParams.get(0).execute(data);
        Turtle myTurtle = data.getTurtle();
        myTurtle.moveTurtleAndDrawLine(amount);
        return amount;
    }
}

package Instructions.TurtleCommand;

import model.ObservableData;
import model.Turtle;
import Instructions.Instruction;
import Instructions.UnaryInstruction;


/**
 * This class implements the forward command.
 * The forward command moves the turtle forwards by specified amount.
 * 
 * @author 
 * 
 */
public class Forward extends UnaryInstruction{
    
    
    @Override
    public double evaluate () {
        // TODO Auto-generated method stub
        double amount = 0;
        for (Instruction parameter: myParams) {
            amount = parameter.evaluate();
        }
  
        return amount;
    }

    @Override
    public void execute (ObservableData od) {
        // TODO Auto-generated method stub
        Turtle myTurtle = od.getTurtle();
        myTurtle.getCoordinates();
//        od.myTurtle.setX(myTurtle.getX()+amont)
        
    }

}

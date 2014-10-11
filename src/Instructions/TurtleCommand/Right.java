package Instructions.TurtleCommand;

import model.Feature;
import model.ObservableData;
import model.Turtle;
import Instructions.UnaryInstruction;

public class Right extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double amount = myParams.get(0).execute(data);
     
        Feature myTurtle = data.get("turtle");
        ((Turtle) myTurtle).rotate(amount);
        return amount;
    }
}

package Instructions.TurtleCommand;

import model.Feature;
import model.ObservableData;
import model.Turtle;
import Instructions.Instruction;
import Instructions.UnaryInstruction;

public class Back extends UnaryInstruction {

    @Override
    public double execute (ObservableData od) {
        // TODO Auto-generated method stub
        double amount = 0;
        for (Instruction parameter : myParams) {
            amount = parameter.execute(od);
        }

        Feature myTurtle = od.get("turtle");
        ((Turtle) myTurtle).moveTurtleAndDrawLine(-amount);
        return amount;
    }
}

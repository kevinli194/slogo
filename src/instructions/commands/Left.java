package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


public class Left extends UnaryInstruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double amount = myParams.get(0).execute(data);

        Turtle myTurtle = data.getTurtle();

        myTurtle.rotate(360 - amount);
        return amount;
    }
}

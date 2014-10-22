package instructions.commands;

import instructions.UnaryInstruction;
import model.Feature;
import model.ObservableData;
import view.TurtleView;

public class SetBackground extends UnaryInstruction {

    //example
    String[] myColors = {"red", "black", "white"};
    
    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        double index = myParams.get(0).execute(data);
        Feature myTurtle = data.get("turtleview");
        System.out.println(myColors[(int) index]);
        System.out.println(myTurtle);
        ((TurtleView) myTurtle).changeColor(myColors[(int) index]);
        return index;
    }

}

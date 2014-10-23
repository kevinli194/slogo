package instructions.commands;

import javafx.scene.paint.Color;
import instructions.UnaryInstruction;
import model.ObservableData;
import view.TurtleView;


public class SetBackground extends UnaryInstruction {
    Color[] colorList = { Color.RED, Color.BLUE, Color.GREEN };

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        TurtleView myTurtleView = data.getTurtleView();
        double index = super.myParams.get(0).execute(data);
        myTurtleView.changeColor(Color.BLUE);

        return index;
    }
}

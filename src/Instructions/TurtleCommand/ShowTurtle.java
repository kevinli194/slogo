package Instructions.TurtleCommand;

import model.Feature;
import model.ObservableData;
import model.Turtle;
import Instructions.Instruction;

public class ShowTurtle implements Instruction{

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Feature myTurtle = data.get("turtle");
        ((Turtle) myTurtle).setVisible(true);
        ((Turtle) myTurtle).getDrawing().getChildren().add(  ((Turtle) myTurtle).getTurtleImg());
        return 1;
    }

    @Override
    public int getNumParams () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addParam (Instruction param) {
        // TODO Auto-generated method stub
        
    }

}
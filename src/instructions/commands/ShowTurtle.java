package instructions.commands;

import instructions.Instruction;
import model.ObservableData;
import model.Turtle;


public class ShowTurtle implements Instruction {

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();
        myTurtle.setVisible(true);
        myTurtle.getDrawing().getChildren().add(myTurtle.getTurtleImg());
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

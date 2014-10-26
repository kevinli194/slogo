package instructions.commands;

import instructions.Instruction;
import model.ObservableData;
import model.Turtle;


/**
 * implements showturtle command
 * shows the turtle on the screen
 * 
 * @author Sandy Lee
 *
 */
public class ShowTurtle implements Instruction {

    private static final long serialVersionUID = 7056907549306719588L;

    @Override
    public double execute (ObservableData data) {
        Turtle myTurtle = data.getTurtle();
        myTurtle.setVisible(true);
        myTurtle.getDrawing().getChildren().add(myTurtle.getTurtleImg());
        return 1;
    }

    @Override
    public int getNumParams () {
        return 0;
    }

    @Override
    public void addParam (Instruction param) {

    }

}

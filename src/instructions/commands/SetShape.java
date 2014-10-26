package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.UnaryInstruction;
import java.util.List;
import javafx.scene.image.Image;
import model.ObservableData;
import model.Turtle;


/**
 * Implements the Set Shape function.
 * Sets the shape of the turtle to be the shape specified by the index provided.
 * 
 * @author Sandy Lee
 * 
 */
public class SetShape extends UnaryInstruction {
    private static final long serialVersionUID = -8409776343446639835L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        Turtle turtle = data.getTurtle();
        List<Image> shapeList = turtle.getShapeList();
        double index = super.myParams.get(0).execute(data);
        turtle.setShape(shapeList.get((int) index - 1));
        return index;
    }
}

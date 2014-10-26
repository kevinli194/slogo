package instructions.commands;

import instructions.UnaryInstruction;
import java.util.List;
import javafx.scene.image.Image;
import error_checking.InvalidArgumentsException;
import model.ObservableData;
import model.Turtle;


/**
 * Implements the Shape function.
 * Returns the index of the shape in the image list
 * 
 * @author Sandy Lee
 * 
 */
public class GetShape extends UnaryInstruction {

    private static final long serialVersionUID = -2368059646482772369L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {

        Turtle turtle = data.getTurtle();
        List<Image> shapeList = turtle.getShapeList();
        int shapeIndex = 0;
        for (int i = 0; i < shapeList.size(); i++) {
            if (shapeList.get(i).equals(turtle.getTurtleImg())) {
                shapeIndex = i;
            }

        }
        return (double) shapeIndex + 1;
    }
}

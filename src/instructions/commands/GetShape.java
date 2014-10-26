package instructions.commands;

import instructions.UnaryInstruction;
import java.util.List;
import error_checking.InvalidArgumentsException;
import javafx.scene.image.ImageView;
import model.ObservableData;
import model.Turtle;

public class GetShape extends UnaryInstruction {
    /**
     * 
     */
    private static final long serialVersionUID = -2368059646482772369L;

@Override
public double execute (ObservableData data) throws InvalidArgumentsException {

    Turtle turtle = data.getTurtle();
    List<ImageView> shapeList = turtle.getShapeList();
    int shapeIndex = 0;
    for (int i = 0; i < shapeList.size(); i++) {
        if (shapeList.get(i).equals(turtle.getTurtleImg())) {
            shapeIndex = i;
        }

    }
    return (double) shapeIndex + 1;
}
}

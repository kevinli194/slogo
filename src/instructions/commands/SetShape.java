package instructions.commands;

import instructions.UnaryInstruction;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ObservableData;
import model.Turtle;

public class SetShape extends UnaryInstruction {

    /**
     * 
     */
    //TODO: serialize
   
    @Override
    public double execute(ObservableData data) {

            Turtle turtle = data.getTurtle();
            List<Image> shapeList = turtle.getShapeList();
            double index = super.myParams.get(0).execute(data);
            turtle.setShape(shapeList.get((int) index - 1));

            return index;
    }
}

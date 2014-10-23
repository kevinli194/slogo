package model;

import java.util.HashMap;
import java.util.Map;
import javafx.stage.Screen;
import view.TurtleView;


/**
 * 
 * @author Jennie Ju
 * @author Kevin Li
 *
 */
public class ObservableData {
    private TurtleView myTurtleView;
    private Map<String, Feature> myFeatures;
    private Turtle myTurtle;
    private static final double SCREEN_WIDTH = Screen.getPrimary()
            .getVisualBounds().getWidth() * 3 / 4;
    private static final double SCREEN_HEIGHT = Screen.getPrimary()
            .getVisualBounds().getHeight() * 4 / 5;

    public ObservableData () {
        myFeatures = new HashMap<String, Feature>();
        myTurtle = new Turtle();
        myTurtleView = new TurtleView(SCREEN_WIDTH, SCREEN_HEIGHT);

        // Add new features to this list
        addAllToMyFeatures(new History(), new InstructionList(),
                           new VariablesList(), new CommandsList());
    }

    private void addAllToMyFeatures (Feature ... features) {
        for (Feature f : features) {
            String classKey = f.getClass().getSimpleName();
            classKey = classKey.toLowerCase();
            myFeatures.put(classKey, f);
        }
    }

    public Turtle getTurtle () {
        return myTurtle;
    }
    
    public TurtleView getTurtleView () {
        return myTurtleView;
    }

    // If feature needed, get feature by class name
    public Feature get (String classKey) {
        classKey = classKey.toLowerCase();
        if (myFeatures.containsKey(classKey)) { return myFeatures.get(classKey); }
        return null;
    }

    public void clear () {

        for (String key : myFeatures.keySet()) {
            myFeatures.get(key).clear();
        }

    }
}

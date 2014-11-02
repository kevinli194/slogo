// My code starts from line 120 
// SANDY

package view;

import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.BackgroundColor;
import model.CommandsList;
import model.History;
import model.ObservableData;
import model.SlogoModel;
import model.VariablesList;
import error_checking.ErrorDialog;
import error_checking.InvalidArgumentsException;


/**
 * The Slogo window where all the view elements are instantiated. Bridge the
 * front-end GUI and back-end model as the Observer.
 * 
 * @author Mengen Huang
 * @author Kevin Li
 * @author Sandy Lee
 *
 */
public class SlogoWindow extends BorderPane implements Observer {

    private static final double DEFAULT_XCOORDINATE = 300;
    private static final double DEFAULT_YCOORDINATE = 150;
    private static final String PARAMETER_ERROR = "PROBLEM WITH PARAMETERS";
    private KeyControls myControls;
    private TurtleView myTurtleView;
    private InputView myInputView;
    private DataView myDataView;
    private HistoryResultsView myHistoryResultsView;
    private SettingsView mySettingsView;
    private SlogoModel myModel;
    private ObservableData myOD;

    /**
     *
     * @param locale the language and locale used in the window
     * @param width width of View
     * @param height height of View
     */
    public SlogoWindow (Locale locale, double width, double height)
                                                                   throws InvalidArgumentsException {
        myModel = new SlogoModel(locale);
        myModel.addObserver(this);
        myTurtleView = new TurtleView(width, height);
        myInputView = new InputView(myModel, width, height, locale);
        myDataView = new DataView(myInputView, width, height, locale);
        myHistoryResultsView = new HistoryResultsView(myInputView, width,
                                                      height, locale);
        mySettingsView = new SettingsView(myModel, myTurtleView, width, height,
                                          locale);

        setCenter(myTurtleView);
        setRight(myDataView);
        setBottom(myInputView);
        setLeft(myHistoryResultsView);
        setTop(mySettingsView);
        setVisible(true);

        myControls = new KeyControls(myModel, this);

        myModel.load();
        myControls = new KeyControls(myModel, this);

        clickCommand();

    }

    /**
     * Overrided method by Observer Pattern. Update all view when Observable data
     * change and notify the observers.
     */
    @Override
    public void update (Observable o, Object arg) {

        myTurtleView.update((((ObservableData) arg).getTurtle()).generate());
        myDataView.update(
                          ((CommandsList) ((ObservableData) arg).get("CommandsList")),
                          ((VariablesList) ((ObservableData) arg).get("VariablesList")));
        myHistoryResultsView.update(
                                    ((History) ((ObservableData) arg).get("history")).generate(),
                                    ((ObservableData) arg).getReturn());
        myTurtleView.changeColor(((BackgroundColor) ((ObservableData) arg)
                .get("backgroundcolor")).generate());
        mySettingsView.changeBGPicked(((BackgroundColor) ((ObservableData) arg)
                .get("backgroundcolor")).generate());
        mySettingsView.changePenPicked(((ObservableData) arg).getTurtle()
                .getPen().getPenColor());
    }

    /**
     * get the model of the window
     *
     * @return the model corresponding to the window
     */
    public SlogoModel getModel () {
        return myModel;
    }

    /**
     * load the file which stores the history commands
     *
     * @param history The history commands recorded
     */
    public void loadFile (History history) {
        myModel.getMyData().loadFile(history);

    }

    /**
     * Click on or move the turtle to change the state(image) if the command is listed
     */
    private void clickCommand () {
        CommandsList commandsList = (CommandsList) myModel.getMyData().get(
                                                                           "CommandsList");
        myTurtleView.addEventFilter(MouseEvent.MOUSE_CLICKED,
                                    new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle (MouseEvent mouseEvent) {
                                            runClickCommand(commandsList, mouseEvent, "onclick");
                                        }
                                    });

        myTurtleView.addEventFilter(MouseEvent.MOUSE_MOVED,
                                    new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle (MouseEvent mouseEvent) {
                                            runClickCommand(commandsList, mouseEvent, "onmove");
                                        }

                                    });

    }

    public void runClickCommand (CommandsList commandsList, MouseEvent mouseEvent, String command) {
        if (commandsList.contains(command)) {
            double[] coords = new double[2];
            coords[0] = mouseEvent.getX() - DEFAULT_XCOORDINATE;
            coords[1] =
                    -mouseEvent.getY() + DEFAULT_YCOORDINATE;
            try {
                myModel.parseAndExecute(command + " " + coords[0] + " " + coords[1]);
            }
            catch (InvalidArgumentsException e) {
                new ErrorDialog(PARAMETER_ERROR);
            }
        }
    }

}

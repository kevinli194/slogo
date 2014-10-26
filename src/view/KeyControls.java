package view;

import instructions.ConstantInstruction;
import instructions.Instruction;
import instructions.UserDefinedCommand;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.CommandsList;
import model.ObservableData;
import model.SlogoModel;
import parser.Parser;

/**
 * Take in key W,S,A,D,X as the key to move the turtle forward, backward, left,
 * right and set the turtle's head straight upward.
 * @author Mengen Huang
 * @author Kevin Li
 */
public class KeyControls {


    private static final long serialVersionUID = -6381483434400107432L;
    public static final String DEFAULT_LANGUAGE_PACKAGE = "resources.languages/";

    private List<String> keyCommands = new ArrayList<String>();
    SlogoModel myModel;
    BorderPane myWindow;
    Locale myLocale;

    private Map<KeyCode, Instruction> keyMap = new HashMap<KeyCode, Instruction>();

    /**
     * create the KeyControl 
     * @param model model run in the window
     * @param window window shown on the screen
     */
    public KeyControls (SlogoModel model, BorderPane window) {
        myModel = model;
        myWindow = window;
        myLocale = model.getLocale();
        setCommandsList();
        setKeyMap();
        makeKeyCommands();
    }

    /**
     * get the commands in different language to move forward, backward, left,
     * right and setheading.
     */
    private void setCommandsList () {
        ResourceBundle languageBundle =
                ResourceBundle.getBundle(DEFAULT_LANGUAGE_PACKAGE + "Commands", myLocale);
        keyCommands.add(languageBundle.getString("Forward").split(",")[0]);
        keyCommands.add(languageBundle.getString("Backward").split(",")[0]);
        keyCommands.add(languageBundle.getString("Left").split(",")[0]);
        keyCommands.add(languageBundle.getString("Right").split(",")[0]);
        keyCommands.add(languageBundle.getString("SetHeading").split(",")[0]);

    }

    /**
     * Set up the keyMap. Match the Keycode with the specific commands.
     */
    private void setKeyMap () {
        Parser p = myModel.getParser();
        keyMap.put(KeyCode.W, p.parse(keyCommands.get(0) + " 5").pop());
        keyMap.put(KeyCode.S, p.parse(keyCommands.get(1) + " 5").pop());
        keyMap.put(KeyCode.A, p.parse(keyCommands.get(2) + " 10").pop());
        keyMap.put(KeyCode.D, p.parse(keyCommands.get(3) + " 10").pop());
        keyMap.put(KeyCode.X, p.parse(keyCommands.get(4) + " 0").pop());
    }

    /**
     * Once a key is pushed, the corresponding event is triggered so that the 
     * turtle will move according to the keys pressed.
     */
    public void makeKeyCommands () {
        CommandsList commandsList = (CommandsList) myModel.getMyData().get("CommandsList");

        myWindow.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle (KeyEvent arg0) {
                ObservableData data = myModel.getMyData();
                if (keyMap.keySet().contains(arg0.getCode())) {
                    keyMap.get(arg0.getCode()).execute(data);
                }

                // TODO: make sure only one parameter is put into the onkey command
                if (commandsList.contains("onkey"))
                {
                    UserDefinedCommand current = (UserDefinedCommand) commandsList.get("onkey");
                    @SuppressWarnings("deprecation")
                    double value = arg0.getCode().impl_getCode();
                    current.addParam(new ConstantInstruction(value));
                    myModel.parseAndExecute("onkey " + Double.toString(value));

                }
            }
        });
    }
}

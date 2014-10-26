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
import error_checking.InvalidArgumentsException;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.CommandsList;
import model.ObservableData;
import model.SlogoModel;
import parser.Parser;


public class KeyControls implements Serializable {
    /**
	 * 
	 */

    private static final long serialVersionUID = -6381483434400107432L;
    public static final String DEFAULT_LANGUAGE_PACKAGE = "resources.languages/";

    private List<String> keyCommands = new ArrayList<String>();
    SlogoModel myModel;
    BorderPane myWindow;
    Locale myLocale;

    private Map<KeyCode, Instruction> keyMap = new HashMap<KeyCode, Instruction>();

    public KeyControls (SlogoModel model, BorderPane window) throws InvalidArgumentsException {
        myModel = model;
        myWindow = window;
        myLocale = model.getLocale();
        setCommandsList();
        setKeyMap();
        makeKeyCommands();
    }

    private void setCommandsList () {
        ResourceBundle languageBundle =
                ResourceBundle.getBundle(DEFAULT_LANGUAGE_PACKAGE + "Commands", myLocale);
        keyCommands.add(languageBundle.getString("Forward").split(",")[0]);
        keyCommands.add(languageBundle.getString("Backward").split(",")[0]);
        keyCommands.add(languageBundle.getString("Left").split(",")[0]);
        keyCommands.add(languageBundle.getString("Right").split(",")[0]);
        keyCommands.add(languageBundle.getString("SetHeading").split(",")[0]);

    }

    private void setKeyMap () throws InvalidArgumentsException {
        Parser p = myModel.getParser();
        keyMap.put(KeyCode.W, p.parse(keyCommands.get(0) + " 5").pop());
        keyMap.put(KeyCode.S, p.parse(keyCommands.get(1) + " 5").pop());
        keyMap.put(KeyCode.A, p.parse(keyCommands.get(2) + " 10").pop());
        keyMap.put(KeyCode.D, p.parse(keyCommands.get(3) + " 10").pop());
        keyMap.put(KeyCode.X, p.parse(keyCommands.get(4) + " 0").pop());
    }

    public void makeKeyCommands () {
        CommandsList commandsList = (CommandsList) myModel.getMyData().get("CommandsList");

        myWindow.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle (KeyEvent arg0) {
                ObservableData data = myModel.getMyData();
                if (keyMap.keySet().contains(arg0.getCode())) {
                    try {
                        keyMap.get(arg0.getCode()).execute(data);
                    }
                    catch (InvalidArgumentsException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                // TODO: make sure only one parameter is put into the onkey command
                if (commandsList.contains("onkey"))
                {
                    UserDefinedCommand current = (UserDefinedCommand) commandsList.get("onkey");
                    @SuppressWarnings("deprecation")
                    double value = arg0.getCode().impl_getCode();
                    current.addParam(new ConstantInstruction(value));
                    try {
                        myModel.parseAndExecute("onkey " + Double.toString(value));
                    }
                    catch (InvalidArgumentsException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}

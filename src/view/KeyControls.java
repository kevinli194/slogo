package view;

import instructions.ConstantInstruction;
import instructions.Instruction;
import instructions.UserDefinedCommand;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.CommandsList;
import model.ObservableData;
import model.SlogoModel;
import model.VariablesList;
import parser.Parser;


public class KeyControls implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = -6381483434400107432L;
    SlogoModel myModel;
    BorderPane myWindow;

    private Map<KeyCode, Instruction> keyMap = new HashMap<KeyCode, Instruction>();

    public KeyControls (SlogoModel model, BorderPane window) {
        myModel = model;
        myWindow = window;
        setKeyMap();
        makeKeyCommands();
    }

    private void setKeyMap () {
        Parser p = myModel.getParser();
        keyMap.put(KeyCode.W, p.parse("forward 5").pop());
        keyMap.put(KeyCode.S, p.parse("back 5").pop());
        keyMap.put(KeyCode.A, p.parse("left 10").pop());
        keyMap.put(KeyCode.D, p.parse("right 10").pop());
        // keyMap.put(KeyCode.SPACE, p.parse("seth").pop());
    }

    public void makeKeyCommands () {
        CommandsList commandsList = (CommandsList) myModel.getMyData().get("CommandsList");
        myWindow.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle (KeyEvent arg0) {
                ObservableData data = myModel.getMyData();
                if (keyMap.keySet().contains(arg0.getCode())) {
                    keyMap.get(arg0.getCode()).execute(data);
                }
//TODO: make sure only one parameter is put into the onkey command
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

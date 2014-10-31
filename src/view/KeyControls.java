// This entire file is part of my masterpiece.
// MENGEN HUANG
package view;

import instructions.Instruction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import error_checking.ErrorDialog;
import error_checking.InvalidArgumentsException;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.ObservableData;
import model.SlogoModel;
import parser.Parser;

/**
 * Take in key W,S,A,D,X as the key to move the turtle forward, backward, left,
 * right and set the turtle's head straight upward.
 * @author Mengen Huang
 */
public class KeyControls {

    private static final String PARAMETERS = "Values";
	private static final String KEY_CODE = "KeyCode";
	private static final String COMMANDS_NAME = "Instructions";
	private static final int SHORTCUT_KEY_NUMBER = 5;
	private static final String LANGUAGE_RESOURCE =
    								"resources.languages/Commands";
	private static final String DEFAULT_KEYCODE = 
								"resources.parsing/DefaultKeyCode";
	private String[] keyCommandsSyntax;
    private String[] keyCodeString;
    private String[] parameters;
    private ArrayList<KeyCode> keyCode=new ArrayList<KeyCode>();;
  
    private SlogoModel myModel;
    private BorderPane myWindow;
    private Locale myLocale;
    private List<String> keyCommands = new ArrayList<String>();
    private Map<KeyCode, Instruction> keyMap =
    		new HashMap<KeyCode, Instruction>();

    /**
     * Create the KeyControl.
     * @param model model run in the window
     * @param window window shown on the screen
     */
    public KeyControls(SlogoModel model, BorderPane window)
    						throws InvalidArgumentsException {
        myModel = model;
        myWindow = window;
        myLocale = model.getLocale();
        setCommandsList();
        setKeyMap();
        makeKeyCommands();

    }

    /**
     * Get the commands in different language to move forward, backward, left,
     * right and set heading.
     */
    private void setCommandsList() {
    	ResourceBundle languageBundle =
    			ResourceBundle.getBundle(LANGUAGE_RESOURCE,
    					myLocale);
    	readInKeycode();
    	for (String s:keyCommandsSyntax) {
    		keyCommands.add(languageBundle.getString(s).split(",")[0]);
    	}
    }

    /**
     * Read in information and data for shortcut key from properties file.
     */
	private void readInKeycode() {
		keyCommandsSyntax=getValue(COMMANDS_NAME);
    	keyCodeString=getValue(KEY_CODE);
    	parameters = getValue(PARAMETERS);
    	for (String s:keyCodeString) {
    		keyCode.add(KeyCode.getKeyCode(s));
    	}      
	}

	/**
	 * Help function reading in values of properties file.
	 * @param name key word stored in properties file
	 * @return value of corresponding key
	 */
	private String[] getValue(String name) {
		ResourceBundle keyCodeBundle =
    			ResourceBundle.getBundle(DEFAULT_KEYCODE);
		return (String[]) keyCodeBundle.getString(name).split(",");
	}

	/**
     * Set up the keyMap. Match the Keycode with the specific commands.
     * @throws throw the InvalidArgumentsException for parser
     */
    private void setKeyMap() throws InvalidArgumentsException {
        Parser p = myModel.getParser();
        for (int i = 0; i< SHORTCUT_KEY_NUMBER; i++) {
            keyMap.put(keyCode.get(i),
            		p.parse(keyCommands.get(i) + parameters[i]).pop());
        }
    }

    /**
     * Once a key is pushed, the corresponding event is triggered so that the
     * turtle will move according to the keys pressed.
     */
    public void makeKeyCommands() {
        myWindow.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                ObservableData data = myModel.getMyData();
                if (keyMap.keySet().contains(arg0.getCode())) {
                        try {
							keyMap.get(arg0.getCode()).execute(data);
						} catch (InvalidArgumentsException e) {
								new ErrorDialog(e.toString());
						}
                }
            }
        });
    }
}

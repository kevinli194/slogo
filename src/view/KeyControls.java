package view;

import instructions.Instruction;

import java.util.HashMap;
import java.util.Map;

import parser.Parser;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.ObservableData;
import model.SlogoModel;

public class KeyControls {
	SlogoModel myModel;
	BorderPane myWindow;

	private Map<KeyCode, Instruction> keyMap = new HashMap<KeyCode, Instruction>();

	public KeyControls(SlogoModel model, BorderPane window) {
		myModel = model;
		myWindow = window;
		setKeyMap();
		makeKeyCommands();
	}

	private void setKeyMap() {
		Parser p = myModel.getParser();
		keyMap.put(KeyCode.UP, p.parse("forward 5").pop());
		keyMap.put(KeyCode.DOWN, p.parse("back 5").pop());
		keyMap.put(KeyCode.LEFT, p.parse("left 10").pop());
		keyMap.put(KeyCode.RIGHT, p.parse("right 10").pop());
		// keyMap.put(KeyCode.SPACE, p.parse("seth").pop());
	}

	public void makeKeyCommands() {
		myWindow.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				ObservableData data = myModel.getMyData();
				if (keyMap.keySet().contains(arg0.getCode())) {
					keyMap.get(arg0.getCode()).execute(data);
				}

			}
		});
	}
}

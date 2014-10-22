package main;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.SlogoModel;

public class KeyControls {
	SlogoModel myModel;
	Scene myScene;

	public KeyControls(SlogoModel model, Scene scene) {
		myModel = model;
		myScene = scene;
	}

	public void makeKeyCommands() {
		myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getCode() == KeyCode.UP) {
					myModel.up();
				}

			}
		});
	}
}

package controller;

import model.SlogoModel;
import view.SlogoWindow;

public class SlogoController {
	SlogoModel myModel;
	SlogoWindow myView;

	public SlogoController(SlogoModel model, SlogoWindow view) {
		myModel = model;
		myView = view;
	}

}

package controller;

import model.SlogoModel;
import view.SlogoView;

public class SlogoController {
	SlogoModel myModel;
	SlogoView myView;

	public SlogoController(SlogoModel model, SlogoView view) {
		myModel = model;
		myView = view;
	}

}

package model;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class BackgroundColor implements Feature {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2537548285545957011L;
	Color myBackgroundColor;
	ObservableList<Color> myCustom;

	public BackgroundColor() {
		myBackgroundColor = Color.BLACK;
	}

	public Color generate() {
		return myBackgroundColor;
	}

	public void set(Color color) {
		myBackgroundColor = color;
	}

	public void setCustom(ObservableList<Color> custom) {
		myCustom = custom;
	}

	public ObservableList<Color> getCustom() {
		return myCustom;
	}

	@Override
	public void clear() {
		myBackgroundColor = Color.BLACK;
		myCustom.clear();

	}

}

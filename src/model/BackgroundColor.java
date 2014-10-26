package model;

import java.util.List;

import javafx.scene.paint.Color;

public class BackgroundColor implements Feature {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2537548285545957011L;
	Color myBackgroundColor;
	List<Color> myCustom;

	public BackgroundColor() {
		myBackgroundColor = Color.BLACK;
	}

	public Color generate() {
		return myBackgroundColor;
	}

	public void set(Color color) {
		myBackgroundColor = color;
	}

	public void setCustom(List<Color> custom) {
		myCustom = custom;
	}

	public List<Color> getCustom() {
		return myCustom;
	}

	@Override
	public void clear() {
		myBackgroundColor = Color.BLACK;
		myCustom.clear();

	}

	@Override
	public void remove(Object o) {
		myCustom.remove(o);
	}

}

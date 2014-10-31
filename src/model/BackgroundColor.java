package model;

import java.util.List;

import javafx.scene.paint.Color;

/**
 * Model of Background Color of TurtleView.
 * @author Kevin Li
 *
 */
public class BackgroundColor implements Feature {

	private static final long serialVersionUID = 2537548285545957011L;
	Color myBackgroundColor;
	List<Color> myCustom;

	/**
	 * Default background color Black.
	 */
	public BackgroundColor() {
		myBackgroundColor = Color.BLACK;
	}

	/**
	 * Generate the color of the background color.
	 * @return current background color after user update
	 */
	public Color generate() {
		return myBackgroundColor;
	}

	/**
	 * Set the background color to a specified one.
	 * @param color Color to set the TurtleView background
	 */
	public void set(Color color) {
		myBackgroundColor = color;
	}

	/**
	 * Set up the new list of customized color for user to choose.
	 * @param custom updated customized color list
	 */
	public void setCustom(List<Color> custom) {
		myCustom = custom;
	}

	/**
	 * Get list of customized color.
	 * @return list of customized color
	 */
	public List<Color> getCustom() {
		return myCustom;
	}

	/**
	 * Set the background color to the default black and clear the customized color.
	 */
	@Override
	public void clear() {
		myBackgroundColor = Color.BLACK;
		myCustom.clear();

	}

	/**
	 * Remove color from customized color list.
	 */
	@Override
	public void remove(Object o) {
		myCustom.remove(o);
	}

}

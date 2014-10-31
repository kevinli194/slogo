package model;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Set the properties of Pen.
 * 
 * @author Kevin Li
 *
 */
public class Pen {
	private static final Color DEFAULT_COLOR = Color.WHITE;
	private static final int DASHED_STROKE_WIDTH = 5;
	private static final double SOLID_STROKE_WIDTH_1 = .1;
	private static final double SOLID_STROKE_WIDTH_0 = .1;
	private static final int DOTTED_STROKE_WIDTH_1 = 3;
	private static final double DOTTED_STROKE_WIDTH_0 = .2;
	private static final int DEFAULT_LINE_PROPERTY = 1;
	private static final int STROKE_DASH_OFFSET_VALUE = 50;
	private static final double DEFAULT_STROKE_WIDTH = 3;
	private Color myLineColor;
	private boolean isPenDown;
	private double myStrokeWidth;
	private List<Color> myCustom;
	private double[] myLineProperty = new double[2];

	/**
	 * Set the default property of the pen.
	 */
	public Pen() {
		myLineColor = DEFAULT_COLOR;
		isPenDown = true;
		myStrokeWidth = DEFAULT_STROKE_WIDTH;
		myLineProperty[0] = DEFAULT_LINE_PROPERTY;
		myLineProperty[1] = DEFAULT_LINE_PROPERTY;
	}

	/**
	 * Set the Customized color list.
	 * 
	 * @param custom
	 *            customized color list
	 */
	public void setCustom(List<Color> custom) {
		myCustom = custom;
	}

	/**
	 * Set the stroke width of the pen.
	 * 
	 * @param width
	 *            width of the stroke
	 */
	public void setStrokeWidth(double width) {
		myStrokeWidth = width;
	}

	/**
	 * Set the pen color.
	 * 
	 * @param color
	 *            color of the pen
	 */
	public void setPenColor(Color color) {
		myLineColor = color;
	}

	/**
	 * Set the pen down.
	 * 
	 * @param state
	 *            state to represent if the pen is up or down
	 */
	public void setPenDown(boolean state) {
		isPenDown = state;
	}

	/**
	 * Return if the pen is down. Return 0 when up, 1 when down.
	 * 
	 * @return
	 */
	public double isPenDown() {
		if (isPenDown) {
			return 1;
		}
		return 0;
	}

	/**
	 * Get the pen color.
	 * 
	 * @return the color of the pen
	 */
	public Color getPenColor() {
		return myLineColor;
	}

	/**
	 * Get the starting and ending point and draw the line.
	 * 
	 * @param start
	 *            starting point of the line
	 * @param end
	 *            ending point of the line
	 * @return the line
	 */
	public Line drawLine(double[] start, double[] end) {
		if (isPenDown) {
			return createLine(start, end, myLineColor);
		}

		return createLine(start, end, null);

	}

	/**
	 * Help method of drawLine.
	 * 
	 * @param start
	 *            starting point of the line
	 * @param end
	 *            ending point of the line
	 * @param color
	 *            color of the line
	 * @return the line
	 */
	public Line createLine(double[] start, double[] end, Color color) {
		Line line = new Line(start[0], start[1], end[0], end[1]);
		line.setStroke(color);
		line.setStrokeWidth(myStrokeWidth);
		line.getStrokeDashArray().addAll(myLineProperty[0], myLineProperty[1]);
		line.setStrokeDashOffset(STROKE_DASH_OFFSET_VALUE);
		return line;
	}

	/**
	 * Get the list of customized color.
	 * 
	 * @return customized color list
	 */
	public List<Color> getCustom() {
		return myCustom;
	}

	/**
	 * Clear the Customized color and set the pen color to default white.
	 */
	public void clear() {
		setPenColor(Color.WHITE);
		myCustom.clear();
	}

	/**
	 * Change the properties of the line.
	 * 
	 * @param properties
	 *            name of the properties of the line
	 */
	public void changeLineProperty(String properties) {
		setPenDown(true);
		if (properties == "dotted") {
			myLineProperty[0] = myStrokeWidth * DOTTED_STROKE_WIDTH_0;
			myLineProperty[1] = myStrokeWidth * DOTTED_STROKE_WIDTH_1;
		}
		if (properties == "solid") {
			myLineProperty[0] = SOLID_STROKE_WIDTH_0;
			myLineProperty[1] = SOLID_STROKE_WIDTH_1;
		}
		if (properties == "dashed") {
			myLineProperty[0] = myStrokeWidth * DASHED_STROKE_WIDTH;
			myLineProperty[1] = myStrokeWidth * DASHED_STROKE_WIDTH;
		}
	}

}

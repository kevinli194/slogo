package model;

import java.io.Serializable;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Pen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1512292990210270763L;
	private Color myLineColor;
	private boolean isPenDown;
	private double myStrokeWidth;
	private List<Color> myCustom;
	private double[] myLineProperty;

	public Pen() {
		myLineColor = Color.WHITE;
		isPenDown = true;
		myStrokeWidth = 3;
		myLineProperty = new double[2];
		myLineProperty[0] = 1;
		myLineProperty[1] = 1;
	}

	// duplicated code from backgroundcolor
	public void setCustom(List<Color> custom) {
		myCustom = custom;
	}

	public void setStrokeWidth(double width) {
		myStrokeWidth = width;
	}

	public void setPenColor(Color color) {
		myLineColor = color;
	}

	public void setPenDown(boolean state) {
		isPenDown = state;
	}

	public double isPenDown() {
		if (isPenDown) {
			return 1;
		}
		return 0;
	}

	public Color getPenColor() {
		return myLineColor;
	}

	public Line drawLine(double[] start, double[] end) {
		if (isPenDown) {
			return createLine(start, end, myLineColor);
		}
		// How should this be dealt, should no line be given. Or should a clear
		// line be given.

		return createLine(start, end, null);

	}

	public Line createLine(double[] start, double[] end, Color color) {
		Line line = new Line(start[0], start[1], end[0], end[1]);
		line.setStroke(color);
		line.setStrokeWidth(myStrokeWidth);
		line.getStrokeDashArray().addAll(myLineProperty[0], myLineProperty[1]);
		line.setStrokeDashOffset(50);
		return line;
	}

	public List<Color> getCustom() {
		return myCustom;
	}

	public void clear() {
		setPenColor(Color.WHITE);
		myCustom.clear();
	}

	public void changeLineProperty(String properties) {
		setPenDown(true);
		if (properties == "dotted") {
			myLineProperty[0] = myStrokeWidth * .2;
			myLineProperty[1] = myStrokeWidth * 3;
		}
		if (properties == "solid") {
			myLineProperty[0] = .1;
			myLineProperty[1] = .1;
		}
		if (properties == "dashed") {
			myLineProperty[0] = myStrokeWidth * 5;
			myLineProperty[1] = myStrokeWidth * 5;
		}
	}

}

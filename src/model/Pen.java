package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Pen {
	private Color myLineColor;
	private boolean isPenDown;
	private double myStrokeWidth;

	public Pen() {
		myLineColor = Color.WHITE;
		isPenDown = true;
		myStrokeWidth = 3;
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

	
	public Line drawLine(double[] start, double[] end) {
		if (isPenDown) {
			Line line = new Line(start[0], start[1], end[0], end[1]);
			line.setStroke(myLineColor);
			line.setStrokeWidth(myStrokeWidth);
			return line;
		}
		// How should this be dealt, should no line be given. Or should a clear
		// line be given.
		return null;

	}

}

package model;

import com.sun.javafx.geom.Vec2d;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class Turtle {
	ImageView myImage;
	double[] myCoordinates;
	double myAngle;
	Pen myPen;

	// Instantiates a turtle with coordinates at (0,0), angle at 90, and a
	// black/down Pen.
	public Turtle() {
	}

	// Returns the current coordinates of the turtle;
	public double[] getCoordinates() {
		return myCoordinates;
	}

	// Calls the drawLine function in the Pen using the myCoordinates as starts
	// and the coordinates from the calculateEndCoordinates method. Then it sets
	// the turtle coordinates to end coordinates.
	public Line moveTurtleAndDrawLine(int distance) {
		return new Line();
	}

	// Changes the turtle's angle based on
	public void rotate(double deltaAngle) {
	}

	// Sets the turtle's angle.
	public void setAngle(double angle) {

	}

	// Uses the current angle, coordinates, and distance needed to travel in
	// order to calculate end coordinates.
	private double[] calculateEndCoord(double distance) {
		return new double[2];
	}

}
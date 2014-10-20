package model;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class Turtle implements Feature {
	private static final double DEFAULT_CENTRE_COORDINATE = 300;
	private static final double DEFAULT_TURTLE_ANGLE = 0;
	private static final double DEFAULT_TURTLE_SIZE = 30;
	private static final double FULL_ROTATION_DEGREE = 360;

	private static final String DEFAULT_TURTLE_IMAGE = "default_turtle.gif";

	private ImageView myImage;
	private double[] myRelativeCoordinates;
	private double[] myCoordinates = { DEFAULT_CENTRE_COORDINATE,
			DEFAULT_CENTRE_COORDINATE };
	private double myAngle = DEFAULT_TURTLE_ANGLE;
	private Pen myPen;
	private Group myDrawing;
	private Group myLines;
	private Image myDefault = new Image(getClass().getResourceAsStream(
			DEFAULT_TURTLE_IMAGE));
	private boolean isVisible;

	public Turtle() {
		myImage = new ImageView(myDefault);
		myPen = new Pen();
		myDrawing = new Group();
		myLines = new Group();
		InitializeTurtle();
		myDrawing.getChildren().add(myLines);
		myDrawing.getChildren().add(myImage);
		isVisible = true;
	}

	private void InitializeTurtle() {
		myImage.setFitWidth(DEFAULT_TURTLE_SIZE);
		myImage.setFitHeight(DEFAULT_TURTLE_SIZE);
		clear();
	}

	public void changeImage(ImageView image) {
		myImage = image;
	}

	public double[] getCoordinates() {
		for (int i = 0; i < 2; i++) {
			myRelativeCoordinates[i] = myCoordinates[i]
					- DEFAULT_CENTRE_COORDINATE;
		}
		return myRelativeCoordinates;
	}

	public void setVisible(boolean state) {
		isVisible = state;
		if (!isVisible) {
			myDrawing.getChildren().remove(myImage);
		}
	}

	public double isVisible() {
		return isVisible ? 1 : 0;
	}

	public void setCoordinates(double x, double y) {

		myCoordinates[0] = x;
		myCoordinates[1] = y;
		myImage.setTranslateX(myCoordinates[0]);
		myImage.setTranslateY(myCoordinates[1]);

	}

	public void rotate(double deltaAngle) {
		myAngle = (myAngle + deltaAngle) % FULL_ROTATION_DEGREE;
		myImage.setRotate(myAngle);
	}

	public void setAngle(double angle) {
		myAngle = angle % FULL_ROTATION_DEGREE;
		myImage.setRotate(myAngle);
	}

	public double getAngle() {
		return myAngle;
	}

	public Pen getPen() {
		return myPen;
	}

	public void moveTurtleAndDrawLine(double distance) {
		Line line = myPen.drawLine(myCoordinates, calculateEndCoord(distance));
		myLines.getChildren().add(line);
		setCoordinates(calculateEndCoord(distance)[0],
				calculateEndCoord(distance)[1]);
	}

	private double[] calculateEndCoord(double distance) {
		double[] endCoords = new double[2];
		endCoords[0] = myCoordinates[0] + distance
				* Math.sin(Math.toRadians(myAngle));
		endCoords[1] = myCoordinates[1] + distance
				* Math.cos(Math.toRadians(myAngle));
		return endCoords;
	}

	public Group getDrawing() {
		return myDrawing;
	}

	public ImageView getTurtleImg() {
		return myImage;
	}

	public Node generate() {
		return myDrawing;
	}

	@Override
	public void clear() {
		myLines.getChildren().clear();
		setCoordinates(DEFAULT_CENTRE_COORDINATE, DEFAULT_CENTRE_COORDINATE);
		setAngle(DEFAULT_TURTLE_ANGLE);

	}
}
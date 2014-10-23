package model;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class Turtle extends TurtleAbstract implements Feature {

	private ImageView myImage;

	private double[] myCoordinates = { DEFAULT_XCOORDINATE, DEFAULT_YCOORDINATE };
	private double myAngle = DEFAULT_TURTLE_ANGLE;
	private Pen myPen;
	private Group myDrawing;
	private Group myLines;
	private Tooltip myTurtleInfo;
	private Image myDefaultOn = new Image(getClass().getResourceAsStream(
			DEFAULT_ON_IMAGE));
	private Image myDefaultOff = new Image(getClass().getResourceAsStream(
			DEFAULT_OFF_IMAGE));
	private boolean isVisible;
	private boolean myState = true;

	public Turtle() {

		myPen = new Pen();
		myTurtleInfo = new Tooltip();
		myLines = new Group();
		myDrawing = new Group();
		initializeTurtle();
		setTurtleInfo();
		myDrawing.getChildren().addAll(myLines, myImage);
		isVisible = true;

	}

	private void initializeTurtle() {
		myImage = new ImageView(myDefaultOn);
		myImage.setFitWidth(DEFAULT_TURTLE_SIZE);
		myImage.setFitHeight(DEFAULT_TURTLE_SIZE);
		setCoordinates(DEFAULT_XCOORDINATE, DEFAULT_YCOORDINATE);
		setAngle(DEFAULT_TURTLE_ANGLE);
		myImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				changeState();

			}
		});

	}

	private void changeState() {
		myState = !myState;
		if (myState) {
			myImage.setImage(myDefaultOn);
		} else {
			myImage.setImage(myDefaultOff);
		}
	}

	public double[] getCoordinates() {

		return myCoordinates;
	}

	public void setCoordinates(double x, double y) {
		if (myState) {
			myCoordinates[0] = x;
			myCoordinates[1] = y;
			myImage.setTranslateX(myCoordinates[0]);
			myImage.setTranslateY(myCoordinates[1]);
		}

	}

	public void setVisible(boolean state) {
		isVisible = state;
		if (!isVisible) {
			myDrawing.getChildren().remove(myImage);
		} else {
			myDrawing.getChildren().add(myImage);
		}
	}

	// TODO: need to clean up code
	public void stampImage() {
		ImageView newImage = new ImageView(myDefaultOn);
		myDrawing.getChildren().add(newImage);
		newImage.setFitWidth(DEFAULT_TURTLE_SIZE);
		newImage.setFitHeight(DEFAULT_TURTLE_SIZE);
		newImage.setTranslateX(myCoordinates[0]);
		newImage.setTranslateY(myCoordinates[1]);
	}

	public double isVisible() {
		return isVisible ? 1 : 0;
	}

	public void rotate(double deltaAngle) {
		if (myState) {
			myAngle = (myAngle + deltaAngle) % FULL_ROTATION_DEGREE;
			myImage.setRotate(myAngle);
			setTurtleInfo();
		}
	}

	public void setAngle(double angle) {
		if (myState) {
			myAngle = angle % FULL_ROTATION_DEGREE;
			myImage.setRotate(myAngle);
		}
	}

	public double getAngle() {
		return Math.round(myAngle * 10) / 10.0;
	}

	public Pen getPen() {
		return myPen;
	}

	public void moveTurtleAndDrawLine(double distance) {
		if (myState) {
			Line line = myPen.drawLine(myCoordinates,
					calculateEndCoord(distance));
			myLines.getChildren().add(line);
			setCoordinates(calculateEndCoord(distance)[0],
					calculateEndCoord(distance)[1]);
			setTurtleInfo();
		}
	}

	private double[] calculateEndCoord(double distance) {
		double[] endCoords = new double[2];
		endCoords[0] = myCoordinates[0] + distance
				* Math.sin(Math.toRadians(myAngle));
		endCoords[1] = myCoordinates[1] - distance
				* Math.cos(Math.toRadians(myAngle));
		return endCoords;
	}

	public double calculateDistance(double[] startCoords, double[] finalCoords) {
		double xDiff = finalCoords[0] - startCoords[0];
		double yDiff = finalCoords[1] - startCoords[1];

		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	private void setTurtleInfo() {
		myTurtleInfo.setText("Coordinates: ("
				+ ((int) getCoordinates()[0] - DEFAULT_XCOORDINATE) + ", "
				+ (-(int) getCoordinates()[1] + DEFAULT_YCOORDINATE) + ")"
				+ "\nAngle: " + (int) getAngle() + " �");
		Tooltip.install(myImage, myTurtleInfo);
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
		setCoordinates(DEFAULT_XCOORDINATE, DEFAULT_YCOORDINATE);
		setAngle(DEFAULT_TURTLE_ANGLE);
		setTurtleInfo();

	}

}

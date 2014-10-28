package model;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Class that simulates the action of the turtle.
 * @author Kevin Li
 * @author Mengen Huang
 *
 */
public class Turtle extends TurtleAbstract implements Feature {

	private static final double _10_0 = 10.0;

	private static final int _10 = 10;

	private static final int FULL_CIRCLE_DEGREE = 360;

	private static final long serialVersionUID = 3491015094836744017L;

	private ImageView myImage;
	private ObservableList<Image> myTurtleShapes;
	private double[] myCoordinates = { DEFAULT_XCOORDINATE, DEFAULT_YCOORDINATE };
	private double[] myRelativeCoordinates = { DEFAULT_REALATIVE_COORDINATE,
			DEFAULT_REALATIVE_COORDINATE };
	private double myAngle = DEFAULT_TURTLE_ANGLE;
	private Pen myPen;
	private Group myDrawing;
	private Group myLines;
	private Group myStamps;

	private Tooltip myTurtleInfo;
	private Image myDefaultOn = new Image(getClass().getResourceAsStream(
			DEFAULT_ON_IMAGE));
	private Image myDefaultOff = new Image(getClass().getResourceAsStream(
			DEFAULT_OFF_IMAGE));
	private boolean isVisible;
	private boolean myState = true;

/**
 * Instantiate all the elements in turtle view.
 */
	public Turtle() {

		myPen = new Pen();
		myTurtleInfo = new Tooltip();
		myLines = new Group();
		myDrawing = new Group();
		myStamps = new Group();
		initializeTurtle();
		setTurtleInfo();
		myDrawing.getChildren().addAll(myLines, myImage, myStamps);
		isVisible = true;

	}

	/**
	 * Initialize the turtle.
	 */
	private void initializeTurtle() {
		myImage = new ImageView(myDefaultOn);
		myImage.setFitWidth(DEFAULT_TURTLE_SIZE);
		myImage.setFitHeight(DEFAULT_TURTLE_SIZE);
		setCoordinates(DEFAULT_REALATIVE_COORDINATE,
				DEFAULT_REALATIVE_COORDINATE);
		setAngle(DEFAULT_TURTLE_ANGLE);
		myImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				changeState();
			}
		});

	}

	/**
	 * Initiate the list of turtles.
	 * @param shapes
	 */
	public void ListofTurtles(ObservableList<Image> shapes) {
		myTurtleShapes = shapes;
	}

	/**
	 * Get the list of shapes of turtles.
	 * @return
	 */
	public List<Image> getShapeList() {
		return myTurtleShapes;
	}

	/**
	 * Set the shape of the turtle.
	 * @param image Image of the turtle
	 */
	public void setShape(Image image) {
		myImage.setImage(image);
	}

	/**
	 * Change the state of the turtle by setting the turtle with different images.
	 */
	private void changeState() {
		myState = !myState;
		if (myState) {
			myImage.setImage(myDefaultOn);
		} else {
			myImage.setImage(myDefaultOff);
		}
	}

	/**
	 * Get the Coordinates of the turtle. The center point as (0,0).
	 * @return Turtle's relative coordinate to the center of the TurtleView
	 */
	public double[] getCoordinates() {

		return myRelativeCoordinates;
	}

	/**
	 * Set the turtle to a specific position.
	 * @param x relative x coordinate
	 * @param y relative y coordinate
	 */
	public void setCoordinates(double x, double y) {
		if (myState) {
			myRelativeCoordinates[0] = x;
			myRelativeCoordinates[1] = y;
			myCoordinates[0] = x + DEFAULT_XCOORDINATE;
			myCoordinates[1] = -y + DEFAULT_YCOORDINATE;
			myImage.setTranslateX(myCoordinates[0]);
			myImage.setTranslateY(myCoordinates[1]);
			setTurtleInfo();
		}

	}

	/**
	 * Set the turtle visible or not.
	 * @param state if the turtle is visible
	 */
	public void setVisible(boolean state) {
		isVisible = state;
		if (!isVisible) {
			myDrawing.getChildren().remove(myImage);
		} else {
			myDrawing.getChildren().add(myImage);
		}
	}

	/**
	 * Stamp the turtle image.
	 */
	public void stampImage() {
		ImageView newImage = new ImageView(myDefaultOn);
		myDrawing.getChildren().add(newImage);
		newImage.setFitWidth(DEFAULT_TURTLE_SIZE);
		newImage.setFitHeight(DEFAULT_TURTLE_SIZE);
		newImage.setTranslateX(myCoordinates[0]);
		newImage.setTranslateY(myCoordinates[1]);
		myStamps.getChildren().add(newImage);

	}

	/**
	 * Clear the stamp turtle images.
	 */
	public void clearStamp() {
		myStamps.getChildren().clear();

	}

	/**
	 * Return value if the turtle is visible.
	 * @return 1 if visible; 0 if not
	 */
	public double isVisible() {
		return isVisible ? 1 : 0;
	}

	/**
	 * Rotate the turtle image according to the given angle.
	 * @param deltaAngle The angle the turtle should rotate
	 */
	public void rotate(double deltaAngle) {
		if (myState) {
			myAngle = (myAngle + deltaAngle) % FULL_ROTATION_DEGREE;
			myImage.setRotate(myAngle);
			setTurtleInfo();
		}
	}

	/**
	 * Set the angle of rotation.
	 * @param angle angle the image should rotate
	 */
	public void setAngle(double angle) {
		if (myState) {
			myAngle = angle % FULL_ROTATION_DEGREE;
			myImage.setRotate(myAngle);
		}
	}

	/**
	 * Calculate the angle between two points.
	 * @param currentX current X coordinate
	 * @param currentY current Y coordinate
	 * @param targetX target X coordinate
	 * @param targetY target Y coordinate
	 * @return the arc tangent angle between two points
	 */
	public double calculateAngle(double currentX, double currentY,
			double targetX, double targetY) {
		double angle = (double) Math.toDegrees(
				 Math.atan2(targetY - currentY, targetX - currentX));

		if (angle < 0) {
			angle += FULL_CIRCLE_DEGREE;
		}

		return angle;
	}

	/**
	 * Get the angle of the turtle.
	 * @return the angle rounded to 0.1
	 */
	public double getAngle() {
		return Math.round(myAngle * _10) / _10_0;
	}

	/**
	 * Get the pen of the turtle.
	 * @return the pen
	 */
	public Pen getPen() {
		return myPen;
	}

	/**
	 * Change the pen color.
	 * @param color color the pen color should change to
	 */
	public void changePenColor(Color color) {
		myPen.setPenColor(color);
	}

	/**
	 * Move the turtle and draw the line from the current location.
	 * @param distance the turtle should move forward
	 */
	public void moveTurtleAndDrawLine(double distance) {
		if (myState) {
			Line line = myPen.drawLine(myCoordinates,
					calculateEndCoord(distance));
			myLines.getChildren().add(line);
			setCoordinates(
					calculateEndCoord(distance)[0] - DEFAULT_XCOORDINATE,
					-calculateEndCoord(distance)[1] + DEFAULT_YCOORDINATE);
			setTurtleInfo();
		}
	}

	/**
	 * Calculate the end coordination after going forward a certain distance.
	 * @param distance the distance the turtle will go forward
	 * @return the end coordinate
	 */
	private double[] calculateEndCoord(double distance) {
		double[] endCoords = new double[2];
		endCoords[0] = myCoordinates[0] + distance
				* Math.sin(Math.toRadians(myAngle));
		endCoords[1] = myCoordinates[1] - distance
				* Math.cos(Math.toRadians(myAngle));
		return endCoords;
	}

	/**
	 * Calculate the distance between two coordinates.
	 * @param startCoords starting coordinates
	 * @param finalCoords ending coordinates
	 * @return the distance between two coordinates
	 */
	public double calculateDistance(double[] startCoords, double[] finalCoords) {
		double xDiff = finalCoords[0] - startCoords[0];
		double yDiff = finalCoords[1] - startCoords[1];

		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	/**
	 * Get the Coordinate of all the turtles in one window.
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return list of coordinates
	 */
	public List<double[]> getCoordList(double x, double y) {
		List<double[]> coords = new ArrayList<double[]>();

		double[] prevCoords = myCoordinates.clone();
		setCoordinates(x, y);
		double[] currentCoords = myCoordinates.clone();
		coords.add(prevCoords);
		coords.add(currentCoords);
		return coords;
	}

	/**
	 * Set the turtle info and show the xy coordinate and angle at Tooltip.
	 */
	private void setTurtleInfo() {
		myTurtleInfo.setText("Coordinates: (" + (int) myRelativeCoordinates[0]
				+ ", " + (int) myRelativeCoordinates[1] + ")" + "\nAngle: "
				+ (int) getAngle() + " �");
		Tooltip.install(myImage, myTurtleInfo);
	}

	/**
	 * Get all the elements in drawing.
	 * @return Drawing which contains turtle and lines
	 */
	public Group getDrawing() {
		return myDrawing;
	}

	/**
	 * Get the turtle image.
	 * @return the image of the turtle
	 */
	public ImageView getTurtleImg() {
		return myImage;
	}

	/**
	 * Generate the node to pass to the front end to show.
	 * @return The drawing group which contains turtle and lines
	 */
	public Node generate() {
		return myDrawing;
	}

	/**
	 * Clear the line and stamp. Set the turtle back to
	 * the default coordinates and default angle.
	 * Update the turtle info.
	 */
	@Override
	public void clear() {
		myLines.getChildren().clear();
		myStamps.getChildren().clear();
		setCoordinates(DEFAULT_REALATIVE_COORDINATE,
				DEFAULT_REALATIVE_COORDINATE);
		setAngle(DEFAULT_TURTLE_ANGLE);
		setTurtleInfo();

	}

	/**
	 * Set the pen color as a customized one.
	 * @param customColors list of customized color
	 */
	public void setPenCustom(ObservableList<Color> customColors) {
		myPen.setCustom(customColors);

	}

	/**
	 * Set the toggle grid visible.
	 */
	public void toggleVisible() {
		setVisible(!isVisible);

	}

	@Override
	public void remove(Object n) {

	}

	/**
	 * Initiate list of turtles.
	 * @param items all the image of the turtles
	 */
	public void initListofTurtles(ObservableList<Image> items) {
		myTurtleShapes = items;

	}

}

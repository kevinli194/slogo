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

public class Turtle extends TurtleAbstract implements Feature {

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

	public void ListofTurtles(ObservableList<Image> shapes) {
		myTurtleShapes = shapes;
	}

	public List<Image> getShapeList() {
		return myTurtleShapes;
	}

	public void setShape(Image image) {
		myImage.setImage(image);
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

		return myRelativeCoordinates;
	}

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

	public void setVisible(boolean state) {
		isVisible = state;
		if (!isVisible) {
			myDrawing.getChildren().remove(myImage);
		} else {
			myDrawing.getChildren().add(myImage);
		}
	}

	// TODO: need to fix code after being able to choose turtle images
	public void stampImage() {
		ImageView newImage = new ImageView(myDefaultOn);
		myDrawing.getChildren().add(newImage);
		newImage.setFitWidth(DEFAULT_TURTLE_SIZE);
		newImage.setFitHeight(DEFAULT_TURTLE_SIZE);
		newImage.setTranslateX(myCoordinates[0]);
		newImage.setTranslateY(myCoordinates[1]);
		myStamps.getChildren().add(newImage);

	}

	public void clearStamp() {
		myStamps.getChildren().clear();

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

	public double calculateAngle(double currentX, double currentY,
			double targetX, double targetY) {
		double angle = (double) Math.toDegrees(Math.atan2(targetY - currentY,
				targetX - currentX));

		if (angle < 0) {
			angle += 360;
		}

		return angle;
	}

	public double getAngle() {
		return Math.round(myAngle * 10) / 10.0;
	}

	public Pen getPen() {
		return myPen;
	}

	// Should get rid of getPen and change the pen from within the turtle?
	// Example below.
	public void changePenColor(Color color) {
		myPen.setPenColor(color);
	}

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

	public List<double[]> getCoordList(double x, double y) {
		List<double[]> coords = new ArrayList<double[]>();

		double[] prevCoords = myCoordinates.clone();
		setCoordinates(x, y);
		double[] currentCoords = myCoordinates.clone();
		coords.add(prevCoords);
		coords.add(currentCoords);
		return coords;
	}

	private void setTurtleInfo() {
		myTurtleInfo.setText("Coordinates: (" + (int) myRelativeCoordinates[0]
				+ ", " + (int) myRelativeCoordinates[1] + ")" + "\nAngle: "
				+ (int) getAngle() + " �");
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
		myStamps.getChildren().clear();
		setCoordinates(DEFAULT_REALATIVE_COORDINATE,
				DEFAULT_REALATIVE_COORDINATE);
		setAngle(DEFAULT_TURTLE_ANGLE);
		setTurtleInfo();

	}

	public void setPenCustom(ObservableList<Color> customColors) {
		myPen.setCustom(customColors);

	}

	public void toggleVisible() {
		setVisible(!isVisible);

	}

	@Override
	public void remove(Object n) {
		// TODO Auto-generated method stub

	}

	public void initListofTurtles(ObservableList<Image> items) {
		myTurtleShapes = items;

	}

}

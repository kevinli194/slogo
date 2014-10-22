package model;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Turtle implements Feature {
	private static final double DEFAULT_XCOORDINATE = 300;
	private static final double DEFAULT_YCOORDINATE = 150;

	private static final double DEFAULT_TURTLE_ANGLE = 0;
	private static final double DEFAULT_TURTLE_SIZE = 30;
	private static final double FULL_ROTATION_DEGREE = 360;

	private static final String DEFAULT_TURTLE_IMAGE = "default_turtle.gif";

	private ImageView myImage;
	// private double[] myRelativeCoordinates = { 0, 0 };
	private double[] myCoordinates = { DEFAULT_XCOORDINATE, DEFAULT_YCOORDINATE };
	private double myAngle = DEFAULT_TURTLE_ANGLE;
	private Pen myPen;
	private Group myDrawing;
	private Group myLines;
	private Text myTurtleInfo;
	private Image myDefault = new Image(getClass().getResourceAsStream(
			DEFAULT_TURTLE_IMAGE));
	private boolean isVisible;
	private boolean infoVis = true;

	public Turtle() {
		myImage = new ImageView(myDefault);
		myPen = new Pen();
		myTurtleInfo = new Text();
		myLines = new Group();
		myDrawing = new Group();
		InitializeTurtle();
		myDrawing.getChildren().addAll(myTurtleInfo, myLines, myImage);
		isVisible = true;

	}

	private void InitializeTurtle() {
		myImage.setFitWidth(DEFAULT_TURTLE_SIZE);
		myImage.setFitHeight(DEFAULT_TURTLE_SIZE);
		setTurtleInfo();
		clear();
	}

	private void setTurtleInfo() {
		myTurtleInfo.setTranslateX(480);
		myTurtleInfo.setTranslateY(20);
	}

	public void changeImage(ImageView image) {
		myImage = image;
	}

	public double[] getCoordinates() {

		return myCoordinates;
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
		updateTurtleInfo();
	}

	public void setAngle(double angle) {
		myAngle = angle % FULL_ROTATION_DEGREE;
		myImage.setRotate(myAngle);
	}

	public double getAngle() {
		return Math.round(myAngle * 10) / 10.0;
	}

	public Pen getPen() {
		return myPen;
	}

	public void moveTurtleAndDrawLine(double distance) {
		Line line = myPen.drawLine(myCoordinates, calculateEndCoord(distance));
		myLines.getChildren().add(line);
		setCoordinates(calculateEndCoord(distance)[0],
				calculateEndCoord(distance)[1]);
		updateTurtleInfo();
	}

	private double[] calculateEndCoord(double distance) {
		double[] endCoords = new double[2];
		endCoords[0] = myCoordinates[0] + distance
				* Math.sin(Math.toRadians(myAngle));
		endCoords[1] = myCoordinates[1] - distance
				* Math.cos(Math.toRadians(myAngle));
		return endCoords;
	}

	private void updateTurtleInfo() {
		myTurtleInfo.setText("x:" + getCoordinates()[0] + " y:"
				+ getCoordinates()[1] + " °:" + getAngle());
		myTurtleInfo.setFill(Color.GREEN);
		myTurtleInfo.setFont(Font.font(null, FontWeight.BOLD, 12));
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
		updateTurtleInfo();

	}

	public void switchInfoVis() {
		infoVis = !infoVis;
		myTurtleInfo.setVisible(infoVis);
	}

}
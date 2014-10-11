package model;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;


public class Turtle extends Feature {

    private ImageView myImage;
    private double[] myCoordinates;
    private double myAngle;
    private Pen myPen;
    private Group myDrawing;
    private Group myLines;
    private Image myDefault = new Image(getClass().getResourceAsStream(
                                                                       "default_turtle.gif"));

    public Turtle () {

        myImage = new ImageView(myDefault);
        myImage.setFitWidth(30);
        myImage.setFitHeight(30);
        myPen = new Pen();
        myCoordinates = new double[2];
        myCoordinates[0] = 300;
        myCoordinates[1] = 300;
        myAngle = 0;
        myDrawing = new Group();
        myLines = new Group();
        myDrawing.getChildren().add(myImage);
        myDrawing.getChildren().add(myLines);

    }

    public void changeImage (ImageView image) {
        myImage = image;
    }

    public double[] getCoordinates () {
        return myCoordinates;
    }

    public void setCoordinates (double x, double y) {
        myCoordinates[0] = x;
        myCoordinates[1] = y;
        myImage.setX(myCoordinates[0]);
        myImage.setY(myCoordinates[1]);
    }

    public void rotate (double deltaAngle) {
        myAngle = (myAngle + deltaAngle) % 360;
        myImage.setRotate(myAngle);
    }

    public void setAngle (double angle) {
        myAngle = angle % 360;
        myImage.setRotate(myAngle);
    }

    public double getAngle () {
        return myAngle;
    }

    public void moveTurtleAndDrawLine (double distance) {
        Line line = myPen.drawLine(myCoordinates, calculateEndCoord(distance));
        myLines.getChildren().add(line);
        setCoordinates(calculateEndCoord(distance)[0], calculateEndCoord(distance)[1]);
    }

    private double[] calculateEndCoord (double distance) {
        double[] endCoords = new double[2];
        endCoords[0] = myCoordinates[0] + distance
                       * Math.sin(Math.toRadians(myAngle));
        endCoords[1] = myCoordinates[1] + distance
                       * Math.cos(Math.toRadians(myAngle));
        return endCoords;
    }

    @Override
    public Node generateNode () {
        return myDrawing;
    }

    @Override
    public void clear () {
        myLines.getChildren().clear();
        setCoordinates(300, 300);
        setAngle(0);

    }
}

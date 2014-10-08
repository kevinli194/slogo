
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

        public Turtle() {

                // Should create a default image for this. Maybe a triangle;
        
                myImage = new ImageView();
                myPen = new Pen();
                myCoordinates = new double[2];
                myCoordinates[0] = 0;
                myCoordinates[1] = 0;
                myAngle = 0;
                myDrawing = new Group();
                myLines = new Group();
                myDrawing.getChildren().add(myImage);
                myDrawing.getChildren().add(myLines);

        }

        public void changeImage(ImageView image) {
                myImage = image;
        }

        public double[] getCoordinates() {
                return myCoordinates;
        }

        public void setCoordinates(double x, double y) {
                myCoordinates[0] = x;
                myCoordinates[1] = y;
        }

        public void rotate(double deltaAngle) {
                myAngle = (myAngle + deltaAngle) % 360;
        }

        public void setAngle(double angle) {
                myAngle = angle % 360;
        }

        public void moveTurtleAndDrawLine(int distance) {
                Line line = myPen.drawLine(myCoordinates, calculateEndCoord(distance));
                myCoordinates = calculateEndCoord(distance);
                myLines.getChildren().add(line);
        }

        private double[] calculateEndCoord(double distance) {
                double[] endCoords = new double[2];
                endCoords[0] = distance * Math.sin(Math.toRadians(myAngle));
                endCoords[1] = distance * Math.cos(Math.toRadians(myAngle));
                return endCoords;
        }

        @Override
        public Node generateNode() {
                myImage.setX(myCoordinates[0]);
                myImage.setY(myCoordinates[1]);
                myImage.setRotate(myAngle);
                return myDrawing;
        }

}
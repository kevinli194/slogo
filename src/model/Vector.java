package model;

/**
 * This class implements a vector which has a direction and magnitude.
 * 
 */
public class Vector {
    private double myAngle;
    private double mySpeed;

    /**
     * Constructor of a vector
     * 
     * @param angle of the vector
     * @param magnitude of the vector
     */
    public Vector (double angle, double speed) {
        myAngle = angle;
        mySpeed = speed;
    }

    /**
     * Sets the vector's angle
     */
    public void setAngle (double value) {
        myAngle = value;
    }

    /**
     * Changes the vector's angle
     */
    public void rotate (double rotateAmt) {
        setAngle(myAngle + rotateAmt);
    }

}

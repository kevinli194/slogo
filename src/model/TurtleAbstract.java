package model;

import java.io.Serializable;

import javafx.scene.Node;

public abstract class TurtleAbstract implements Serializable, Feature {
	/**
	 * Default turtle constants
	 */
	private static final long serialVersionUID = -1474829514092271376L;
	protected static final double DEFAULT_XCOORDINATE = 300;
	protected static final double DEFAULT_YCOORDINATE = 150;
	protected static final double DEFAULT_RELATIVE_COORDINATE=0;
	protected static final double DEFAULT_TURTLE_ANGLE = 0;
	protected static final double DEFAULT_TURTLE_SIZE = 30;
	protected static final double FULL_ROTATION_DEGREE = 360;
	protected static final String DEFAULT_ON_IMAGE = "default_on.gif";
	protected static final String DEFAULT_OFF_IMAGE = "default_off.png";

	public abstract Node generate();

	public abstract void toggleVisible();
}

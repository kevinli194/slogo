package model;

import java.io.Serializable;

/**
 * Feature interface that is extended by all the feature classes in model.
 * 
 * @author Kevin Li
 *
 */
public interface Feature extends Serializable {

	/**
	 * Shared method that clears the feature.
	 */
	public void clear();

}

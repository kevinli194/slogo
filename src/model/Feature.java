package model;

import javafx.scene.Parent;

/**
 * Feature interface that is extended by all the feature classes in model.
 * 
 * @author Kevin Li
 *
 */
public interface Feature {

	/**
	 * Shared method that clears the feature.
	 */
	public void clear();

	
	public void remove(Object n);

}

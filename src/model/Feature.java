package model;

import java.io.Serializable;
import error_checking.InvalidArgumentsException;

/**
 * Feature interface that is extended by all the feature classes in model.
 * @author Kevin Li
 *
 */
public interface Feature extends Serializable {

	/**
	 * Shared method that clears the feature.
	 */
	void clear();

	/**
	 * Shared method that remove a specific object from the model.
	 * @param o the object to be removed
	 * @throws InvalidArgumentsException
	 */
	void remove(Object o) throws InvalidArgumentsException;

}

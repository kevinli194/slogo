package view;

import java.io.Serializable;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class PaneView extends Pane implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = -1169940611139089490L;

	public void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

}

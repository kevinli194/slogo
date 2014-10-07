package model;

import java.util.Observable;

import javafx.scene.Node;

public abstract class Feature extends Observable {
	public abstract Node drawNode();

}

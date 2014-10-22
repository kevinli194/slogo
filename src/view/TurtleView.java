package view;

import model.Feature;
import javafx.scene.Node;
import javafx.stage.Screen;


public class TurtleView extends PaneView implements Feature {
    private static final double TURTLEVIEW_WIDTH = Screen.getPrimary()
            .getVisualBounds().getWidth()
                                                   * 3 / 5 * 3 / 4;
    private static final double TURTLEVIEW_HEIGHT = Screen.getPrimary()
            .getVisualBounds().getHeight()
                                                    * 11 / 16 * 4 / 5;

    public TurtleView () {
        setView(TURTLEVIEW_WIDTH, TURTLEVIEW_HEIGHT);
        setStyle("-fx-background-color:black;");

    }

    public void changeColor (String color) {
        setStyle("-fx-background-color:" + color + ";");
    }

    public void update (Node node) {
        this.getChildren().clear();
        this.getChildren().add(node);

    }

    @Override
    public void setView (double width, double height) {
        setPrefWidth(width);
        setPrefHeight(height);
        setMinSize(width, height);
    }

    @Override
    public void clear () {
        // TODO Auto-generated method stub

    }

}

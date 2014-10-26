package view;

import instructions.Instruction;
import java.io.Serializable;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.BackgroundColor;
import model.CommandsList;
import model.History;
import model.SlogoModel;


public class SettingsView extends ToolBar implements Serializable {
    /**
	 * 
	 */

	private static final long serialVersionUID = 660774956006597491L;
	ColorPicker myBGColor;
	ColorPicker myPenColor;
	Slider myPenSize;
	SlogoModel myModel;

	public SettingsView(SlogoModel model, TurtleView view, double width,
			double height) {
		myModel = model;
		setView(width, height);
		addButtons(model, view);
		addBGColorPicker(view);
		addPenColorPicker();
		addPenSlider();
	}

	private void setView(double width, double height) {
		setPrefSize(width, height * 1 / 16);
	}

	private void addBGColorPicker(TurtleView view) {
		myBGColor = new ColorPicker();
		myBGColor.setStyle("-fx-color-label-visible: false ;");
		myBGColor.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.changeColor(myBGColor.getValue());
				((BackgroundColor) (myModel.getMyData().get("backgroundcolor")))
						.set(myBGColor.getValue());
			}
		});
		myModel.initializeBGColor(getCustomColors(myBGColor));
		this.getItems().add(new Text("Background Color: "));
		this.getItems().add(myBGColor);
		this.getItems().add(new Separator());
	}

	private void addPenColorPicker() {
		myPenColor = new ColorPicker();
		myPenColor.setStyle("-fx-color-label-visible: false ;");
		myPenColor.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myModel.getMyData().getTurtle()
						.changePenColor(myPenColor.getValue());
			}
		});
		myModel.initializePenColor(getCustomColors(myPenColor));
		this.getItems().add(new Text("Pen Color: "));
		this.getItems().add(myPenColor);
		this.getItems().add(new Separator());

	}

	private void addPenSlider() {
		myPenSize = new Slider();
		myPenSize.setMin(0);
		myPenSize.setMax(10);
		myPenSize.setShowTickLabels(true);
		myPenSize.setShowTickMarks(true);
		myPenSize.setMajorTickUnit(2);
		myPenSize.setMinorTickCount(1);
		myPenSize.setBlockIncrement(2);
		myPenSize.setValue(3);
		myPenSize.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number arg2) {
				myModel.setPenSize(arg2.doubleValue());

			}

		});
		this.getItems().add(new Text("Stroke Width: "));
		this.getItems().add(myPenSize);
		this.getItems().add(new Separator());
	}

	private void addButtons(SlogoModel model, TurtleView view) {
		Button toggleTurtle = makeButton("Show/Hide Turtle",
				handle -> model.toggleTurtle());
		Button toggleGrid = makeButton("Show/Hide Grid",
				handle -> view.toggleGrid());
		Button clear = makeButton("Clear", handle -> model.clear());
		Button help = makeButton("Help Page", handle -> model.accessHelpHTML());
		this.getItems().addAll(toggleTurtle, toggleGrid, clear, help);
		this.getItems().add(new Separator());

	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}

	public ObservableList<Color> getCustomColors(ColorPicker colorpicker) {
		ObservableList<Color> customColors = colorpicker.getCustomColors();
		return customColors;
	}

	public void changeBGPicked(Color generate) {
		myBGColor.setValue(generate);

	}

	public void changePenPicked(Color generate) {
		myPenColor.setValue(generate);

	}

}

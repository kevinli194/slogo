package view;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.BackgroundColor;
import model.SlogoModel;

public class SettingsView extends ToolBar implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 660774956006597491L;
	public static final String DEFAULT_DISPLAY_RESOURCE = "resources.languages/Display";
	ColorPicker myBGColor;
	ColorPicker myPenColor;
	Slider myPenSize;
	ComboBox<Image> myTurtleChoices;
	SlogoModel myModel;
	protected static final String IMAGE_1 = "image_1.gif";
	protected static final String IMAGE_2 = "image_2.gif";

	Locale myLocale;
	ResourceBundle languageBundle;

	public SettingsView(SlogoModel model, TurtleView view, double width,
			double height, Locale locale) {
		myModel = model;
		myLocale = locale;
		languageBundle = ResourceBundle.getBundle(DEFAULT_DISPLAY_RESOURCE,
				myLocale);
		setView(width, height);
		addButtons(model, view);
		addBGColorPicker(view);
		addPenColorPicker();

		addPenSlider();
		addTurtleChoices();

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
		this.getItems().add(
				new Text(languageBundle.getString("BackgroundColor")));
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
		this.getItems().add(new Text(languageBundle.getString("PenColor")));
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
		this.getItems().add(new Text(languageBundle.getString("StrokeWidth")));
		this.getItems().add(myPenSize);
		this.getItems().add(new Separator());
	}

	private void addTurtleChoices() {
		myTurtleChoices = new ComboBox<Image>();
		Image myDefaultOn = new Image(getClass().getResourceAsStream(IMAGE_1));
		Image Image2 = new Image(getClass().getResourceAsStream(IMAGE_2));
		myTurtleChoices.getItems().addAll(myDefaultOn, Image2);
		this.getItems().add(myTurtleChoices);
		myTurtleChoices
				.setCellFactory(new Callback<ListView<Image>, ListCell<Image>>() {
					@Override
					public ListCell<Image> call(ListView<Image> p) {
						return new ListCell<Image>() {
							private final ImageView display;
							{
								setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
								display = new ImageView();
								display.setFitWidth(30);
								display.setFitHeight(30);
							}

							@Override
							protected void updateItem(Image item, boolean empty) {
								super.updateItem(item, empty);

								if (item == null || empty) {
									setGraphic(null);
								} else {
									display.setImage(item);
									setGraphic(display);
								}
							}
						};
					}
				});
		myTurtleChoices.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<Image>() {

					@Override
					public void changed(ObservableValue<? extends Image> ov,
							Image t, Image t1) {
						myModel.getMyData().getTurtle().setShape(t1);
					}
				});
		myTurtleChoices.setButtonCell(new ListCell<Image>());
		myModel.getMyData().getTurtle()
				.initListofTurtles(myTurtleChoices.getItems());
	}

	private void addButtons(SlogoModel model, TurtleView view) {
		Button toggleTurtle = makeButton(
				languageBundle.getString("ShowHideTurtle"),
				handle -> model.toggleTurtle());
		Button toggleGrid = makeButton(
				languageBundle.getString("ShowHideGrid"),
				handle -> view.toggleGrid());
		Button clear = makeButton(languageBundle.getString("Clear"),
				handle -> model.clear());
		Button help = makeButton(languageBundle.getString("HelpPage"),
				handle -> model.accessHelpHTML());
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

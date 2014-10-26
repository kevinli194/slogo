package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.imageio.ImageIO;

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
	ComboBox<String> myLineProperties;
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
		addBGColorPicker(view);
		addPenColorPicker();
		addPenSlider();
		addLineProperty();
		addTurtleChoices();
		addTurtleUpload();
		addButtons(model, view);

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

	private void addLineProperty() {
		myLineProperties = new ComboBox<String>();
		myLineProperties.getItems().addAll(languageBundle.getString("Solid"),
				languageBundle.getString("Dashed"),
				languageBundle.getString("Dotted"),
				languageBundle.getString("None"));

		myLineProperties.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> arg0,
							String arg1, String arg2) {
						if (arg2 == languageBundle.getString("Dashed")) {
							myModel.getMyData().getTurtle().getPen()
									.setPenDown(true);
							myModel.getMyData().getTurtle().getPen()
									.changeLineProperty(10, 10);
						}
						if (arg2 == languageBundle.getString("Dotted")) {
							myModel.getMyData().getTurtle().getPen()
									.setPenDown(true);
							myModel.getMyData().getTurtle().getPen()
									.changeLineProperty(3, 3);
						}
						if (arg2 == languageBundle.getString("Solid")) {
							myModel.getMyData().getTurtle().getPen()
									.setPenDown(true);
							myModel.getMyData().getTurtle().getPen()
									.changeLineProperty(1, 1);
						}
						if (arg2 == languageBundle.getString("None")) {
							myModel.getMyData().getTurtle().getPen()
									.setPenDown(false);
						}

					}

				});
		this.getItems().add(myLineProperties);
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
		this.getItems().add(
				new Text(languageBundle.getString("LineProperties")));
		this.getItems().add(myPenSize);
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

	private void addTurtleUpload() {
		FileChooser fc = new FileChooser();
		Button upload = new Button(languageBundle.getString("Upload"));
		upload.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				File file = fc.showOpenDialog(new Stage());
				if (file != null) {
					BufferedImage bufferedImage;
					try {
						bufferedImage = ImageIO.read(file);
						Image image = SwingFXUtils.toFXImage(bufferedImage,
								null);
						myTurtleChoices.getItems().add(image);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		this.getItems().add(upload);
		this.getItems().add(new Separator());

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

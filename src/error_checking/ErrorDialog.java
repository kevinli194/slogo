package error_checking;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;


/**
 * Class to create a pop up dialog to show when there is an an error.
 *
 * @author Jennie Ju
 */
public class ErrorDialog {
    // Should be read in from resources file
    private static final String OK_STRING = "OK";

    /**
     * @param format for the pop up dialog
     * @param args for the pop up dialog
     */
    public ErrorDialog (String format, Object ... args) {
        String message = String.format(format, args);
        display(message);
    }

    private void display (String message) {
        // Initialize Stage
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);

        // Initialize Scene
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/stylesheets/error_dialog.css");

        // Initialize Popup
        Popup popup = new Popup();
        popup.setAutoFix(true);
        popup.setHideOnEscape(false);

        // Make string label
        Label label = new Label(message);

        // Make button
        Button okBtn = new Button(OK_STRING);
        okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                dialog.hide();
                popup.hide();
            }
        });

        root.getChildren().addAll(label, okBtn);
        dialog.setScene(scene);
        dialog.show();
        popup.show(dialog);
    }

}

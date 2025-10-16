import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Bathroom implements AppScene {

    @Override
    public Scene getScene(Stage primaryStage) {
        Label title = new Label(" The 'Scary' Bathroom ");
        title.setFont(new Font("Chiller", 32));
        title.setTextFill(Color.DARKRED);

        Label description = new Label("As you enter the bathroom, the smell of damp and mold fills your lungs...\n" +
                        "Water drips from the shower, forming crimson puddles.\n" +
                        "In the mirror, a ghoulish face flickers in and out of view.\n" +
                        "The closet door rattles, and a low groan echoes behind you..."
        );
        description.setWrapText(true);
        description.setFont(new Font("Chiller", 16));
        description.setTextFill(Color.LIGHTGRAY);

        Label hiddenText = new Label("A whisper echoes: 'You shouldn’t have come here…'");
        hiddenText.setFont(new Font("Chiller", 14));
        hiddenText.setTextFill(Color.DARKGRAY);
        hiddenText.setVisible(false);

        Button revealButton = new Button("Reveal Hidden");
        revealButton.setOnAction(e -> {
            hiddenText.setVisible(!hiddenText.isVisible());
            if (hiddenText.isVisible()) {
                revealButton.setText("Hide Whisper");
            } else {
                revealButton.setText("Reveal Hidden");
            }
        });

        Label mirrorText = new Label("");
        mirrorText.setFont(new Font("Chiller", 18));
        mirrorText.setTextFill(Color.SILVER);

        TextField input = new TextField();
        input.setPromptText("Write on the mirror...");

        Button writeButton = new Button("Leave Message");
        writeButton.setOnAction(e -> {
            String message = input.getText().trim();
            if (!message.isEmpty()) {
                mirrorText.setText("The mirror now reads: \"" + message + "\"");
                mirrorText.setTextFill(Color.DARKCYAN);
            }
        });

        Button backButton = new Button("⬅️ Back to Main Hall");
        backButton.setOnAction(e -> {
            primaryStage.setScene(new MainHall().getScene(primaryStage));
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);

        grid.add(title, 0, 0);
        grid.add(description, 0, 1);
        grid.add(revealButton, 0, 2);
        grid.add(hiddenText, 0, 3);
        grid.add(input, 0, 4);
        grid.add(writeButton, 0, 5);
        grid.add(mirrorText, 0, 6);
        grid.add(backButton, 0, 7);

        grid.setStyle(
                "-fx-background-color: black; " +
                        "-fx-padding: 40; " +
                        "-fx-border-color: darkred; " +
                        "-fx-border-width: 5;"
        );

        Scene scene = new Scene(grid, 700, 500);
        scene.setFill(Color.BLACK);
        return scene;
    }

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        return null;
    }
}

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

public class Bathroom extends HauntedScene {

    private static final String TITLE_TEXT = "The 'Scary' Bathroom";
    private static final String DESCRIPTION_TEXT = """
            As you enter the bathroom, the smell of damp and mold fills your lungs...
            Water drips from the shower, forming crimson puddles.
            In the mirror, a ghoulish face flickers in and out of view.
            The closet door rattles, and a low groan echoes behind you...
            """;
    private static final String HIDDEN_TEXT = "A whisper echoes: 'You shouldn’t have come here…'";

    public Bathroom(SceneSetter sceneSetter) {
        super(sceneSetter);
    }

    private Label makeLabel(String text, int size, Color color) {
        Label label = new Label(text);
        label.setFont(new Font("Chiller", size));
        if (color != null) {
            label.setTextFill(color);
        }
        return label;
    }

    private void toggleHidden(Label hiddenText, Button revealButton) {
        boolean visible = !hiddenText.isVisible();
        hiddenText.setVisible(visible);
        revealButton.setText(visible ? "Hide Whisper" : "Reveal Hidden");
    }

    private void writeMirrorMessage(TextField input, Label mirrorLabel) {
        String message = input.getText().trim();
        if (!message.isEmpty()) {
            mirrorLabel.setText("The mirror now reads: \"" + message + "\"");
            mirrorLabel.setTextFill(Color.DARKCYAN);
        }
    }

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label title = makeLabel(TITLE_TEXT, 32, Color.DARKRED);
        Label description = makeLabel(DESCRIPTION_TEXT, 16, Color.LIGHTGRAY);
        description.setWrapText(true);

        Label hidden = makeLabel(HIDDEN_TEXT, 14, Color.RED);
        hidden.setVisible(false);

        Button revealButton = new Button("Reveal Hidden");
        revealButton.setOnAction(e -> toggleHidden(hidden, revealButton));

        TextField input = new TextField();
        input.setPromptText("Write on the mirror...");

        Label mirrorText = makeLabel("", 18, Color.SILVER);

        Button writeButton = new Button("Leave Message");
        writeButton.setOnAction(e -> writeMirrorMessage(input, mirrorText));

        Button backButton = new Button("Back to Main Hall");
        backButton.setOnAction(e -> sceneSetter.goHome());

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(15);
        layout.setVgap(15);
        layout.add(title, 0, 0);
        layout.add(description, 0, 1);
        layout.add(revealButton, 0, 2);
        layout.add(hidden, 0, 3);
        layout.add(input, 0, 4);
        layout.add(writeButton, 0, 5);
        layout.add(mirrorText, 0, 6);
        layout.add(backButton, 0, 7);

        layout.setStyle("""
            -fx-background-color: black;
            -fx-padding: 40;
            -fx-border-color: darkred;
            -fx-border-width: 5;
            """);

        Scene scene = new Scene(layout, 700, 500);
        scene.setFill(Color.BLACK);
        return scene;
    }
}

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DogHouse implements AppScene {

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label title = new Label("The Dog House");
        Label description = new Label("Dust floats in the air as an old chest sits in the corner...");
        String secretText = "A hidden note appears: 'Beware the ghost!'";
        String riddle = "I'm seen through glass, have no weight or clothes, and I only show up after your life is over—what am I?";
        String answer = "ghost";

        Label secret = new Label(secretText);
        secret.setVisible(false);

        TextField input = new TextField();
        input.setPromptText("Type a secret word...");

        Button openChest = new Button("Open the Chest");
        openChest.setOnAction(e -> {
            secret.setText(riddle);
            secret.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            secret.setVisible(true);
        });

        Button back = new Button("Back to Main Hall");
        back.setOnAction(e -> {
            secret.setVisible(false);
            input.clear();
            goBack.handle(e);
        });

        Button revealButton = new Button("Reveal Secret");
        revealButton.setOnAction(e -> {
            if (answer.equalsIgnoreCase(input.getText().trim())) {
                secret.setText(secretText);
                secret.setVisible(true);
                secret.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            } else {
                secret.setText("Nothing happens...");
                secret.setVisible(true);
            }
        });

        VBox layout = new VBox(10, title, description, openChest, input, revealButton, secret, back);
        layout.setBackground(null);
        layout.setAlignment(Pos.CENTER);

        Scene s = new Scene(layout, 600, 400);
        s.setFill(Color.GRAY);
        return s;
    }


}

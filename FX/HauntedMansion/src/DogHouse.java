import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import java.util.Optional;

public class DogHouse extends HauntedScene {
    private static final String SECRET_TEXT = "A hidden note appears: 'Beware the ghost!'";
    private static final String RIDDLE = "I'm seen through glass, have no weight or clothes, \nand I only show up after your life is over—what am I?";
    private static final String ANSWER = "ghost";
    private static final String RED = "#991E06";

    public DogHouse(SceneSetter sceneSetter) {
        super(sceneSetter);
    }

    private static Label makeLabel(String text, Optional<String> textFill, Optional<Integer> fontSize, Optional<Boolean> isVisible) {
        Label l = new Label(text);
        l.setVisible(isVisible.orElse(false));
        l.setStyle(String.format("-fx-font-weight: bold; -fx-text-fill: %s; -fx-font-size: %d;", textFill.orElse("black"), fontSize.orElse(20)));
        return l;
    }

    private static Button makeButton(String text, EventHandler<ActionEvent> e) {
        Button b = new Button(text);
        b.setOnAction(e);
        return b;
    }

    private static TextField makeInput(String text) {
        TextField input = new TextField();
        input.setPromptText(text);
        return input;
    }

    private static Circle makeEye(int xTranslate, int yTranslate) {
        Circle c = new Circle(0, 0, 5);
        c.setTranslateX(xTranslate);
        c.setTranslateY(yTranslate);
        c.setFill(Color.GREEN);
        return c;
    }

    private static StackPane makeGhost(boolean isVisible) {
        Ellipse ghost = new Ellipse(20.0, 40.0);
        ghost.setFill(Color.WHITE);
        ghost.setStroke(Color.BLACK);
        ghost.setStrokeWidth(3);
        ghost.setVisible(true);

        Circle leftEye = makeEye(-5, -25);
        Circle rightEye = makeEye(5, -25);
        Circle mouth = new Circle(0, 0, 7);
        mouth.setTranslateY(-5);
        mouth.setFill(Color.BLACK);

        StackPane s = new StackPane(ghost, leftEye, rightEye, mouth);
        s.setVisible(isVisible);
        return s;
    }

    private static EventHandler<ActionEvent> openChest(Label label) {
        return e -> {
            label.setText(RIDDLE);
            label.setStyle(String.format("%s-fx-text-fill: %s;", label.getStyle(), RED));
            label.setVisible(true);
        };
    }

    private EventHandler<ActionEvent> back (Label secret, Node ghostLayout, TextField input) {
        secret.setVisible(false);
        ghostLayout.setVisible(false);
        input.clear();
        return e -> sceneSetter.goHome();
    }

    private static EventHandler<ActionEvent> revealAction(Label secret, TextField input, Node ghostLayout) {
        return e -> {
            if (ANSWER.equalsIgnoreCase(input.getText().trim())) {
                secret.setText(SECRET_TEXT);
                secret.setVisible(true);
                secret.setStyle(String.format("%s-fx-text-fill: %s;", secret.getStyle(), RED));
                ghostLayout.setVisible(true);
            } else {
                secret.setText("Nothing happens...");
                secret.setVisible(true);
                secret.setStyle(String.format("%s-fx-text-fill: %s;", secret.getStyle(), "black"));
            }
        };
    }

    @Override
    public Scene getScene() {
        Label title = makeLabel("The Dog House", Optional.of(RED), Optional.empty(), Optional.of(true));
        Label description = makeLabel("Dust floats in the air as an old chest sits in the corner...", Optional.empty(), Optional.empty(), Optional.empty() );
        Label secret = makeLabel(SECRET_TEXT, Optional.empty(), Optional.empty(), Optional.empty());

        TextField input = makeInput("Type a secret word...");
        Button openChest = makeButton("Open the chest", openChest(secret));

        StackPane ghostLayout = makeGhost(false);
        Button back = makeButton("Back to Main Hall", back(secret, ghostLayout, input));
        Button revealButton = makeButton("Reveal Secret", revealAction(secret, input, ghostLayout));

        VBox layout = new VBox(10, title, description, openChest, input, revealButton, secret, ghostLayout, back);
        layout.setBackground(null);
        layout.setAlignment(Pos.CENTER);

        Scene s = new Scene(layout, 600, 400);
        s.setFill(Color.GRAY);
        return s;
    }


}

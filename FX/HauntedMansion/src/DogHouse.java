import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;

public class DogHouse implements AppScene {

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label title = new Label("The Dog House");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 20;-fx-text-fill: red;");

        Label description = new Label("Dust floats in the air as an old chest sits in the corner...");
        description.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");

        String secretText = "A hidden note appears: 'Beware the ghost!'";
        String riddle = "I'm seen through glass, have no weight or clothes, \nand I only show up after your life is over—what am I?";
        String answer = "ghost";
        String red = "#991E06";

        Label secret = new Label(secretText);
        secret.setVisible(false);
        secret.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");

        TextField input = new TextField();
        input.setPromptText("Type a secret word...");
        Button openChest = new Button("Open the Chest");
        // lambda function
        openChest.setOnAction(e -> {
            secret.setText(riddle);
            secret.setStyle(String.format("%s-fx-text-fill: %s;", secret.getStyle(), red));
            secret.setVisible(true);
        });

        Ellipse ghost = new Ellipse(20.0, 40.0);
        ghost.setFill(Color.WHITE);
        ghost.setStroke(Color.BLACK);
        ghost.setStrokeWidth(3);
        ghost.setVisible(true);

        Circle leftEye = new Circle(0, 0, 5);
        leftEye.setTranslateX(-5);
        leftEye.setTranslateY(-25);
        leftEye.setFill(Color.GREEN);

        Circle rightEye = new Circle(0, 0, 5);
        rightEye.setTranslateX(5);
        rightEye.setTranslateY(-25);
        rightEye.setFill(Color.GREEN);

        Circle mouth = new Circle(0, 0, 7);
        mouth.setTranslateY(-5);
        mouth.setFill(Color.BLACK);

        StackPane ghostLayout = new StackPane(ghost, leftEye, rightEye, mouth);
//        ghostLayout.getChildren().add(ghost);
        ghostLayout.setVisible(false);

        Button back = new Button("Back to Main Hall");
        back.setOnAction(e -> {
            secret.setVisible(false);
            ghostLayout.setVisible(false);
            input.clear();
            goBack.handle(e);
        });

        Button revealButton = new Button("Reveal Secret");
        revealButton.setOnAction(e -> {
            if (answer.equalsIgnoreCase(input.getText().trim())) {
                secret.setText(secretText);
                secret.setVisible(true);
                secret.setStyle(String.format("%s-fx-text-fill: %s;", secret.getStyle(), red));
                ghostLayout.setVisible(true);
            } else {
                secret.setText("Nothing happens...");
                secret.setVisible(true);
                secret.setStyle(String.format("%s-fx-text-fill: %s;", secret.getStyle(), "black"));
            }
        });

        VBox layout = new VBox(10, title, description, openChest, input, revealButton, secret, ghostLayout, back);
        layout.setBackground(null);
        layout.setAlignment(Pos.CENTER);

        Scene s = new Scene(layout, 600, 400);
        s.setFill(Color.GRAY);
        return s;
    }


}

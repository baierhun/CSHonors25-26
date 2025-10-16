import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class ChambersOfDeath implements AppScene{

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label title = new Label("Chambers of Death");
        title.setStyle("-fx-font-size: 40px; -fx-text-fill: maroon; -fx-font-weight: bold;");

        Label description = new Label("It's pitch black with an interesting musk in the air, the windows are boarded up and the mattress is torn apart...");
        description.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");


        String secretText = "Millions of lice crawl on the bed and all over you.";
        String behind = "You hear a whooshing sound behind you, but when you turn nothing is there.";
        String answer = "lice";
        String red = "#991E06";

        Label secret = new Label(secretText);
        secret.setVisible(false);
        secret.setStyle("-fx-font-weight: bold; -fx-font-size: 15;");

        TextField input = new TextField();
        input.setPromptText("What's in the bed...(click check out bed for answer)");
        Button windows = new Button("Unboard the windows");
        // lambda function
        windows.setOnAction(e -> {
            secret.setText(behind);
            secret.setStyle(String.format("%s-fx-text-fill: %s;", secret.getStyle(), red));
            secret.setVisible(true);
        });

        Ellipse lice = new Ellipse(40.0, 20.0);
        lice.setFill(Color.BLACK);
        lice.setStroke(Color.BLACK);
        lice.setStrokeWidth(3);
        lice.setVisible(true);

        Circle leftEye = new Circle(0, 0, 5);
        leftEye.setTranslateX(20);
        leftEye.setTranslateY(-5);
        leftEye.setFill(Color.RED);

        Circle rightEye = new Circle(0, 0, 5);
        rightEye.setTranslateX(20);
        rightEye.setTranslateY(10);
        rightEye.setFill(Color.RED);

        Circle mouth = new Circle(0, 0, 7);
        mouth.setTranslateY(-5);
        mouth.setFill(Color.BLACK);

        StackPane ghostLayout = new StackPane(lice, leftEye, rightEye, mouth);
//        ghostLayout.getChildren().add(ghost);
        ghostLayout.setVisible(false);

        Button back = new Button("Back to Main Hall");
        back.setOnAction(e -> {
            secret.setVisible(false);
            ghostLayout.setVisible(false);
            input.clear();
            goBack.handle(e);
        });

        Button revealButton = new Button("Check out the bed");
        revealButton.setOnAction(e -> {
            if (answer.equalsIgnoreCase(input.getText().trim())) {
                secret.setText(secretText);
                secret.setVisible(true);
                secret.setStyle(String.format("%s-fx-text-fill: %s;", secret.getStyle(), red));
                ghostLayout.setVisible(true);
            } else {
                secret.setText("I travel by crawling, not flying or hopping. \n I lay eggs on a person's head, but I can also live in their clothes. \n What am I?");
                secret.setVisible(true);
                secret.setStyle(String.format("%s-fx-text-fill: %s;", secret.getStyle(), "black"));
            }
        });

        VBox layout = new VBox(10, title, description, windows, input, revealButton, secret, ghostLayout, back);
        layout.setBackground(null);
        layout.setAlignment(Pos.CENTER);

        Scene s = new Scene(layout, 600, 400);
        s.setFill(Color.GRAY);
        return s;

    }
}


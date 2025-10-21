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

public class ChambersOfDeath implements AppScene {

    private static final String red = "#991E06";
    private static final String answer = "lice";
    private static final String scaryText = "Millions of lice crawl on the bed and all over you.";
    private static final String behindText = "You hear a whooshing sound behind you, but when you turn nothing is there.";

    private Label createTitle() {
        Label title = new Label("Chambers of Death");
        title.setStyle("-fx-font-size: 40px; -fx-text-fill: maroon; -fx-font-weight: bold;");
        return title;
    }

    private Label createDescription() {
        Label description = new Label(
                "It's pitch black with an interesting musk in the air, the windows are boarded up and the mattress is torn apart...");
        description.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
        return description;
    }

    private Label createSecretLabel() {
        Label secret = new Label(scaryText);
        secret.setVisible(false);
        secret.setStyle("-fx-font-weight: bold; -fx-font-size: 15;");
        return secret;
    }

    private TextField createInputField() {
        TextField input = new TextField();
        input.setPromptText("What's in the bed...(click check out bed for answer)");
        return input;
    }

    private Button createWindowsButton(Label secret) {
        Button windows = new Button("Unboard the windows");
        windows.setOnAction(e -> {
            secret.setText(behindText);
            applyTextColor(secret, red);
            secret.setVisible(true);
        });
        return windows;
    }

    private Button createRevealButton(TextField input, Label secret, StackPane liceLayout) {
        Button revealButton = new Button("Check out the bed");
        revealButton.setOnAction(e -> {
            if (answer.equalsIgnoreCase(input.getText().trim())) {
                secret.setText(scaryText);
                applyTextColor(secret, red);
                secret.setVisible(true);
                liceLayout.setVisible(true);
            } else {
                secret.setText(
                        "I travel by crawling, not flying or hopping. \nI lay eggs on a person's head, but I can also live in their clothes. \nWhat am I?");
                applyTextColor(secret, "black");
                secret.setVisible(true);
                liceLayout.setVisible(false);
            }
        });
        return revealButton;
    }

    private Button createBackButton(EventHandler<ActionEvent> goBack, Label secret, StackPane liceLayout, TextField input) {
        Button back = new Button("Back to Main Hall");
        back.setOnAction(e -> {
            secret.setVisible(false);
            liceLayout.setVisible(false);
            input.clear();
            goBack.handle(e);
        });
        return back;
    }

    private StackPane createLiceFigure() {
        Ellipse body = new Ellipse(40.0, 20.0);
        body.setFill(Color.BLACK);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(3);

        Circle topEye = createEye(20, -5);
        Circle bottomEye = createEye(20, 10);
        Circle mouth = createMouth();

        StackPane liceLayout = new StackPane(body, topEye, bottomEye, mouth);
        liceLayout.setVisible(false);
        return liceLayout;
    }

    private Circle createEye(double x, double y) {
        Circle eye = new Circle(0, 0, 5);
        eye.setTranslateX(x);
        eye.setTranslateY(y);
        eye.setFill(Color.RED);
        return eye;
    }

    private Circle createMouth() {
        Circle mouth = new Circle(0, 0, 7);
        mouth.setTranslateY(-5);
        mouth.setFill(Color.RED);
        return mouth;
    }

    private VBox createLayout(Label title, Label description, Button windows, TextField input,
                              Button revealButton, Label secret, StackPane liceLayout, Button back) {
        VBox layout = new VBox(15, title, description, windows, input, revealButton, secret, liceLayout, back);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(null);
        return layout;
    }

    private void applyTextColor(Label label, String color) {
        label.setStyle(String.format("%s-fx-text-fill: %s;", label.getStyle(), color));
    }

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label title = createTitle();
        Label description = createDescription();
        Label secret = createSecretLabel();
        TextField input = createInputField();
        StackPane liceLayout = createLiceFigure();
        Button windows = createWindowsButton(secret);
        Button revealButton = createRevealButton(input, secret, liceLayout);
        Button back = createBackButton(goBack, secret, liceLayout, input);

        VBox layout = createLayout(title, description, windows, input, revealButton, secret, liceLayout, back);

        Scene scene = new Scene(layout, 600, 400);
        scene.setFill(Color.GRAY);
        return scene;
    }
}
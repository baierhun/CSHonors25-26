import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ChambersOfDeath extends HauntedScene {

    public ChambersOfDeath(SceneSetter sceneSetter) {
        super(sceneSetter);
    }

    private Label createTitle() {
        Label title = new Label("Chambers of Death");
        title.setFont(Font.font("Papyrus", 50));
        title.setTextFill(Color.BLACK);
        return title;
    }

    private Label createDescriptionLabel(String text) {
        Label label = new Label(text);
        label.setVisible(false);
        label.setTextFill(Color.BLACK);
        return label;
    }

    private Label createClosetLabel() {
        String riddleText = """
                You look in the closet and there's a riddle carved into the wall...
                I float through walls without a sound,
                And never leave a single track on the ground.
                I can pass right through a locked-up door,
                And leave you shaking to your very core.
                What am I?
                """;
        return createDescriptionLabel(riddleText);
    }

    private TextField createRiddleInput() {
        TextField riddle = new TextField();
        riddle.setPromptText("What am I?...");
        return riddle;
    }

    private Label createAnswerLabel() {
        Label answer = new Label();
        answer.setVisible(false);
        answer.setTextFill(Color.BLACK);
        return answer;
    }

    private Button createToggleButton(String text, Label targetLabel) {
        Button button = new Button(text);
        button.setOnAction(e -> targetLabel.setVisible(!targetLabel.isVisible()));
        return button;
    }

    private Button createClosetButton(String text) {
        Button closetButton = new Button(text);
        Scene closetScene = new ChambersOfDeath(sceneSetter).closetScene();
        closetButton.setOnAction(e -> sceneSetter.goTo(closetScene));
        return closetButton;
    }

    private Scene closetScene() {
        Label closetLabel = createClosetLabel();
        closetLabel.setVisible(true);
        TextField riddleInput = createRiddleInput();
        Label answerLabel = createAnswerLabel();

        Button answerButton = createAnswerButton(riddleInput, answerLabel);
        Button leaveButton = new Button("Go Back to the Chambers of Death");
        leaveButton.setOnAction(e -> {
            answerLabel.setVisible(false);
            sceneSetter.goTo(getScene());
        });

        VBox layout = new VBox(30, closetLabel, riddleInput, answerButton, answerLabel, leaveButton);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(null);

        Scene scene = new Scene(layout, 600, 400);
        scene.setFill(Color.MAROON);
        return scene;
    }

    private Button createAnswerButton(TextField riddleInput, Label answerLabel) {
        Button button = new Button("Check your answer");
        button.setOnAction(e -> {
            String guess = riddleInput.getText().trim();
            if (guess.equalsIgnoreCase("ghost")) {
                answerLabel.setText("You got the answer to the Riddle! You survive... For now");
            } else {
                answerLabel.setText("You got the answer wrong, so now the ghost is closer to getting you");
            }
            answerLabel.setVisible(true);
        });
        return button;
    }

    private Button createLeaveButton(Label windows, Label bed) {
        Button button = new Button("Go Back to Main Hall");
        button.setOnAction(e -> {
            windows.setVisible(false);
            bed.setVisible(false);
            sceneSetter.goHome();
        });
        return button;
    }

    private HBox createButtonRow(Button... buttons) {
        HBox row = new HBox(15);
        row.getChildren().addAll(buttons);
        row.setAlignment(Pos.CENTER);
        return row;
    }

    private VBox createLayout(Label title, HBox buttons,
                              Label windows, Label bed, Button leaveButton) {
        VBox layout = new VBox(50, title, buttons, windows, bed, leaveButton);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(null);
        return layout;
    }

    @Override
    public Scene getScene() {
        Label title = createTitle();
        Label windowsLabel = createDescriptionLabel("You go to unboard the windows and you hear a whooshing behind you and it's a ghost!");
        Label bedLabel = createDescriptionLabel("You go to look in the bed and you see millions of lice crawling through the bed and they even get on you.");

        Button windowsButton = createToggleButton("Unboard the Windows", windowsLabel);
        Button bedButton = createToggleButton("Look in the Bed", bedLabel);
        Button closetButton = createClosetButton("Check out the Closet");
        Button leaveButton = createLeaveButton(windowsLabel, bedLabel);

        HBox actionButtons = createButtonRow(windowsButton, bedButton, closetButton);

        VBox layout = createLayout(title, actionButtons, windowsLabel, bedLabel, leaveButton);

        Scene scene = new Scene(layout, 600, 400);
        scene.setFill(Color.MAROON);
        return scene;
    }
}

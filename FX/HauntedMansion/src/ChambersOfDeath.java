import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ChambersOfDeath implements AppScene {

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

    private Button createLeaveButton(EventHandler<ActionEvent> goBack, Label windows, Label bed, Label closet, TextField riddle, Label answer) {
        Button button = new Button("Go Back to Main Hall");
        button.setOnAction(e -> {
            windows.setVisible(false);
            bed.setVisible(false);
            closet.setVisible(false);
            answer.setVisible(false);
            riddle.clear();
            goBack.handle(e);
        });
        return button;
    }

    private HBox createButtonRow(Button... buttons) {
        HBox row = new HBox(15);
        row.getChildren().addAll(buttons);
        row.setAlignment(Pos.CENTER);
        return row;
    }

    private HBox createBottomRow(Button leaveButton, Label answer) {
        HBox bottom = new HBox(50, leaveButton, answer);
        bottom.setAlignment(Pos.CENTER);
        return bottom;
    }

    private VBox createLayout(Label title, HBox buttons, TextField riddle, Button answerButton,
                              Label windows, Label bed, Label closet, HBox bottom) {
        VBox layout = new VBox(10, title, buttons, riddle, answerButton, windows, bed, closet, bottom);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(null);
        return layout;
    }

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label title = createTitle();
        Label windowsLabel = createDescriptionLabel("You go to unboard the windows and you hear a whooshing behind you and it's a ghost!");
        Label bedLabel = createDescriptionLabel("You go to look in the bed and you see millions of lice crawling through the bed and they even get on you.");
        Label closetLabel = createClosetLabel();
        TextField riddleInput = createRiddleInput();
        Label answerLabel = createAnswerLabel();

        Button windowsButton = createToggleButton("Unboard the Windows", windowsLabel);
        Button bedButton = createToggleButton("Look in the Bed", bedLabel);
        Button closetButton = createToggleButton("Check out the Closet", closetLabel);
        Button answerButton = createAnswerButton(riddleInput, answerLabel);
        Button leaveButton = createLeaveButton(goBack, windowsLabel, bedLabel, closetLabel, riddleInput, answerLabel);

        HBox actionButtons = createButtonRow(windowsButton, bedButton, closetButton);
        HBox bottomRow = createBottomRow(leaveButton, answerLabel);

        VBox layout = createLayout(title, actionButtons, riddleInput, answerButton, windowsLabel, bedLabel, closetLabel, bottomRow);

        Scene scene = new Scene(layout, 600, 400);
        scene.setFill(Color.MAROON);
        return scene;
    }
}

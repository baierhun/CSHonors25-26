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
    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {

        Label title = new Label("Chambers of Death");
        title.setFont(Font.font("Papyrus", 50));
        title.setTextFill(Color.BLACK);

        Label windows = new Label("You go to unboard the windows and you hear a whooshing behind you and it's a ghost!");
        windows.setVisible(false);
        windows.setTextFill(Color.BLACK);

        Label bed = new Label("You go to look in the bed and you see millions of lice crawling through the bed and they even get on you.");
        bed.setVisible(false);
        bed.setTextFill(Color.BLACK);

        Label closet = new Label("You look in the closet and there's a riddle carved into the wall...\n " +
                "I float through walls without a sound,\n" +
                "And never leave a single track on the ground.\n" +
                "I can pass right through a locked-up door,\n" +
                "And leave you shaking to your very core.\n" +
                "What am I?");
        closet.setVisible(false);
        closet.setTextFill(Color.BLACK);
        TextField riddle = new TextField();
        riddle.setPromptText("What am I?...");
        Label answer = new Label();
        answer.setVisible(false);

        Button windowsButton = new Button("Unboard the Windows");
        windowsButton.setOnAction(e -> { if (windows.isVisible()) {
            windows.setVisible(false);
        } else {
            windows.setVisible(true);
        }});

        Button bedButton = new Button("Look in the Bed");
        bedButton.setOnAction(e -> { if (bed.isVisible()) {
            bed.setVisible(false);
        } else {
            bed.setVisible(true);
        }});

        Button closetButton = new Button("Check out the Closet");
        closetButton.setOnAction(e -> { if (closet.isVisible()) {
            closet.setVisible(false);
        } else {
            closet.setVisible(true);
        }});

        Button answerButton = new Button("Check your answer"); answerButton.setOnAction(e -> {
            if (riddle.getText().equalsIgnoreCase("ghost")) {
                answer.setText("You got the answer to the Riddle! You survive... For now");
                answer.setTextFill(Color.BLACK);
                answer.setVisible(true);
                } else {
                answer.setText("You got the answer wrong, so now the ghost is closer to getting you");
                answer.setTextFill(Color.BLACK);
                answer.setVisible(true);
            } });

        Button leaveButton = new Button("Go Back to Main Hall");
        leaveButton.setOnAction(e -> leaveButton.setVisible(true));
        leaveButton.setOnAction(e -> { windows.setVisible(false); bed.setVisible(false); closet.setVisible(false); answer.setVisible(false); riddle.clear(); goBack.handle(e); });

        HBox buttons = new HBox(15, windowsButton, bedButton, closetButton);
        buttons.setAlignment(Pos.CENTER);

        HBox bottom = new HBox(50, leaveButton, answer);

        VBox v = new VBox(10, title, buttons, riddle, answerButton, windows, bed, closet, bottom);
        v.setBackground(null);
        v.setAlignment(Pos.CENTER);

        Scene scene = new Scene(v,600,400);
        scene.setFill(Color.MAROON);
        return scene;
    }
}
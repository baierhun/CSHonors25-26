import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import org.w3c.dom.Text;

import java.util.Optional;


public class Attic implements AppScene {

    private static final String rb1 = "I drift without a sail, I moan without a throat, +\n you see right through my body. What am I?";
    private static final String rb2 = "By day I sleep beneath the floor, at night I glide and roam.  Where do I call home?";
    private static final String p = "YOU MUST ANSWER THE NEXT RIDDLES TO ENTER THE ROOM";


    private static Label makeLabel(String text, Optional<String> color, Optional<Integer>fontSize, boolean isVisible){
        Label l = new Label(text);
        l.setVisible(isVisible);
        l.setStyle(String.format("-fx-font-family: Papyrus; -fx-font-weight: bold; -fx-text-fill: %s; -fx-font-size: %d;", color.orElse("red"), fontSize.orElse(15)));
        return l;
    }

    private static Button makeButton(String text, EventHandler<ActionEvent> e){
        Button b = new Button();
        b.setOnAction(e);
        return b;

    }
    private static TextField makeTextField(String textFill, boolean isVisible){
        TextField field = new TextField(textFill);
        field.setVisible(isVisible);
        return field;
    }

    private static EventHandler<ActionEvent> checkAnswer(TextField a, TextField b, Label message, TextField answerBox2, Label riddle2) {
        return event -> {
            String input1 = a.getText();
            if (input1.equalsIgnoreCase("A ghost") || input1.equalsIgnoreCase("Ghost")) {
                message.setText("CORRECT! A GHOST");
                message.setVisible(true);
                answerBox2.setVisible(true);
                riddle2.setVisible(true);
            } else {
                message.setText("INCORRECT");
                message.setVisible(true);
            }
            String input2 = b.getText();
            if (input2.equalsIgnoreCase("attic") || input2.equalsIgnoreCase("The attic") || input2.equalsIgnoreCase("An attic")) {
                message.setText("CORRECT, THE ATTIC");
            } else {
                message.setText("INCORRECT");
                //Displays new Screen
                //see AtticRoom.java
            }
        };
    }
    private static EventHandler<ActionEvent> back (TextField input, EventHandler<ActionEvent> goBack ) {
        return e -> {
            input.clear();
            goBack.handle(e);
        };
    }

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label prompt = makeLabel(p,Optional.empty(), Optional.of(25), true);

        Label riddle1 = makeLabel(rb1,Optional.empty(),Optional.empty(), true);

        Label riddle2 = makeLabel(rb2, Optional.empty(),Optional.empty(),false);

        TextField answerBox1 = makeTextField("Enter Answer for Riddle 1: ", true);
        TextField answerBox2 = makeTextField("Enter Answer for Riddle 2: ", false);

        Label message = makeLabel("", Optional.of("GREEN"), Optional.empty(), false);

        Button checkButton = makeButton("Check Answer", checkAnswer(answerBox1, answerBox2, message, answerBox2, riddle2));
        Button home = makeButton("HOME", back(answerBox1, goBack));

        VBox root = new VBox(5, prompt, riddle1, answerBox1, message, riddle2, answerBox2, checkButton ,home);
        root.setBackground(null);
        root.setAlignment(Pos.CENTER);


        Scene s = new Scene(root, 600, 400);
        s.setFill(Color.PURPLE);
        return s;

    }
}

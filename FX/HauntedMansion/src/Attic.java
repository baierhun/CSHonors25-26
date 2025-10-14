import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Attic implements AppScene {


    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label prompt = new Label("YOU MUST ANSWER THE NEXT RIDDLES TO ENTER THE ROOM");
        prompt.setStyle("-fx-font-weight: bold; -fx-font-size: 25; -fx-text-fill; red;");

        String rb1 = "I drift without a sail, I moan without a throat, +\n you see right through my body. What am I?";
        String rb2 = "By day I sleep beneath the floor, at night I glide and roam.  Where do I call home?";

        Label riddle1 = new Label(rb1);
        riddle1.setStyle("-fx-font-family: Papyrus, sans-serif;-fx-font-weight: bold; -fx-font-size: 15; -fx-text-fill; red; ");

        TextField answerBox1 = new TextField();
        answerBox1.setPromptText("Enter Answer:");

        Label riddle2 = new Label(rb2);
        riddle2.setVisible(false);
        riddle2.setStyle("-fx-font-family: Papyrus, sans-serif;-fx-font-weight: bold; -fx-font-size: 15; -fx-text-fill; red; ");

        TextField answerBox2 = new TextField();
        answerBox2.setPromptText("Enter Answer:");

        Button home = new Button("HOME");

        Label message = new Label("CORRECT! A GHOST");
        message.setStyle("-fx-font-family: Papyrus, sans-serif;-fx-font-weight: bold; -fx-font-size: 15; -fx-text-fill; green; ");
        message.setVisible(false);

        answerBox1.setOnAction(e -> {
            String input1 = answerBox1.getText();
            if (input1.equalsIgnoreCase("A ghost") || input1.equalsIgnoreCase("Ghost")) {
                message.setVisible(true);
                answerBox2.setVisible(true);
                riddle2.setVisible(true);
            } else {
                message.setText("INCORRECT");
                message.setVisible(true);
            }
        });

        answerBox2.setOnAction(e -> {
            String input2 = answerBox2.getText();
            if (input2.equalsIgnoreCase("attic") || input2.equalsIgnoreCase("The attic") || input2.equalsIgnoreCase("An attic")) {
                message.setText("CORRECT, THE ATTIC");

            } else {
                message.setText("INCORRECT");
                //Displays new Screen
            }
        });


        VBox root = new VBox(5, prompt, riddle1, answerBox1, message, riddle2, answerBox2, home);
        root.setBackground(null);
        root.setAlignment(Pos.CENTER);


        Scene s = new Scene(root, 600, 400);
        s.setFill(Color.PURPLE);
        return s;

    }
}

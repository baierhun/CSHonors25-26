import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.application.Application.getUserAgentStylesheet;
import static javafx.application.Application.launch;

public class EerieBasement implements AppScene{
    static final String descriptionText = """
                *You enter a dimly-lit, empty basement through a creaky set of stairs. 
                There is a message written sloppily in red, and it seems to be written by 
                the ghost that haunts this basement, an old math teacher. 
                Click the button to see what it says.*
                """;

    //Function for creating a label.
    private Label makeLabel(String text, Color fillColor){
        Label l = new Label(text);
        if (fillColor != null){
            l.setTextFill(fillColor);
        }
        return l;
    }

    //When the button is clicked, reveals the message.
    private void handleReveal(Label message){
        message.setVisible(true);
        message.setStyle("-fx-text-fill: red;");
        message.setAlignment(Pos.CENTER);
        message.setFont(Font.font("Impact", FontWeight.BOLD, 16));

    }

    private void handleSubmit(TextField answer, Label questionResponse){
        String input = answer.getText().toLowerCase();
        if(input.equals("5")){
            //Says correct
            questionResponse.setText("Correct! You are safe for now...");
        }
        else{
            //says wrong
            questionResponse.setText("Wrong! Watch out...");
        }
    }

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {

        //Creates a label for the title.
        Label title1 = makeLabel("The Eerie Basement", Color.WHITE);
        title1.setFont(new Font("Impact", 24));

        //Creates a label for the main description.
        Label mainDesc = makeLabel(descriptionText, Color.WHITE);
        mainDesc.setWrapText(true);
        mainDesc.setMaxWidth(500);
        mainDesc.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        mainDesc.setAlignment(Pos.CENTER);

        //Creates a label for the response to the question.
        Label questionResponse = makeLabel("", Color.WHITE);
        questionResponse.setFont(new Font("Impact", 16));

        //Creates a label for the message written on the wall.
        Label message = makeLabel("Solve this equation if you want to be safe: ( ( 3  +  4 ) 5 ) / 7",
                Color.RED);
        message.setVisible(false);

        //When the button is clicked, reveals the message on the wall.
        Button revealButton = new Button("Click to reveal");
        revealButton.setOnAction(e -> handleReveal(message));

        //Creates a text-field for the user to input their answer.
        TextField answer = new TextField();
        answer.setMaxWidth(200);

        //When the button is clicked, the users answer is submitted.
        Button submitAnswer = new Button("Submit your answer");

        //When the user submits their answer, prints out an outcome based on their response.
        submitAnswer.setOnAction(e -> handleSubmit(answer, questionResponse));

        //When the button is clicked, send the user back to the home screen.
        Button homeButton = new Button("Go back home");
        homeButton.setOnAction(e -> goBack.handle(e));

        //Vbox and its customizations.
        VBox lay = new VBox(10, title1, mainDesc, revealButton, message, answer, submitAnswer, questionResponse, homeButton);
        lay.setStyle("-fx-background-color: linear-gradient(to bottom, #1a1a1a, #787878);");
        lay.setAlignment(Pos.CENTER);
        lay.setFillWidth(true);

        Scene scene = new Scene(lay, 600,400);
        scene.setFill(Color.WHITE);
        return scene;

    }

}





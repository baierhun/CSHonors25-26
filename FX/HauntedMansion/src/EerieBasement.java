import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static java.awt.Color.BLACK;
import static java.awt.Color.red;
import static javafx.application.Application.launch;

public class EerieBasement implements AppScene{
    static final String descriptionText = """
                *You enter a dimly-lit basement through a creaky set of stairs. 
                It is completely empty and dirty. \
                You see a message written sloppily in red. 
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

    private void handleReveal(Label message){
        //When the button is clicked, reveals the message.
        message.setVisible(true);
        message.setStyle(String.format("%s-fx-text-fill: %s;", message.getStyle(), red));
    }

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label title1 = makeLabel("The Eerie Basement", null);
        Label mainDesc = makeLabel(descriptionText, null);
        Label message = makeLabel("LEAVE THIS HOUSE", Color.RED);
        message.setVisible(false);

        //When the button is clicked, reveals the message on the wall.
        Button revealButton = new Button("Click to reveal message");
        revealButton.setOnAction(e -> handleReveal(message));

        //When the button is clicked, send the user back to the home screen.
        Button homeButton = new Button("Go back home");
        homeButton.setOnAction(e ->goBack.handle(e));

        VBox lay = new VBox(10, title1, mainDesc, revealButton, message, homeButton);
        lay.setBackground(null);
        lay.setAlignment(Pos.CENTER);

        Scene scene = new Scene(lay, 600,400);
        scene.setFill(Color.WHITE);
        return scene;

    }

}





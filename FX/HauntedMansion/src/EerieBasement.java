import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class EerieBasement implements AppScene{

    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label title1 = new Label("The Eerie Basement");
        title1.setTextFill(Color.BLACK);

        Label mainDesc = new Label ("*You enter a dimly-lit basement through a creaky set of stairs. It is completely empty and dirty. " +
                "You see a message written sloppily in red. Click the button to see what it says.*\n");
        mainDesc.setTextFill(Color.BLACK);

        Button writingButton = new Button("Click here");
        //lamda function
        writingButton.setOnAction(e ->{
            System.out.println("Go to screen 2");
        });
        Button homeButton = new Button("Go back home");
        homeButton.setOnAction(e ->{
            goBack.handle(e);
        });
        //Second screen
//        Label title2 = new Label("The Eerie Basement");
//        title2.setTextFill(Color.BLACK);
//
//        Label writingDesc1 = new Label("* The wall says:");
//        writingDesc1.setTextFill(Color.BLACK);
//
//        Label writingDesc2 = new Label("LEAVE THIS HOUSE");
//        writingDesc2.setTextFill(Color.RED);
//
//        Label writingDesc3 = new Label ("Click the button to go back. *");
//        writingDesc3.setTextFill(Color.BLACK);
//
//        //Goes back to the first screen
//        Button backButton = new Button("Go back");
//        //lamda function
//        backButton.setOnAction(e ->){

        VBox lay = new VBox(10, title1, mainDesc, writingButton, homeButton);
        lay.setBackground(null);
        lay.setAlignment(Pos.CENTER);

        Scene ss = new Scene(lay, 600,400);
        ss.setFill(Color.GRAY);
        return ss;

        //Need to return scene, layout, all the elements inside the layout
    }

}





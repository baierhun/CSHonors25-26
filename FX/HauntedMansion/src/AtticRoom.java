import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Optional;



import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class AtticRoom implements AppScene {

    private static final String d = "Years ago this house was inhabited by an ordinary family with a boy, Charles and girl, Lisa and 2 parents, Laura and Ernie.  The mother had recently been showing signs of unease and mystery.  The kids could hear her talk in her sleep night after night murmuring thoughts of someone calling her name.  She continued to act like this until the kids were in the attic with their father playing when Laura came up stairs and murdered all of them.  Now, passersby on the street do not even pay attention to the house, as those who do can still hear screams and see shadows in the window.";


    private static Label makeLabel(String text, Optional<String> color, Optional<Integer>fontSize, boolean isVisible){
        Label l = new Label(text);
        l.setVisible(isVisible);
        l.setStyle(String.format("-fx-font-family: Papyrus, -fx-font-weight: bold; -fx-text-fill: %s; -fx-font-size: %d;,", color.orElse("red"), fontSize.orElse(15)));
        return l;
    }

    private static Circle makeCircle(int xPos, int yPos, double radius, Optional<Paint> color){
        Circle cir = new Circle(xPos, yPos, radius);
        cir.setFill(color.orElse(BLACK));
        cir.setVisible(true);
        return cir;
    }

    private static Button makeButton(String text, EventHandler<ActionEvent> e){
        Button b = new Button();
        b.setOnAction(e);
        return b;

    }

    private static StackPane makeGhost(boolean isVisible){
        Circle rightEye = makeCircle(5,0,5,Optional.empty());
        Circle leftEye = makeCircle(15,0,5,Optional.empty());
        Circle head = makeCircle(0,0,30,Optional.of(WHITE));
        Circle mouth = makeCircle(5,0,4,Optional.empty());
        Rectangle body = new Rectangle(-30, 10, 60, 60);
        body.setFill(WHITE);

        StackPane ghost = new StackPane(head, body, rightEye, leftEye, mouth);
        ghost.setVisible(isVisible);

        return ghost;

    }
    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {

        Label title = makeLabel("Welcome to the Spooky Attic", Optional.empty(), Optional.of(25), true);
        title.setStyle(" sans-serif;-fx-font-weight: bold; -fx-font-size: 25; -fx-text-fill; red;");

        Label description = makeLabel(d, Optional.empty(), Optional.of(12), true);

        Button backButton = makeButton("BACK", goBack);

        //Create VBox with 3 elements 2 Labels and the StackPane object
        VBox lay = new VBox(20, title, description, makeGhost(true), backButton);
        Scene s = new Scene(lay, 600, 400);
        s.setFill(Color.PURPLE);
        return s;

    }
}
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class AtticRoom implements AppScene {
    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {

        Label title = new Label("Welcome to the Spooky Attic");
        title.setStyle("-fx-font-family: Papyrus, sans-serif;-fx-font-weight: bold; -fx-font-size: 25; -fx-text-fill; red;");

        Label description = new Label("Years ago this house was inhabited by an ordinary family with a boy, Charles and girl, Lisa and 2 parents, Laura and Ernie.  The mother had recently been showing signs of unease and mystery.  The kids could hear her talk in her sleep night after night murmuring thoughts of someone calling her name.  She continued to act like this until the kids were in the attic with their father playing when Laura came up stairs and murdered all of them.  Now, passersby on the street do not even pay attention to the house, as those who do can still hear screams and see shadows in the window.");
        description.setStyle("-fx-font-family: Papyrus, sans-serif; -fx-font-size: 12; -fx-text-fill; red;");

        Circle eyeLeft = new Circle(5, 0, 5);
        eyeLeft.setFill(Color.BLACK);

        Circle eyeRight = new Circle(15, 0, 5);
        eyeRight.setFill(Color.BLACK);

        Circle head = new Circle(0, 0, 30);
        eyeRight.setFill(Color.WHITE);

        Circle mouth = new Circle(5, 0, 4);
        eyeRight.setFill(Color.BLACK);


        Rectangle body = new Rectangle(-30, 10, 60, 60);
        eyeRight.setFill(Color.WHITE);




        StackPane ghost = new StackPane(head, body, eyeRight, eyeLeft, mouth);


        VBox lay = new VBox(20, title, description, ghost);
        Scene s = new Scene(lay, 600, 400);
        s.setFill(Color.PURPLE);
        return s;

    }
}
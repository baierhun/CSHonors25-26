import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;

public class SpookyAttic extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label header = new Label("I drift without a sail, I moan without a throat, you see right through my body. What am I?");
        header.setTextFill(Color.GREEN);
        GridPane grid = new GridPane();
        grid.setAlignemnt(Pos.CENTER);




        primaryStage.setScene(mainScene);




        return null;
    }
}


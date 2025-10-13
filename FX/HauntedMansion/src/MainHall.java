import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainHall extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label title = new Label("Welcome to the Haunted Mansion!");
        title.setTextFill(Color.CHOCOLATE);

        VBox layout = new VBox(15, title);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(null);

        Scene mainScene = new Scene(layout, 600, 400);
        mainScene.setFill(Color.BLACK);

        Scene dogHouseScene = new DogHouse().getScene(e -> primaryStage.setScene(mainScene));
        Button dogHouseBtn = new Button("Dog House");
        dogHouseBtn.setOnAction(e -> primaryStage.setScene(dogHouseScene));
        layout.getChildren().add(dogHouseBtn);

        primaryStage.setTitle("Haunted Mansion");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

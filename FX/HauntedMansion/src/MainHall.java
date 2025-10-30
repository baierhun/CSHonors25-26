import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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

        SceneSetter sceneSetter = new SceneSetter(primaryStage, mainScene);

        Scene dogHouseScene = new DogHouse(sceneSetter).getScene();
        Button dogHouseBtn = new Button("Dog House");
        dogHouseBtn.setOnAction(e -> primaryStage.setScene(dogHouseScene));

        Scene bathroomScene = new Bathroom().getScene(e -> primaryStage.setScene(mainScene));
        Button bathroomBtn = new Button("Bathroom");
        bathroomBtn.setOnAction(e -> primaryStage.setScene(bathroomScene));

        Scene eerieBasementScene = new EerieBasement(sceneSetter).getScene();
        Button eerieBasementBtn = new Button("Eerie Basement");
        eerieBasementBtn.setOnAction(e -> primaryStage.setScene(eerieBasementScene));

        Scene finalDinnerScene = new TheFinalDinner().getScene(e -> primaryStage.setScene(mainScene));
        Button finalDinnerBtn = new Button("Final Dinner");
        finalDinnerBtn.setOnAction(e -> primaryStage.setScene(finalDinnerScene));

        Scene atticScene = new Attic(sceneSetter).getScene();
        Button atticBtn = new Button("Attic");
        atticBtn.setOnAction(e -> primaryStage.setScene(atticScene));

        Scene chambersOfDeathScene = new ChambersOfDeath(sceneSetter).getScene();
        Button chambersOfDeathBtn = new Button("Chambers of Death");
        chambersOfDeathBtn.setOnAction(e -> primaryStage.setScene(chambersOfDeathScene));

        HBox buttons = new HBox(15, dogHouseBtn, bathroomBtn, eerieBasementBtn, finalDinnerBtn, atticBtn, chambersOfDeathBtn);
        buttons.setAlignment(Pos.CENTER);
        layout.getChildren().add(buttons);

        primaryStage.setTitle("Haunted Mansion");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

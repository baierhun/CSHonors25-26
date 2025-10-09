import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // the Stage is the main window of the application
        primaryStage.setTitle("Hello, JavaFX");

        // a StackPane is a layout container/manager used to configure and organize everything visible.
        StackPane root = new StackPane();

        // an example of a node that can be added to a scene
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello, FX!");
//            }
//        });

        EventHandler<ActionEvent> a = event -> System.out.println("Hello, FX!");

        btn.setOnAction(event -> System.out.println("Hello, FX!"));

        root.getChildren().add(btn);

        // a Scene is what is displayed on the stage.
        // there can be many Scenes, but only one on the stage at a time
        Scene mainScene = new Scene(root, 300, 250);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

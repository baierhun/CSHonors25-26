import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ShapesReview extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Line l = new Line();
        l.setStartX(100);
        l.setEndX(200);
        l.setStrokeWidth(50);
        VBox v = new VBox(l);
        v.setAlignment(Pos.CENTER);
        Scene s = new Scene(v, 600, 400);
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

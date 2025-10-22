import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BasicShapes extends Application {
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();

        // Circle with center (100, 100) and radius 50
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.LIGHTBLUE);
        circle.setStroke(Color.DARKBLUE);

        // Rectangle with top-left corner (200, 80), width 100, height 60
        Rectangle rect = new Rectangle(200, 80, 100, 60);
        rect.setFill(Color.LIGHTGREEN);
        rect.setStroke(Color.DARKGREEN);

        // Line from (50, 200) to (350, 200)
        Line line = new Line(50, 200, 350, 200);
        line.setStroke(Color.RED);

        // Add shapes to the Pane
        root.getChildren().addAll(circle, rect, line);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("JavaFX Shapes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
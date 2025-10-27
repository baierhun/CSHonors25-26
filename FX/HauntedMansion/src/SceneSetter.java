import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSetter {
    private Stage stage;
    public SceneSetter(Stage stage) {
        this.stage = stage;
    }

    public void goTo(Scene scene) {
        stage.setScene(scene);
    }
}

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSetter {
    private Stage stage;
    private Scene home;

    public SceneSetter(Stage stage, Scene home) {
        this.stage = stage;
        this.home = home;
    }

    public void goTo(Scene scene) {
        stage.setScene(scene);
    }

    public void goHome() {
        stage.setScene(home);
    }
}

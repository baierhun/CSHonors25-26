import javafx.scene.Scene;

public abstract class AppSceneTool {
    protected SceneSetter sceneSetter;
    public AppSceneTool(SceneSetter sceneSetter) {
        this.sceneSetter = sceneSetter;
    }
    /**
     * @return The Scene representing this room
     */
    abstract Scene getScene();
}

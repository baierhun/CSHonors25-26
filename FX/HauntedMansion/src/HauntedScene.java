import javafx.scene.Scene;

public abstract class HauntedScene {
    protected SceneSetter sceneSetter;
    public HauntedScene(SceneSetter sceneSetter) {
        this.sceneSetter = sceneSetter;
    }
    /**
     * @return The Scene representing this room
     */
    abstract Scene getScene();
}

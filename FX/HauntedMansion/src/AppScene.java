import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public interface AppScene {
    /**
     * @param goBack An EventHandler that handles going back to the main hall
     * @return The Scene representing this room
     */
    Scene getScene(EventHandler<ActionEvent> goBack);
}

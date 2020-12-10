package scenes;

import javafx.scene.Scene;
import panes.LoginPane;

/**
 * Login Scene:
 * It will play the Login Pane
 *
 * @author Omar Yousef & Farzana Moury
 * @version 1.0
 * @since 5th December 2020
 */
public class LoginScene extends Scene {
    /**
     * LoginScene() constructor:
     * It will allow us to make a new scene instance
     */
    public LoginScene() {
        super(new LoginPane(), 1024, 768);
    }
}

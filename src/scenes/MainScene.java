package scenes;

import javafx.scene.Scene;
import panes.MainPane;

/**
 * Main Scene:
 * This will hold the mainPane
 *
 * @author Farzana Moury and Omar Yousef
 * @version 1.0
 * @since Dec 7th 2020
 */
public class MainScene extends Scene {

    /**
     * MainScene() constructor:
     * It will allow us to make a new scene instance
     */
    public MainScene() {
        super(new MainPane(), 1024, 768);
    }

}

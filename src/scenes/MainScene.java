package scenes;

import javafx.scene.Scene;
import panes.LoginPane;
import panes.MainPane;

public class MainScene extends Scene {
    public MainScene() {
        super(new MainPane(), 1024, 768);
    }

}

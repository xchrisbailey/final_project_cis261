package game;

import javafx.event.ActionEvent;

import java.io.IOException;

public class DashboardController extends SceneLoader {
    /**
     * load game history scene
     *
     * @param e - current event
     * @throws IOException - error catching for file loading
     */
    public void loadHistoryView(ActionEvent e) throws IOException {
        loadScene(e, "historyScreen.fxml");
    }

    /**
     * Load game setup scene
     *
     * @param e - current event
     * @throws IOException - error catching for file loading
     */
    public void loadGameSetupView(ActionEvent e) throws IOException {
        loadScene(e, "gameSetupScreen.fxml");
    }
}

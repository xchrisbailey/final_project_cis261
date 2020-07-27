package game;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Controller extends SceneLoader {
    /**
     * load game history scene
     *
     * @param e - current event
     * @throws IOException
     */
    public void loadHistoryView(ActionEvent e) throws IOException {
        loadScene(e, "historyView.fxml");
    }

    /**
     * Load game setup scene
     *
     * @param e - current event
     * @throws IOException
     */
    public void loadGameSetupView(ActionEvent e) throws IOException {
        loadScene(e, "gameSetup.fxml");
    }
}

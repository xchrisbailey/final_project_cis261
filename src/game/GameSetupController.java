package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GameSetupController extends SceneLoader {
    @FXML private TextField p1Name;
    @FXML private TextField p2Name;
    @FXML private Button loadGameBTN;

    /**
     * Loads game screen and sends across player one and player two names
     *
     * @param e
     * @throws IOException
     */
    @FXML
    void loadGame(ActionEvent e) throws IOException {
        loadScene(e, "gameView.fxml", p1Name.getText(), p2Name.getText());
    }
}

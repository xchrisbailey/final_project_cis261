package game;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GameSetupController extends SceneLoader {
    @FXML private TextField p1Name;
    @FXML private TextField p2Name;
    @FXML private Button loadGameBTN;

    @FXML
    public void initialize() {
        loadGameBTN
                .disableProperty()
                .bind(
                        Bindings.isEmpty(p1Name.textProperty())
                                .or(Bindings.isEmpty(p2Name.textProperty())));
    }

    /**
     * Loads game screen and sends across player one and player two names
     *
     * @param e - current event
     * @throws IOException - catch error loading scene
     */
    @FXML
    void loadGame(ActionEvent e) throws IOException {
        loadScene(e, "gameScreen.fxml", p1Name.getText(), p2Name.getText());
    }

    @FXML
    private void loadDashboard(ActionEvent e) throws IOException {
        loadScene(e, "dashboardScreen.fxml");
    }
}

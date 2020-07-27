package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class WinnerController extends SceneLoader {

    @FXML private Label winnerNameLabel;

    @FXML private Label winnerScoreLabel;

    @FXML private Button closeScreenBTN;

    private Player winningPlayer;

    public void initData(Player player) {
        winningPlayer = player;
        setLabelData();
    }

    @FXML
    private void setLabelData() {
        winnerScoreLabel.setText(Integer.toString(winningPlayer.getScore()));
        winnerNameLabel.setText(winningPlayer.getName());
    }

    @FXML
    private void loadDashboard(ActionEvent e) throws IOException {
        loadScene(e, "dashboardScreen.fxml");
    }
}

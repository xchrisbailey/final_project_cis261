package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WinnerViewController {

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
        Parent dashboardViewParent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Scene dashboardViewScene = new Scene(dashboardViewParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(dashboardViewScene);
        window.show();
    }
}

package game;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {
    Player playerOne;
    Player playerTwo;

    @FXML private Label playerOneNameLabel;

    @FXML private Label playerOneScoreLabel;

    @FXML private Label playerTwoNameLabel;

    @FXML private Label playerTwoScoreLabel;

    public void initData(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName, 0);
        playerTwo = new Player(playerTwoName, 0);

        playerOneNameLabel.setText(playerOne.getName());
        playerOneScoreLabel
                .textProperty()
                .bind(new SimpleStringProperty(Integer.toString(playerOne.getScore())));

        playerTwoNameLabel.setText(playerTwo.getName());
        playerTwoScoreLabel
                .textProperty()
                .bind(new SimpleStringProperty(Integer.toString(playerTwo.getScore())));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}

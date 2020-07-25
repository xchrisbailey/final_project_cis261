package game;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameViewController {
    private Player playerOne;
    private Player playerTwo;
    private int currentTurnScore = 0;
    private Player currentPlayer;

    @FXML private Label playerOneNameLabel;
    @FXML private Label playerOneScoreLabel;
    @FXML private Label playerTwoNameLabel;
    @FXML private Label playerTwoScoreLabel;
    @FXML private Label currentPlayerLabel;
    @FXML private Label currentPlayerTurnScore;

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

        currentPlayerTurnScore
                .textProperty()
                .bind(new SimpleStringProperty(Integer.toString(currentTurnScore)));

        currentPlayer = playerOne;
        currentPlayerLabel.setText(currentPlayer.getName());
    }
}

package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Random;

public class GameController extends SceneLoader {
    private Player playerOne;
    private Player playerTwo;
    private int currentTurnScore = 0;
    private Player currentPlayer;
    private final Random rand = new Random();

    @FXML private Label playerOneNameLabel;
    @FXML private Label playerOneScoreLabel;
    @FXML private Label playerTwoNameLabel;
    @FXML private Label playerTwoScoreLabel;
    @FXML private Label currentPlayerLabel;
    @FXML private Label currentPlayerTurnScore;
    @FXML private ImageView dieImageView;

    public void init(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName, 0);
        playerTwo = new Player(playerTwoName, 0);

        playerOneNameLabel.setText(playerOne.getName());
        playerOneScoreLabel.setText(Integer.toString(playerOne.getScore()));

        playerTwoNameLabel.setText(playerTwo.getName());
        playerTwoScoreLabel.setText(Integer.toString(playerTwo.getScore()));

        currentPlayerTurnScore.setText(Integer.toString(currentTurnScore));

        currentPlayer = playerOne;
        currentPlayerLabel.setText(currentPlayer.getName());
    }

    /** save current round score to current player total and switch players */
    @FXML
    void bankScore() {
        currentPlayer.score += currentTurnScore;
        updatePlayerScoreboard(currentPlayer);
        updateCurrentTurnScore(0, "reset");
        changePlayer();
    }

    /**
     * take current player turn roll die, update turn score, check game status, and change player
     *
     * @param e - button click event info
     */
    @FXML
    void rollDie(ActionEvent e) throws IOException {
        int rollNumber = rand.nextInt(6) + 1;
        changeDieFace(new Image(rollNumber + ".png"));
        updateCurrentTurnScore(rollNumber, "update");

        // check current score status.
        // if 100 or greater save game results and return to dashboard
        if (checkGameStatus()) {
            currentPlayer.score += currentTurnScore;
            saveResults();
            loadScene(e, "winnerScreen.fxml", currentPlayer); // load winner scene
        }

        if (rollNumber == 1) changePlayer();
    }

    /** check current game status */
    private boolean checkGameStatus() {
        return currentPlayer.score + currentTurnScore >= 100;
    }

    /** save current game results to log */
    private void saveResults() {
        Result gameResult = new Result(playerOne, playerTwo);
        WriteLog.save(gameResult);
    }

    /**
     * change die face to new image
     *
     * @param dieUrl - Image of new die face
     */
    private void changeDieFace(Image dieUrl) {
        dieImageView.setImage(dieUrl);
    }

    /**
     * update current round score and set label
     *
     * @param amount - current roll amount to be added or reset score from
     */
    private void updateCurrentTurnScore(int amount, String action) {

        switch (action) {
            case "reset":
                currentTurnScore = amount;
                break;
            case "update":
                if (amount == 1) {
                    currentTurnScore = 0;
                } else {
                    currentTurnScore += amount;
                }
                break;
        }

        currentPlayerTurnScore.setText(Integer.toString(currentTurnScore));
    }

    /** change current player to awaiting player */
    private void changePlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }

        currentPlayerLabel.setText(currentPlayer.getName());
    }

    /**
     * update player score label
     *
     * @param player - player whose score is to be updated
     */
    private void updatePlayerScoreboard(Player player) {
        if (player.getName().equals(playerOne.getName())) {
            playerOneScoreLabel.setText(Integer.toString(player.getScore()));
        } else {
            playerTwoScoreLabel.setText(Integer.toString(player.getScore()));
        }
    }
}

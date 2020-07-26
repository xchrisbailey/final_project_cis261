package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class GameViewController {
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
    @FXML private Button rollBTN;
    @FXML private Button scoreBankBTN;
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

    /**
     * save current round score to current player total and switch players
     *
     * @param event - button click event info
     */
    @FXML
    void bankScore(ActionEvent event) {
        currentPlayer.score += currentTurnScore;
        updatePlayerScoreboard(currentPlayer);
        updateCurrentTurnScore(0, "reset");
        changePlayer();
    }

    /**
     * take current player turn roll die, update turn score, check game status, and change player
     *
     * @param event - button click event info
     */
    @FXML
    void rollDie(ActionEvent event) {
        int rollNumber = rand.nextInt(6) + 1;
        changeDieFace(new Image(rollNumber + ".png"));
        updateCurrentTurnScore(rollNumber, "update");

        // check current score status.
        // if 100 or greater save game results and return to dashboard
        if (checkGameStatus()) {
            saveResults();
            loadWinnerScene(event);
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
        gameResult.save();
    }

    /**
     * load dashboard scene
     *
     * @param event - current javafx event information
     */
    private void loadWinnerScene(ActionEvent event) {
        Parent dashboardViewParent = null;
        try {
            dashboardViewParent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert dashboardViewParent != null;
        Scene dashboardViewScene = new Scene(dashboardViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(dashboardViewScene);
        window.show();
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

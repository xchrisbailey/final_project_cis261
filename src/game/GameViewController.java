package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class GameViewController {
    private Player playerOne;
    private Player playerTwo;
    private int currentTurnScore = 0;
    private Player currentPlayer;
    private Random rand = new Random();

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

    @FXML
    void bankScore(ActionEvent event) {
        // add score to player total
        System.out.println("score banking");
    }

    @FXML
    void rollDie(ActionEvent event) {
        int rollNumber = rand.nextInt(6) + 1;
        changeDieFace(new Image(rollNumber + ".png"));
        updateCurrentTurnScore(rollNumber);
        if (rollNumber == 1) changePlayer();
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
    private void updateCurrentTurnScore(int amount) {
        if (amount == 1) {
            currentTurnScore = 0;
        } else {
            currentTurnScore += amount;
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
}

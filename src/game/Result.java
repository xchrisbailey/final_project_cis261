package game;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Result implements Serializable {
    LocalDateTime timestamp = LocalDateTime.now();
    String playerOneName;
    String playerTwoName;
    int playerOneScore;
    int playerTwoScore;

    public Result(Player playerOne, Player playerTwo) {
        this.playerOneName = playerOne.getName();
        this.playerOneScore = playerOne.getScore();
        this.playerTwoName = playerTwo.getName();
        this.playerTwoScore = playerTwo.getScore();
    }
}

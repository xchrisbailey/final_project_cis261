package game;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Result implements Serializable {
    private final String timestamp;
    private final String playerOneName;
    private final String playerTwoName;
    private final int playerOneScore;
    private final int playerTwoScore;

    @Override
    public String toString() {
        return "Result{"
                + "timestamp="
                + timestamp
                + ", playerOneName='"
                + playerOneName
                + '\''
                + ", playerTwoName='"
                + playerTwoName
                + '\''
                + ", playerOneScore="
                + playerOneScore
                + ", playerTwoScore="
                + playerTwoScore
                + '}';
    }

    public Result(Player playerOne, Player playerTwo) {
        this.timestamp =
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.playerOneName = playerOne.getName();
        this.playerOneScore = playerOne.getScore();
        this.playerTwoName = playerTwo.getName();
        this.playerTwoScore = playerTwo.getScore();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
}

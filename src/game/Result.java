package game;

public class Result {
    Player playerOne;
    Player playerTwo;

    public Result(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void save() {
        System.out.println("save results to log file");
    }
}

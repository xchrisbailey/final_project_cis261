package game;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {
    Player playerOne;
    Player playerTwo;

    public void initData(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName, 0);
        playerTwo = new Player(playerTwoName, 0);

        System.out.println(playerOne.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}

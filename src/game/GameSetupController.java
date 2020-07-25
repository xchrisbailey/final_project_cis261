package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GameSetupController {
    @FXML private TextField p1Name;
    @FXML private TextField p2Name;
    @FXML private Button loadGameBTN;

    @FXML
    void loadGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("gameView.fxml"));
        Parent gameViewParent = loader.load();

        Scene gameViewScene = new Scene(gameViewParent);

        GameViewController c = loader.getController();
        c.init(p1Name.getText(), p2Name.getText());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(gameViewScene);
        window.show();
    }
}

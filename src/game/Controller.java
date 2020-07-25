package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    //    change scene to history view
    public void loadHistoryView(ActionEvent e) throws IOException {
        Parent historyViewParent = FXMLLoader.load(getClass().getResource("historyView.fxml"));
        Scene historyViewScene = new Scene(historyViewParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(historyViewScene);
        window.show();
    }

    //    change scene to game view
    public void loadGameSetupView(ActionEvent e) throws IOException {
        Parent gameSetupView = FXMLLoader.load(getClass().getResource("gameSetup.fxml"));
        Scene gameSetupViewScene = new Scene(gameSetupView);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(gameSetupViewScene);

        window.show();
    }
}

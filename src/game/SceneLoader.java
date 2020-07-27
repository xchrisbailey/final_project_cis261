package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    /**
     * basic scene loader
     *
     * @param e - current event
     * @param fxmlFileName - filename of target fxml file
     * @throws IOException
     */
    public static void loadScene(ActionEvent e, String fxmlFileName) throws IOException {
        Parent viewParent = FXMLLoader.load(SceneLoader.class.getResource(fxmlFileName));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }

    /**
     * Loads game view scene
     *
     * @param e - current event
     * @param fxmlFileName - filename of target fxml file
     * @param p1Name - player one name
     * @param p2Name - player two name
     * @throws IOException
     */
    public static void loadScene(ActionEvent e, String fxmlFileName, String p1Name, String p2Name)
            throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SceneLoader.class.getResource(fxmlFileName));
        Parent viewParent = loader.load();

        Scene viewScene = new Scene(viewParent);

        GameController c = loader.getController();
        c.init(p1Name, p2Name);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }

    /**
     * loads winner view scene
     *
     * @param e - current event
     * @param fxmlFileName - filename of target fxml file
     * @param winner - Player object of game winner
     * @throws IOException
     */
    public static void loadScene(ActionEvent e, String fxmlFileName, Player winner)
            throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SceneLoader.class.getResource(fxmlFileName));
        Parent viewParent = loader.load();

        Scene viewScene = new Scene(viewParent);

        WinnerController c = loader.getController();
        c.initData(winner);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }
}

package game;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class HistoryViewController extends SceneLoader {
    @FXML private TableView<Result> resultsTable;
    @FXML private TableColumn<Result, StringProperty> dateCol;
    @FXML private TableColumn<Result, StringProperty> playerOneNameCol;
    @FXML private TableColumn<Result, IntegerProperty> playerOneScoreCol;
    @FXML private TableColumn<Result, StringProperty> playerTwoNameCol;
    @FXML private TableColumn<Result, IntegerProperty> playerTwoScoreCol;
    @FXML private Button dashboardBTN;

    @FXML
    public void initialize() {
        ObservableList<Result> observableResults =
                FXCollections.observableArrayList(loadResultFile());

        dateCol.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        playerOneNameCol.setCellValueFactory(new PropertyValueFactory<>("playerOneName"));
        playerOneScoreCol.setCellValueFactory(new PropertyValueFactory<>("playerOneScore"));
        playerTwoNameCol.setCellValueFactory(new PropertyValueFactory<>("playerTwoName"));
        playerTwoScoreCol.setCellValueFactory(new PropertyValueFactory<>("playerTwoScore"));

        resultsTable.setItems(observableResults);
    }

    private ArrayList<Result> loadResultFile() {
        ArrayList<Result> tmpArrayList = new ArrayList<>();
        boolean eof = false;
        try (ObjectInputStream oi =
                new ObjectInputStream(new FileInputStream("scoreHistory.dat"))) {
            while (!eof) {
                try {
                    tmpArrayList.add((Result) oi.readObject());
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tmpArrayList;
    }

    @FXML
    private void loadDashboardView(ActionEvent e) throws IOException {
        loadScene(e, "dashboard.fxml");
    }
}

package game;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class HistoryViewController {
    ArrayList<Result> results = new ArrayList<Result>();

    public HistoryViewController() {
        loadResultFile();
        results.forEach((r) -> System.out.println(r.toString()));
    }

    private void loadResultFile() {
        boolean eof = false;
        try (ObjectInputStream oi =
                new ObjectInputStream(new FileInputStream("scoreHistory.dat"))) {
            while (!eof) {
                try {
                    results.add((Result) oi.readObject());
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

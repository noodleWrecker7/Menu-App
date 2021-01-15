package noodle.dupes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import noodle.Main;
import noodle.ScreenController;

import java.util.ArrayList;

public class Controller {
    ArrayList<Integer> dupes = new ArrayList<>();
    ArrayList<Integer> numsNoDupe = new ArrayList<>();

    @FXML
    private void search() {
        for (int i = 0; i < Main.numbers.size(); i++) {
            if (!numsNoDupe.contains(Main.numbers.get(i))) numsNoDupe.add(Main.numbers.get(i));
        }

        dupes = (ArrayList<Integer>) Main.numbers.clone();
        for (int i = 0; i < numsNoDupe.size(); i++) {
            dupes.remove(numsNoDupe.get(i));
        }
        ((Text) ScreenController.getCurrentScene().lookup("#result")).setText(dupes.toString());
    }

    @FXML
    private void remove() {
        noodle.Controller.removeFromArray();
        search();
    }

    @FXML
    private void add() {
        noodle.Controller.addToArray();
        search();
    }

    @FXML
    private void deleteDupes() {
        search();
        Main.numbers = numsNoDupe;
        noodle.Controller.updateArrayDisplay();
        search();
    }

    @FXML
    private void menuClicked(MouseEvent event) {
        noodle.Controller.goToPage(((Button) event.getSource()).getId());
    }
}

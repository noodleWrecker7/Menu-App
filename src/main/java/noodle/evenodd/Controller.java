package noodle.evenodd;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import noodle.Main;
import noodle.ScreenController;

public class Controller {

    private void recalculateValues() {
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < Main.numbers.size(); i++) {
            if (Main.numbers.get(i) % 2 == 0) evenCount++;
            else oddCount++;
        }

        Scene scene = ScreenController.getCurrentScene();
        ((Label) scene.lookup("#odd-result")).setText(Integer.toString(oddCount));
        ((Label) scene.lookup("#even-result")).setText(Integer.toString(evenCount));
    }

    @FXML
    private void remove(MouseEvent event) {
        noodle.Controller.removeFromArray();
        recalculateValues();
    }

    @FXML
    private void add(MouseEvent event) {
        noodle.Controller.addToArray();
        recalculateValues();
    }


    @FXML
    private void menuClicked(MouseEvent event) {
        noodle.Controller.goToPage(((Button) event.getSource()).getId());
    }
}

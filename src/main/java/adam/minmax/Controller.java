package adam.minmax;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import adam.Main;
import adam.ScreenController;

public class Controller {

    private void recalculateValues() {
        if(Main.numbers.size() == 0) return;
        int min = Main.numbers.get(0), max = min;
        for (int i = 0; i < Main.numbers.size(); i++) {
            if (Main.numbers.get(i) < min) min = Main.numbers.get(i);
            if (Main.numbers.get(i) > max) max = Main.numbers.get(i);
        }

        int range = max - min;
        Scene scene = ScreenController.getCurrentScene();
        ((Label) scene.lookup("#range-result")).setText(Integer.toString(range));
        ((Label) scene.lookup("#min-result")).setText(Integer.toString(min));
        ((Label) scene.lookup("#max-result")).setText(Integer.toString(max));
    }

    @FXML
    private void remove(MouseEvent event) {
        adam.Controller.removeFromArray();
        recalculateValues();
    }

    @FXML
    private void add(MouseEvent event) {
        adam.Controller.addToArray();
        recalculateValues();
    }


    @FXML
    private void menuClicked(MouseEvent event) {
        adam.Controller.goToPage(((Button) event.getSource()).getId());
    }
}

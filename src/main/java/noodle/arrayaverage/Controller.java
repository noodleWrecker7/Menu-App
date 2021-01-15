package noodle.arrayaverage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import noodle.Main;
import noodle.ScreenController;

public class Controller {

    private void recalculateValues() {
        if(Main.numbers.size() == 0) return;
        int total = 0;
        for (int i = 0; i < Main.numbers.size(); i++) {
            total += Main.numbers.get(i);
        }

        float avg = (float) total / (float) Main.numbers.size();

        ((Label) ScreenController.getPane("array average").lookup("#result")).setText(Float.toString(avg));
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

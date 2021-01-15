package adam.position;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import adam.Main;
import adam.ScreenController;

public class Controller {

    @FXML
    private void remove(MouseEvent event) {
        adam.Controller.removeFromArray();
    }

    @FXML
    private void add(MouseEvent event) {
        String input = ((TextField) ScreenController.getCurrentScene().lookup("#input-field")).getText();

        try {
            String position = ((TextField) ScreenController.getCurrentScene().lookup("#position-field")).getText();
            int num = Integer.parseInt(input);
            int pos = 0;
            try {
                pos = Integer.parseInt(position);
            } catch (Exception e) {
            }
            if (pos > Main.numbers.size() || pos < 0) {
                return;
            }
            Main.numbers.add(pos, num);
            ((TextField) ScreenController.getCurrentScene().lookup("#input-field")).clear();
        } catch (Exception e) {
        }
        adam.Controller.updateArrayDisplay();
    }


    @FXML
    private void menuClicked(MouseEvent event) {
        adam.Controller.goToPage(((Button) event.getSource()).getId());
    }
}

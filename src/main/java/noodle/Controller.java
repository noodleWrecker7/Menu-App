package noodle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private void menuClicked(MouseEvent event) {
        String id = ((Button) event.getSource()).getId();
        goToPage(id);
    }

    public static void goToPage(String id) {
        ScreenController.activate(id);
    }


}


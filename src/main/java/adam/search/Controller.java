package adam.search;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import adam.Main;
import adam.ScreenController;

import java.util.ArrayList;

public class Controller {


    @FXML
    private void search(MouseEvent event) {
        if (Main.numbers.size() == 0) return;
        String input = ((TextField) ScreenController.getCurrentScene().lookup("#search-field")).getText();
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < Main.numbers.size(); i++) {
            if (Main.numbers.get(i).toString().equals(input)) {
                indexes.add(i);
            }
        }

        String outText;
        if (indexes.size() == 0) {
            outText = "That item could not be found ;(";
        } else {
            outText = indexes.size() + " " + input + "s were found at index(s) " + indexes.toString();
        }
        ((Text) ScreenController.getCurrentScene().lookup("#result")).setText(outText);
    }

    @FXML
    private void remove(MouseEvent event) {
        adam.Controller.removeFromArray();
    }

    @FXML
    private void add(MouseEvent event) {
        adam.Controller.addToArray();
    }

    @FXML
    private void menuClicked(MouseEvent event) {
        adam.Controller.goToPage(((Button) event.getSource()).getId());
    }
}

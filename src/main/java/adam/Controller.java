package adam;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private void menuClicked(MouseEvent event) {
        String id = ((Button) event.getSource()).getId();
        goToPage(id);
    }


    public static void goToPage(String id) {
        ScreenController.activate(id);
        try {
            updateArrayDisplay();
        } catch (RuntimeException e) {
            System.out.println("couldn't update array display for page: " + id);
        }
    }

    public static void addToArray() {
        String input = ((TextField) ScreenController.getCurrentScene().lookup("#input-field")).getText();
        try {
            int num = Integer.parseInt(input);
            Main.numbers.add(num);
            ((TextField) ScreenController.getCurrentScene().lookup("#input-field")).clear();
        } catch (Exception e) {
        }
        updateArrayDisplay();
    }

    public static void removeFromArray() {
        String input = ((TextField) ScreenController.getCurrentScene().lookup("#input-field")).getText();
        try {
            int num = Integer.parseInt(input);
            Main.numbers.remove(Main.numbers.lastIndexOf(num));
            ((TextField) ScreenController.getCurrentScene().lookup("#input-field")).clear();

        } catch (Exception e) {
        }
        updateArrayDisplay();
    }

    public static void updateArrayDisplay() {
        ((Label) ScreenController.getCurrentScene().lookup("#array-field")).setText(Main.numbers.toString());
    }


}


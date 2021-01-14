package noodle.arrayaverage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import noodle.ScreenController;

import java.util.ArrayList;

public class Controller {

    ArrayList<Integer> numbers = new ArrayList<>();

    private void recalculateAverage() {
        int total = 0;
        for (int i = 0; i < numbers.size(); i++) {
            total += numbers.get(i);
        }

        float avg = (float) total / (float) numbers.size();

        ((Label) ScreenController.getScene("array average").lookup("#result")).setText(Float.toString(avg));
    }

    @FXML
    private void remove(MouseEvent event) {
        String input = ((TextField) ScreenController.getScene("array average").lookup("#input-field")).getText();
        try {
            int num = Integer.parseInt(input);
            numbers.remove(numbers.lastIndexOf(num));
            ((TextField) ScreenController.getScene("array average").lookup("#input-field")).clear();
            updateArrayDisplay(event);
            recalculateAverage();
        } catch (Exception e) {
        }
    }

    @FXML
    private void add(MouseEvent event) {
//        System.out.println(ScreenController.getScene("array average").lookup("#input-field"));
        String input = ((TextField) ScreenController.getScene("array average").lookup("#input-field")).getText();
        try {
            int num = Integer.parseInt(input);
            numbers.add(num);
            ((TextField) ScreenController.getScene("array average").lookup("#input-field")).clear();
            updateArrayDisplay(event);
            recalculateAverage();
        } catch (Exception e) {
        }
    }

    private void updateArrayDisplay(MouseEvent event) {
        ((Text) ScreenController.getScene("array average").lookup("#array-field")).setText(numbers.toString());
    }

    @FXML
    private void menuClicked(MouseEvent event) {
        noodle.Controller.goToPage(((Button) event.getSource()).getId());
    }
}

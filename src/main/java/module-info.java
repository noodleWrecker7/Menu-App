module Array.Menu.App {
//    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens noodle;
    exports noodle;

    opens noodle.arrayaverage;
    exports noodle.arrayaverage;

    opens noodle.search;
    exports noodle.search;

    opens noodle.minmax;
    exports noodle.minmax;

    opens noodle.dupes;
    exports noodle.dupes;

    opens noodle.evenodd;
    exports noodle.evenodd;

    opens noodle.position;
    exports noodle.position;
}
module Array.Menu.App {
//    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens adam;
    exports adam;

    opens adam.arrayaverage;
    exports adam.arrayaverage;

    opens adam.search;
    exports adam.search;

    opens adam.minmax;
    exports adam.minmax;

    opens adam.dupes;
    exports adam.dupes;

    opens adam.evenodd;
    exports adam.evenodd;

    opens adam.position;
    exports adam.position;
}
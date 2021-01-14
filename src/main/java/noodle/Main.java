package noodle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("test.csv");
//        InputStream fxmlinputstream = new FileInputStream("src/main/resources/sample.fxml");
        Parent root = new FXMLLoader().load(classloader.getResourceAsStream("sample.fxml"));

        Scene scene = new Scene(root);
        ScreenController.setRootScene(scene);

//        fxmlinputstream = new FileInputStream("src/main/resources/menu.fxml");
        ScreenController.addScreen("menu", new FXMLLoader().load(classloader.getResourceAsStream("menu.fxml")));

        InputStream fxmlinputstream = classloader.getResourceAsStream("array average.fxml");
        ScreenController.addScreen("array average", new FXMLLoader().load(fxmlinputstream));
        ScreenController.activate("menu");


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        System.out.println(primaryStage.getScene().lookup("array-field"));
        primaryStage.getScene().lookup("remove-btn");

    }


    public static void main(String[] args) {
        launch(args);
    }
}


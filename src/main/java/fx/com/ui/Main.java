package fx.com.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL resource = getClass().getResource("fxml/Main.fxml");
//        URL resource = getClass().getResource("");
//        System.out.println(resource);
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("Struts2检测工具");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

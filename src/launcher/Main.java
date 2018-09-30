package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * The application's primary stage
     */
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MyListedLibView.fxml"));
        Scene s = new Scene(root, 900, 900);
        s.getStylesheets().add("/css/MainView.css");

        primaryStage.getIcons().add(new Image(getClass().getResource("/images/icons/launcher/bookshelf_icon.png").toString()));
        primaryStage.setTitle("My Bookshelf");
        primaryStage.setScene(s);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BuzzApp extends Application {
    /**
     * The Application starts from here.
     * Here we create the stage.
     * @param primaryStage The Stage
     * @throws Exception Throw exception if BuzzMenu.fxml can't be loaded
     * @author Giannis Anthoulis 2966
     * @author Alexandros Seremetas Mpildiris 3245
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Stage
        primaryStage=new Stage();
        primaryStage.setTitle("Buzz! Quiz World");
        //Max Size
        primaryStage.setMaxWidth(1080);
        primaryStage.setMaxHeight(920);
        //Min Size
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.show();
        //
        primaryStage.setOnCloseRequest(windowEvent ->
        {
            Platform.exit();
            System.exit(0);
        });
        //Menu Scene
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("resources/BuzzMenu.fxml"));
        Parent   root = loader.load();
        Scene menu = new Scene(root);
        primaryStage.setScene(menu);
    }
}


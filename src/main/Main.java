package main;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @Gorana Matuh
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage){
        try {
            URL fxmlUrl = getClass().getClassLoader().getResource("fxml/in_fxml.fxml");
            HBox root = FXMLLoader.<HBox>load(fxmlUrl);
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

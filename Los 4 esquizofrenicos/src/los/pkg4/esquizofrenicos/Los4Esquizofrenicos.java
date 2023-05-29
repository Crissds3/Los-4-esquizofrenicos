 package los.pkg4.esquizofrenicos;

import static java.awt.Toolkit.getDefaultToolkit;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Los4Esquizofrenicos extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        float escalaX = getDefaultToolkit().getScreenSize().width/1920f;
        float escalaY = getDefaultToolkit().getScreenSize().height/1080f;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInterfazMenu.fxml"));
        
        float ancho = escalaX*1100;
        float altura = escalaY*1020;
        Scene scene = new Scene(root, ancho, altura);
  
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

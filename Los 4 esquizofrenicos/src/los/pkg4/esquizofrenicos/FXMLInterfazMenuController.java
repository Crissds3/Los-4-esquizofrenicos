/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los.pkg4.esquizofrenicos;

import static java.awt.Toolkit.getDefaultToolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yanko
 */
public class FXMLInterfazMenuController implements Initializable {

    @FXML
    private AnchorPane myAnchorPane;
    @FXML
    private Button insert;
    @FXML
    private Button bubble;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        float escalaX = getDefaultToolkit().getScreenSize().width/1920f;
        float escalaY = getDefaultToolkit().getScreenSize().height/1080f;
        myAnchorPane.setScaleX(escalaX);
        myAnchorPane.setScaleY(escalaY);

        if(getDefaultToolkit().getScreenSize().width != 1920){
            if(getDefaultToolkit().getScreenSize().width <=1400 && getDefaultToolkit().getScreenSize().width >1300) myAnchorPane.setLayoutX(-130);
            else if(getDefaultToolkit().getScreenSize().width <=1300) myAnchorPane.setLayoutX(-140);
            else myAnchorPane.setLayoutX(-240);
            myAnchorPane.setLayoutY(-130);
        }
    }    

    @FXML
    private void cambiarInsertSort(ActionEvent event) throws IOException {
        FXMLInterfazController.sel=1;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInterfaz.fxml")); 
        Parent root = loader.load();
        Scene scene = new Scene(root,getDefaultToolkit().getScreenSize().width,getDefaultToolkit().getScreenSize().height);  
        Stage stage = new Stage();
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void cambiarBubbleSort(ActionEvent event) throws IOException {
         FXMLInterfazController.sel=2;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInterfaz.fxml")); 
        Parent root = loader.load();
        Scene scene = new Scene(root,getDefaultToolkit().getScreenSize().width,getDefaultToolkit().getScreenSize().height);  
        Stage stage = new Stage();
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.show();
    }
    
     @FXML
    private void cambiarCockTailSort(ActionEvent event) throws IOException {
         FXMLInterfazController.sel=3;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInterfaz.fxml")); 
        Parent root = loader.load();
        Scene scene = new Scene(root,getDefaultToolkit().getScreenSize().width,getDefaultToolkit().getScreenSize().height);  
        Stage stage = new Stage();
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.show();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los.pkg4.esquizofrenicos;

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
        // TODO
    }    

    @FXML
    private void cambiarInsertSort(ActionEvent event) throws IOException {
        //Node nodo = (Node) event.getSource();
        //Stage stage = (Stage) nodo.getScene().getWindow();  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInterfaz.fxml")); 
        Parent root = loader.load();
        FXMLInterfazController controlador = loader.getController();
        controlador.setSel(1);
        
        Scene scene = new Scene(root);  
        
        Stage stage = new Stage();
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void cambiarBubbleSort(ActionEvent event) {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los.pkg4.esquizofrenicos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FXMLInterfazController implements Initializable {

    @FXML
    private AnchorPane myAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Rectangulo[] r = new Rectangulo[16];
        Rectangle[] rec = new Rectangle[16];
        Label[] numeros = new Label[16]; 
        StackPane paneLabel;
        //Crea los label
        for (int i = 0; i < 16; i++) {
            numeros[i] = new Label();
            numeros[i].setTranslateY(700);
            numeros[i].setTranslateX(360+i*80);
            numeros[i].setLayoutX(50);
            numeros[i].setLayoutY(50);
            numeros[i].setTextFill(Color.WHITE);
            numeros[i].setStyle("-fx-font-weight: bold");   
        }
        paneLabel = new StackPane(numeros);
        Group root2 = new Group(paneLabel);
        // Crea cuadrados
        for (int i = 0; i < 16; i++) {
           int numero = (int)(Math.random()*(99+1));
            r[i] = new Rectangulo(numero,60, 60, Color.GREEN);
            r[i].r.setTranslateY(676);
            r[i].r.setTranslateX(340+i*80);
            rec[i] = new Rectangle();
            rec[i] = r[i].r;
            numeros[i].setText(numero+"");
        }    
        
        StackPane pane = new StackPane(rec);
        Group root = new Group(pane);
        myAnchorPane.getChildren().add(root);
        myAnchorPane.getChildren().add(root2);
    }    
 
    void sort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = key;
        }
    }
}

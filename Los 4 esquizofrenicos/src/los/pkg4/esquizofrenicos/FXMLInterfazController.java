/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los.pkg4.esquizofrenicos;

import static java.lang.System.gc;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FXMLInterfazController implements Initializable {

    @FXML
    private AnchorPane myAnchorPane;
    
    @FXML
    protected GraphicsContext gc;
    
    @FXML
    protected Canvas lienzo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = lienzo.getGraphicsContext2D();
        DibujarNumeros dibujar = new DibujarNumeros();
        dibujar.dibujar(gc);
        Rectangulo[] r = new Rectangulo[16];
        Rectangle[] rec = new Rectangle[16];
        Label[] numeros = new Label[16]; 
 
        //Crea los label
        for (int i = 0; i < 16; i++) {
            numeros[i] = new Label();
            numeros[i].setTranslateY(715);
            numeros[i].setTranslateX(360+i*80);
            numeros[i].setLayoutX(50);
            numeros[i].setLayoutY(50);
            numeros[i].setTextFill(Color.WHITE);
            numeros[i].setStyle("-fx-font-weight: bold");   
        }
        StackPane paneLabel = new StackPane(numeros);
        Group root2 = new Group(paneLabel);
        
        // Crea cuadrados
        for (int i = 0; i < 16; i++) {
           int numero = (int)(Math.random()*(99+1));
            r[i] = new Rectangulo(numero,60, 60, Color.GREEN);
            r[i].r.setTranslateY(689);
            r[i].r.setTranslateX(340+i*80);
            rec[i] = new Rectangle();
            rec[i] = r[i].r;
            numeros[i].setText(numero+"");
        }    
        StackPane pane = new StackPane(rec);
        Group root = new Group(pane);
        
        
        myAnchorPane.getChildren().add(root);
        myAnchorPane.getChildren().add(root2);

        sort(r,numeros);
    }    
   
    void sort(Rectangulo arr[], Label numeros[]){
        float vel = 1f;
        int n = arr.length;
        Label labelAux = new Label();
        Rectangulo aux = new Rectangulo();
        SequentialTransition sequentialTransition = new SequentialTransition(); 
        SequentialTransition sequentialTransition2 = new SequentialTransition(); 
        SequentialTransition sequentialTransition3 = new SequentialTransition(); 
        SequentialTransition sequentialTransition4 = new SequentialTransition(); 
        
        //Insert Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i].valor;
            int j = i - 1;

            while (j >= 0 && arr[j].valor > key) {
                if(arr[j].valor > key){
                    Rectangle recMover = arr[j].r;
                    Rectangle recMover2 = arr[j+1].r;
                    Label labelMover = numeros[j];
                    Label labelMover2 = numeros[j+1];
                    
                    //Movimiento cajas
                    TranslateTransition ttUp = new TranslateTransition(Duration.seconds(vel), recMover);
                    TranslateTransition ttDown = new TranslateTransition(Duration.seconds(vel), recMover);
                    TranslateTransition ttRight = new TranslateTransition(Duration.seconds(vel), recMover);
                    TranslateTransition tt2Up = new TranslateTransition(Duration.seconds(vel), recMover2);
                    TranslateTransition tt2Down = new TranslateTransition(Duration.seconds(vel), recMover2);
                    TranslateTransition tt2Left = new TranslateTransition(Duration.seconds(vel), recMover2);
                    ttUp.setByY(-400);
                    ttRight.setByX(80);
                    ttDown.setByY(400);
                    tt2Up.setByY(-320);
                    tt2Left.setByX(-80);
                    tt2Down.setByY(320);
                    sequentialTransition.getChildren().add(ttUp);
                    sequentialTransition.getChildren().add(ttRight);
                    sequentialTransition.getChildren().add(ttDown);
                    sequentialTransition2.getChildren().add(tt2Up);
                    sequentialTransition2.getChildren().add(tt2Left);
                    sequentialTransition2.getChildren().add(tt2Down);
                    
                    //Movimiento numeros label
                    TranslateTransition ttNUp = new TranslateTransition(Duration.seconds(vel), labelMover);
                    TranslateTransition ttNDown = new TranslateTransition(Duration.seconds(vel), labelMover);
                    TranslateTransition ttNRight = new TranslateTransition(Duration.seconds(vel), labelMover);
                    TranslateTransition ttN2Up = new TranslateTransition(Duration.seconds(vel), labelMover2);
                    TranslateTransition tt2NDown = new TranslateTransition(Duration.seconds(vel), labelMover2);
                    TranslateTransition tt2NLeft = new TranslateTransition(Duration.seconds(vel), labelMover2);
                    ttNUp.setByY(-400);
                    ttNRight.setByX(80);
                    ttNDown.setByY(400);
                    ttN2Up.setByY(-320);
                    tt2NLeft.setByX(-80);
                    tt2NDown.setByY(320);
                    sequentialTransition3.getChildren().add(ttNUp);
                    sequentialTransition3.getChildren().add(ttNRight);
                    sequentialTransition3.getChildren().add(ttNDown);
                    sequentialTransition4.getChildren().add(ttN2Up);
                    sequentialTransition4.getChildren().add(tt2NLeft);
                    sequentialTransition4.getChildren().add(tt2NDown);          
                }
                //swap cajas
                aux.setR(arr[j + 1].getR());
                arr[j + 1].setValor(arr[j].getValor());
                arr[j + 1].setR(arr[j].getR());
                arr[j].setR(aux.getR());
                
                //swap label
                labelAux = numeros[j+1];
                numeros[j+1] = numeros[j];
                numeros[j] = labelAux;
          
                j--;
            }
            arr[j + 1].setValor(key);
        }
        sequentialTransition.play();
        sequentialTransition2.play();
        sequentialTransition3.play();
        sequentialTransition4.play();
    }
}

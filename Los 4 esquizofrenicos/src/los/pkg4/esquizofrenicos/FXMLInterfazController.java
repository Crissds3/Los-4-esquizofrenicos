/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los.pkg4.esquizofrenicos;

import static java.lang.System.gc;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
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
    protected GraphicsContext dib;
    
    @FXML
    protected Canvas lienzo;
    

    private Canvas canvasGrua;
    private Canvas canvasGrua2;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        dib= lienzo.getGraphicsContext2D();
        DibujarGrua dibujar =  new DibujarGrua();
        DibujarGrua dibujar2 =  new DibujarGrua();
 
        Rectangulo[] r = new Rectangulo[16];
        
        // Crea cuadrados
        StackPane pane = new StackPane();
        for (int i = 0; i < 16; i++) {
           int numero = (int)(Math.random()*(99+1));
            r[i] = new Rectangulo(numero,60, 60, Color.GREEN);
            r[i].r.setTranslateY(595);
            r[i].r.setTranslateX(340+i*80);
            pane.getChildren().add(r[i].r);

        }    
        
        canvasGrua = new Canvas(150, 250);
        GraphicsContext gc = canvasGrua.getGraphicsContext2D();
        canvasGrua.setTranslateX(700);
        canvasGrua.setTranslateY(164);
        dibujar.dibujar(gc,25,0);
        canvasGrua2 = new Canvas(150, 250);
        GraphicsContext gc2 = canvasGrua2.getGraphicsContext2D();
        canvasGrua2.setTranslateX(900);
        canvasGrua2.setTranslateY(164);
        dibujar2.dibujar(gc2,25,0);
        pane.getChildren().add(canvasGrua);
        pane.getChildren().add(canvasGrua2);

        Group root = new Group(pane);
        
         dibujar.dibujarCuerda(975,215);
         KeyValue keyValue = new KeyValue(dibujar.cuerda.endYProperty(), 400);
         KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);
         Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
       
        
        dibujar2.dibujarCuerda(775,215);
         KeyValue keyValue2 = new KeyValue(dibujar2.cuerda.endYProperty(), 400);
         KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(1), keyValue2);
        timeline.getKeyFrames().add(keyFrame2);
        timeline.play();
        
       
        myAnchorPane.getChildren().add(root);
 
        myAnchorPane.getChildren().add(dibujar.cuerda);
         myAnchorPane.getChildren().add(dibujar2.cuerda);


        insertSort(r);
    }    
   
    void insertSort(Rectangulo arr[]){
        float vel = 1f;
        int n = arr.length;
        
        Rectangulo aux = new Rectangulo();
        SequentialTransition sequentialTransition = new SequentialTransition(); 
        SequentialTransition sequentialTransition2 = new SequentialTransition(); 
        
        //Insert Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i].valor;
            int j = i - 1;

            while (j >= 0 && arr[j].valor > key) {
                if(arr[j].valor > key){
                    Canvas recMover = arr[j].r;
                    Canvas recMover2 = arr[j+1].r;
                    
                    //Movimiento cajas
                    sequentialTransition = moverCajaDerecha(sequentialTransition, recMover);
                    sequentialTransition2 = moverCajaIzquierda(sequentialTransition2, recMover2);        
                           
                }
                //swap cajas
                aux.setR(arr[j + 1].getR());
                arr[j + 1].setValor(arr[j].getValor());
                arr[j + 1].setR(arr[j].getR());
                arr[j].setR(aux.getR());   
                j--;
            }
            arr[j + 1].setValor(key);
        }
        sequentialTransition.play();
        sequentialTransition2.play();
    }
    
    SequentialTransition moverCajaDerecha(SequentialTransition sequentialTransition, Canvas recMover){
        float vel = 0.5f;
        TranslateTransition ttUp = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttDown = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttRight = new TranslateTransition(Duration.seconds(vel), recMover);
        ttUp.setByY(-400);
        ttRight.setByX(80);
        ttDown.setByY(400);
        sequentialTransition.getChildren().add(ttUp);
        sequentialTransition.getChildren().add(ttRight);
        sequentialTransition.getChildren().add(ttDown);
        return sequentialTransition;
    }
    
    SequentialTransition moverCajaIzquierda(SequentialTransition sequentialTransition, Canvas recMover){
        float vel = 0.5f;
        TranslateTransition ttUp = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttDown = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttLeft = new TranslateTransition(Duration.seconds(vel), recMover);
        ttUp.setByY(-320);
        ttLeft.setByX(-80);
        ttDown.setByY(320);
        sequentialTransition.getChildren().add(ttUp);
        sequentialTransition.getChildren().add(ttLeft);
        sequentialTransition.getChildren().add(ttDown);  
        return sequentialTransition;
    }
}

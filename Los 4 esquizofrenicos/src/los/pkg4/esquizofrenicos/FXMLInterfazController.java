package los.pkg4.esquizofrenicos;

import static java.lang.System.gc;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FXMLInterfazController implements Initializable {
    
    @FXML
    private AnchorPane myAnchorPane;
    @FXML
    private Button pausa;
    @FXML
    private Button res;
    @FXML
    private Slider velocidad;
    @FXML
    private Button resetear;
    @FXML
    private Button anterior;
    
    float vel;
    private Canvas canvasGruaBase;
    private Canvas canvasGruaBase2;
    private Canvas canvasGruaIman;
    private Canvas canvasGruaIman2;
    SequentialTransition sequentialTransition;
    SequentialTransition sequentialTransition2;
    ParallelTransition pt;
    ParallelTransition pt2;  
    DibujarGrua dibujar;
    DibujarGrua dibujar2;
    
    ParallelTransition colorChange;
    ParallelTransition colorChange2;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label3;
    @FXML
    private Label label8;
    @FXML
    private Label valorN;
    @FXML
    private Label valorI;
    @FXML
    private Label valorKey;
    @FXML
    private Label valorJ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        velocidad.setMin(0.01);
        velocidad.setMax(3.0);
        velocidad.setValue(1);
        vel = (float) velocidad.getValue();

        velocidad.setOnMouseDragged(event -> {
            float value = (float) velocidad.getValue();
            sequentialTransition.setRate(value);
            sequentialTransition2.setRate(value);
        });

        dibujar = new DibujarGrua();
        dibujar2 = new DibujarGrua();

        Rectangulo[] r = new Rectangulo[16];

        // Crea cuadrados
        StackPane pane = new StackPane();
        for (int i = 0; i < 16; i++) {
            int numero = (int) (Math.random() * (99 + 1));
            r[i] = new Rectangulo(numero, 60, 60, Color.GREEN);
            r[i].r.setTranslateY(689);
            r[i].r.setTranslateX(125 + i * 80);
            pane.getChildren().add(r[i].r);
        }
        canvasGruaBase = new Canvas(150, 50);
        canvasGruaIman = new Canvas(150, 60);
        GraphicsContext gcBase = canvasGruaBase.getGraphicsContext2D();        
        GraphicsContext gcIman = canvasGruaIman.getGraphicsContext2D();

        canvasGruaBase.setTranslateX(700);
        canvasGruaBase.setTranslateY(158);
        canvasGruaIman.setTranslateX(700);
        canvasGruaIman.setTranslateY(310); 
        dibujar.dibujarBase(gcBase, 40, 0);
        dibujar.dibujarIman(gcIman, 75, 0);
        
        canvasGruaBase2 = new Canvas(150, 50);
        canvasGruaIman2 = new Canvas(150, 60);
        GraphicsContext gcBase2 = canvasGruaBase2.getGraphicsContext2D();
        GraphicsContext gcIman2 = canvasGruaIman2.getGraphicsContext2D();
        canvasGruaBase2.setTranslateX(900);
        canvasGruaBase2.setTranslateY(158);
        canvasGruaIman2.setTranslateX(900);
        canvasGruaIman2.setTranslateY(310);
        dibujar2.dibujarBase(gcBase2, 40, 0);
        dibujar2.dibujarIman(gcIman2, 75, 0);

        pane.getChildren().add(canvasGruaBase);
        pane.getChildren().add(canvasGruaBase2);
        pane.getChildren().add(canvasGruaIman);
        pane.getChildren().add(canvasGruaIman2);

        Group root = new Group(pane);

        dibujar.dibujarCuerda(775, 215);
        dibujar2.dibujarCuerda(975, 215);
        
        root.getChildren().add(velocidad);
        root.getChildren().add(dibujar.cuerda);
        root.getChildren().add(dibujar2.cuerda);
        myAnchorPane.getChildren().add(root);
        
        insertSort(r);
        sequentialTransition.play();
        sequentialTransition2.play();
    }

    void insertSort(Rectangulo arr[]) {
        colorChange = new ParallelTransition();
        colorChange2 = new ParallelTransition();
        sequentialTransition = new SequentialTransition();
        sequentialTransition2 = new SequentialTransition();
        int n = arr.length;
        pintaLinea(label1);
        valorN.setText(n+"");
        ParallelTransition movimientoCuerda = new ParallelTransition(dibujar.cuerda);
        ParallelTransition movimientoCuerda2 = new ParallelTransition(dibujar2.cuerda);
        
        Rectangulo aux = new Rectangulo();

        //Insert Sort
        for (int i = 1; i < n; i++) {
            pintaLinea(label2);
            actualizaContador(valorI,i);
            
            int key = arr[i].valor;
            pintaLinea(label3);
            actualizaContador(valorKey,key);
            
            int j = i - 1;
            pintaLinea(label4);
            actualizaContador(valorJ,j);
            
            while (j >= 0 && arr[j].valor > key) {
                pintaLinea(label5);
                
                colorChange = new ParallelTransition(label6);
                colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label6.styleProperty(), "-fx-background-color: #13bf38;"))));
                sequentialTransition.getChildren().add(colorChange);
                sequentialTransition2.getChildren().add(colorChange);
                Canvas recMover = arr[j].r;
                Canvas recMover2 = arr[j + 1].r;
                TranslateTransition posicionBase = new TranslateTransition(Duration.seconds(vel/2), canvasGruaBase);
                TranslateTransition posicionIman = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);
                TranslateTransition posicionBase2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaBase2);
                TranslateTransition posicionIman2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman2);
                TranslateTransition posicionCuerda = new TranslateTransition(Duration.seconds(vel/2), dibujar.cuerda);   
                TranslateTransition posicionCuerda2 = new TranslateTransition(Duration.seconds(vel/2), dibujar2.cuerda);   

                posicionBase.setToX(125+j*80);
                posicionIman.setToX(125+j*80);
                posicionCuerda.setToX(125+j*80 -700);
                posicionBase2.setToX(125+(j+1)*80);
                posicionIman2.setToX(125+(j+1)*80);
                posicionCuerda2.setToX(125+(j+1)*80 - 900);
                pt = new ParallelTransition(posicionBase,posicionIman,posicionCuerda);
                pt2 = new ParallelTransition(posicionBase2,posicionIman2,posicionCuerda2);
                sequentialTransition.getChildren().add(pt);
                sequentialTransition2.getChildren().add(pt2);

                TranslateTransition ttImanDown = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);   
                TranslateTransition ttImanDown2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman2);   
                ttImanDown.setToY(630);
                ttImanDown2.setToY(630);

                movimientoCuerda.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/2),new KeyValue(dibujar.cuerda.endYProperty(),630))));
                movimientoCuerda2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/2),new KeyValue(dibujar2.cuerda.endYProperty(),630)))); 
                pt = new ParallelTransition(movimientoCuerda,ttImanDown);
                pt2 = new ParallelTransition(movimientoCuerda2,ttImanDown2);

                sequentialTransition.getChildren().add(pt);
                sequentialTransition2.getChildren().add(pt2);

                //Movimiento cajas
                moverCajaIzquierda(recMover);
                moverCajaDerecha(recMover2);

                TranslateTransition subirIman = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);     
                TranslateTransition subirIman2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman2);
                ParallelTransition subirCuerda = new ParallelTransition(dibujar.cuerda);
                ParallelTransition subirCuerda2 = new ParallelTransition(dibujar.cuerda);

                subirIman.setToY(310);
                subirIman2.setToY(310);
                subirCuerda.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/2),new KeyValue(dibujar.cuerda.endYProperty(), 310))));
                subirCuerda2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/2),new KeyValue(dibujar2.cuerda.endYProperty(), 310)))); 

                pt = new ParallelTransition(subirIman,subirCuerda);
                pt2 = new ParallelTransition(subirIman2,subirCuerda2);
                sequentialTransition.getChildren().add(pt);
                sequentialTransition2.getChildren().add(pt2);
                colorChange2 = new ParallelTransition(label6);
                colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label6.styleProperty(), "-fx-background-color: #ffffff;"))));
                sequentialTransition.getChildren().add(colorChange2);
                sequentialTransition2.getChildren().add(colorChange2);
                
                //swap cajas
                aux.setR(arr[j + 1].getR());
                arr[j + 1].setValor(arr[j].getValor());
                arr[j + 1].setR(arr[j].getR());
                arr[j].setR(aux.getR());
                j--;
                pintaLinea(label7);
                actualizaContador(valorJ,j);
            }
            
            arr[j + 1].setValor(key);
            pintaLinea(label8);
        }

    }

    void moverCajaIzquierda(Canvas recMover) {
        TranslateTransition ttUp = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttDown = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttRight = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttImanUp = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttImanRight = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttImanDown = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttBaseRight = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttCuerdaRight = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        ParallelTransition subirCuerda = new ParallelTransition(dibujar.cuerda);
        ParallelTransition bajarCuerda = new ParallelTransition(dibujar.cuerda);
        
        ttUp.setByY(-400);
        ttRight.setByX(80);
        ttDown.setByY(400);
        ttImanUp.setByY(-400);
        ttImanRight.setByX(80);
        ttImanDown.setByY(400);
        ttBaseRight.setByX(80);
        ttCuerdaRight.setByX(80);
        subirCuerda.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel),new KeyValue(dibujar.cuerda.endYProperty(), 230))));
        bajarCuerda.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel),new KeyValue(dibujar.cuerda.endYProperty(), 630))));
         
        pt = new ParallelTransition(ttUp,ttImanUp,subirCuerda);
        sequentialTransition.getChildren().add(pt);
        pt = new ParallelTransition(ttRight,ttImanRight,ttBaseRight,ttCuerdaRight);
        sequentialTransition.getChildren().add(pt);
        pt = new ParallelTransition(ttDown,ttImanDown,bajarCuerda);
        sequentialTransition.getChildren().add(pt);
    }

    void moverCajaDerecha(Canvas recMover) {
        TranslateTransition ttUp = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttDown = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttLeft = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttImanUp = new TranslateTransition(Duration.seconds(vel), canvasGruaIman2);
        TranslateTransition ttImanLeft = new TranslateTransition(Duration.seconds(vel), canvasGruaIman2);
        TranslateTransition ttImanDown = new TranslateTransition(Duration.seconds(vel), canvasGruaIman2);
        TranslateTransition ttBaseLeft = new TranslateTransition(Duration.seconds(vel), canvasGruaBase2);
        TranslateTransition ttCuerdaLeft = new TranslateTransition(Duration.seconds(vel), dibujar2.cuerda);
        ParallelTransition subirCuerda = new ParallelTransition(dibujar2.cuerda);
        ParallelTransition bajarCuerda = new ParallelTransition(dibujar2.cuerda);
        
        ttUp.setByY(-320);
        ttLeft.setByX(-80);
        ttDown.setByY(320);
        ttImanUp.setByY(-320);
        ttImanLeft.setByX(-80);
        ttImanDown.setByY(320);
        ttBaseLeft.setByX(-80);
        ttCuerdaLeft.setByX(-80);
        subirCuerda.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel),new KeyValue(dibujar2.cuerda.endYProperty(), 310))));
        bajarCuerda.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel),new KeyValue(dibujar2.cuerda.endYProperty(), 630))));

        pt2 = new ParallelTransition(ttUp,ttImanUp,subirCuerda);
        sequentialTransition2.getChildren().add(pt2);
        pt2 = new ParallelTransition(ttLeft,ttImanLeft,ttBaseLeft,ttCuerdaLeft);
        sequentialTransition2.getChildren().add(pt2);
        pt2 = new ParallelTransition(ttDown,ttImanDown,bajarCuerda);
        sequentialTransition2.getChildren().add(pt2);
    }
    
    void pintaLinea(Label label){
        colorChange = new ParallelTransition(label);
        colorChange2 = new ParallelTransition(label);
        colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.styleProperty(), "-fx-background-color: #13bf38;"))));
        colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.styleProperty(), "-fx-background-color: #ffffff;"))));
        sequentialTransition.getChildren().add(colorChange);
        sequentialTransition.getChildren().add(colorChange2);
        sequentialTransition2.getChildren().add(colorChange);
        sequentialTransition2.getChildren().add(colorChange2);
    }
        
    void actualizaContador(Label label, int valor){
        ParallelTransition ptValor = new ParallelTransition(label);
        ptValor.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.textProperty(), valor+""))));
        sequentialTransition.getChildren().add(ptValor);
        sequentialTransition2.getChildren().add(ptValor);
    }
        
    @FXML
    private void pausar(ActionEvent event) {
        sequentialTransition.pause();
        sequentialTransition2.pause();
    }

    @FXML
    private void resumir(ActionEvent event) {
        sequentialTransition.play();
        sequentialTransition2.play();
    }

    @FXML
    private void resetea(ActionEvent event) {
        sequentialTransition.jumpTo(Duration.ZERO);
        sequentialTransition2.jumpTo(Duration.ZERO);
    }

    @FXML
    private void pasoAnterior(ActionEvent event) {
    }
}

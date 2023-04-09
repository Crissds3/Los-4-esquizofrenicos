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

    float vel;

    protected GraphicsContext dib;

    @FXML
    protected Canvas lienzo;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        velocidad.setMin(0.01);

        // Establecer valor máximo
        velocidad.setMax(3.0);

        // Establecer valor inicial
        velocidad.setValue(1);
        vel = (float) velocidad.getValue();

        velocidad.setOnMouseDragged(event -> {
            float value = (float) velocidad.getValue();
            sequentialTransition.setRate(value);
            sequentialTransition2.setRate(value);
        });

        dib = lienzo.getGraphicsContext2D();
        dibujar = new DibujarGrua();
        dibujar2 = new DibujarGrua();

        Rectangulo[] r = new Rectangulo[16];

        // Crea cuadrados
        StackPane pane = new StackPane();
        for (int i = 0; i < 16; i++) {
            int numero = (int) (Math.random() * (99 + 1));
            r[i] = new Rectangulo(numero, 60, 60, Color.GREEN);
            r[i].r.setTranslateY(689);
            r[i].r.setTranslateX(340 + i * 80);
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
        dibujar.dibujarBase(gcBase, 25, 0);
        dibujar.dibujarIman(gcIman, 75, 0);
        //gcIman.setFill(Color.RED);
        //gcIman.fillRect(0, 0, 150, 60);

        canvasGruaBase2 = new Canvas(150, 50);
        canvasGruaIman2 = new Canvas(150, 60);
        GraphicsContext gcBase2 = canvasGruaBase2.getGraphicsContext2D();
        GraphicsContext gcIman2 = canvasGruaIman2.getGraphicsContext2D();
        canvasGruaBase2.setTranslateX(900);
        canvasGruaBase2.setTranslateY(158);
        canvasGruaIman2.setTranslateX(900);
        canvasGruaIman2.setTranslateY(310);
        dibujar2.dibujarBase(gcBase2, 25, 0);
        dibujar2.dibujarIman(gcIman2, 75, 0);
        //gcIman2.setFill(Color.RED);
        //gcIman2.fillRect(0, 0, 150, 60);

        pane.getChildren().add(canvasGruaBase);
        pane.getChildren().add(canvasGruaBase2);
        pane.getChildren().add(canvasGruaIman);
        pane.getChildren().add(canvasGruaIman2);

        Group root = new Group(pane);

        dibujar.dibujarCuerda(775, 215);
        KeyValue keyValue = new KeyValue(dibujar.cuerda.endYProperty(), 400);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);

        dibujar2.dibujarCuerda(975, 215);
        KeyValue keyValue2 = new KeyValue(dibujar2.cuerda.endYProperty(), 400);
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(1), keyValue2);
        timeline.getKeyFrames().add(keyFrame2);
        timeline.play();

        root.getChildren().add(velocidad);
        myAnchorPane.getChildren().add(root);
        myAnchorPane.getChildren().add(dibujar.cuerda);
        myAnchorPane.getChildren().add(dibujar2.cuerda);

        insertSort(r);
        sequentialTransition.play();
        sequentialTransition2.play();
    }

    void insertSort(Rectangulo arr[]) {
        int n = arr.length;

        Rectangulo aux = new Rectangulo();
        sequentialTransition = new SequentialTransition();
        sequentialTransition2 = new SequentialTransition();
        TranslateTransition ttGruaBase = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttGruaIman = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttGruaBase2 = new TranslateTransition(Duration.seconds(vel), canvasGruaBase2);
        TranslateTransition ttGruaIman2 = new TranslateTransition(Duration.seconds(vel), canvasGruaIman2);
        TranslateTransition ttCuerda = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        TranslateTransition ttCuerda2 = new TranslateTransition(Duration.seconds(vel), dibujar2.cuerda);
        
        ttGruaBase.setToX(arr[0].r.getTranslateX());
        ttGruaBase2.setToX(arr[1].r.getTranslateX());
        ttGruaIman.setToX(arr[0].r.getTranslateX());
        ttGruaIman2.setToX(arr[1].r.getTranslateX());
        ttCuerda.setToX(arr[0].r.getTranslateX()-700);
        ttCuerda2.setToX(arr[1].r.getTranslateX()-900);
        
        pt = new ParallelTransition(ttGruaBase, ttGruaIman,ttCuerda);
        pt2 = new ParallelTransition(ttGruaBase2, ttGruaIman2,ttCuerda2);
        
        sequentialTransition.getChildren().add(pt);
        sequentialTransition2.getChildren().add(pt2);
        
        
        //Insert Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i].valor;
            int j = i - 1;
            

            while (j >= 0 && arr[j].valor > key) {
                if (arr[j].valor > key) {
                    Canvas recMover = arr[j].r;
                    Canvas recMover2 = arr[j + 1].r;
                    TranslateTransition posicionBase = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
                    TranslateTransition posicionIman = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
                    TranslateTransition posicionBase2 = new TranslateTransition(Duration.seconds(vel), canvasGruaBase2);
                    TranslateTransition posicionIman2 = new TranslateTransition(Duration.seconds(vel), canvasGruaIman2);
                    TranslateTransition posicionCuerda = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);   
                    TranslateTransition posicionCuerda2 = new TranslateTransition(Duration.seconds(vel), dibujar2.cuerda);   
                    
                    posicionBase.setToX(340+j*80);
                    posicionIman.setToX(340+j*80);
                    posicionCuerda.setToX(340+j*80 -700);
                    posicionBase2.setToX(340+(j+1)*80);
                    posicionIman2.setToX(340+(j+1)*80);
                    posicionCuerda2.setToX(340+(j+1)*80 - 900);
                    pt = new ParallelTransition(posicionBase,posicionIman,posicionCuerda);
                    pt2 = new ParallelTransition(posicionBase2,posicionIman2,posicionCuerda2);
                    sequentialTransition.getChildren().add(pt);
                    sequentialTransition2.getChildren().add(pt2);
                    //Movimiento cajas
                    moverCajaIzquierda(recMover);
                    moverCajaDerecha(recMover2);

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

    }

    void moverCajaIzquierda(Canvas recMover) {
        TranslateTransition ttUp = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttDown = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttRight = new TranslateTransition(Duration.seconds(vel), recMover);
        ttUp.setByY(-400);
        ttRight.setByX(80);
        ttDown.setByY(400);
        sequentialTransition2.getChildren().add(ttUp);
        sequentialTransition2.getChildren().add(ttRight);
        sequentialTransition2.getChildren().add(ttDown);
    }

    void moverCajaDerecha(Canvas recMover) {
        TranslateTransition ttUp = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttDown = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttLeft = new TranslateTransition(Duration.seconds(vel), recMover);
        ttUp.setByY(-320);
        ttLeft.setByX(-80);
        ttDown.setByY(320);
        sequentialTransition.getChildren().add(ttUp);
        sequentialTransition.getChildren().add(ttLeft);
        sequentialTransition.getChildren().add(ttDown);
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

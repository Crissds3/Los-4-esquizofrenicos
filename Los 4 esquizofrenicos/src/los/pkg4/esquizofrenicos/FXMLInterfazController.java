package los.pkg4.esquizofrenicos;

import static java.lang.System.gc;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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

    private Canvas canvasGrua;
    private Canvas canvasGrua2;
    SequentialTransition sequentialTransition;
    SequentialTransition sequentialTransition2;

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
        DibujarGrua dibujar = new DibujarGrua();
        DibujarGrua dibujar2 = new DibujarGrua();

        Rectangulo[] r = new Rectangulo[16];

        // Crea cuadrados
        StackPane pane = new StackPane();
        for (int i = 0; i < 16; i++) {
            int numero = (int) (Math.random() * (99 + 1));
            r[i] = new Rectangulo(numero, 60, 60, Color.GREEN);
            r[i].r.setTranslateY(595);
            r[i].r.setTranslateX(340 + i * 80);
            pane.getChildren().add(r[i].r);

        }

        canvasGrua = new Canvas(150, 250);
        GraphicsContext gc = canvasGrua.getGraphicsContext2D();
        canvasGrua.setTranslateX(700);
        canvasGrua.setTranslateY(164);
        dibujar.dibujar(gc, 25, 0);
        canvasGrua2 = new Canvas(150, 250);
        GraphicsContext gc2 = canvasGrua2.getGraphicsContext2D();
        canvasGrua2.setTranslateX(900);
        canvasGrua2.setTranslateY(164);
        dibujar2.dibujar(gc2, 25, 0);
        pane.getChildren().add(canvasGrua);
        pane.getChildren().add(canvasGrua2);

        Group root = new Group(pane);

        dibujar.dibujarCuerda(975, 215);
        KeyValue keyValue = new KeyValue(dibujar.cuerda.endYProperty(), 400);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);

        dibujar2.dibujarCuerda(775, 215);
        KeyValue keyValue2 = new KeyValue(dibujar2.cuerda.endYProperty(), 400);
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(1), keyValue2);
        timeline.getKeyFrames().add(keyFrame2);
        timeline.play();

        myAnchorPane.getChildren().add(root);
        myAnchorPane.getChildren().add(dibujar.cuerda);
        myAnchorPane.getChildren().add(dibujar2.cuerda);

        Group botonPausa = new Group(pausa);
        Group botonResume = new Group(res);
        Group sliderVel = new Group(velocidad);
        Group botonReset = new Group(resetear);
        Group botonAnterior = new Group(anterior);

        myAnchorPane.getChildren().add(botonPausa);
        myAnchorPane.getChildren().add(botonResume);
        myAnchorPane.getChildren().add(botonReset);
        myAnchorPane.getChildren().add(botonAnterior);
        myAnchorPane.getChildren().add(sliderVel);

        insertSort(r);
        sequentialTransition.play();
        sequentialTransition2.play();
    }

    void insertSort(Rectangulo arr[]) {
        int n = arr.length;

        Rectangulo aux = new Rectangulo();
        sequentialTransition = new SequentialTransition();
        sequentialTransition2 = new SequentialTransition();

        //Insert Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i].valor;
            int j = i - 1;

            while (j >= 0 && arr[j].valor > key) {
                if (arr[j].valor > key) {
                    Canvas recMover = arr[j].r;
                    Canvas recMover2 = arr[j + 1].r;

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

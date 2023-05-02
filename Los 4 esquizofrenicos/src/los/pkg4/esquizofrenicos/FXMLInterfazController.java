package los.pkg4.esquizofrenicos;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
    private Button nuevoArreglo;
    
    float vel;
    public static int sel;
    private Canvas canvasRepisa;
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
    DibujarGrua dibujar3;
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
    @FXML
    private Label finalizado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("s: "+sel);
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
        dibujar3= new DibujarGrua();

        Rectangulo[] r = new Rectangulo[16];

        // Crea cuadrados
        StackPane pane = new StackPane();
        for (int i = 0; i < 16; i++) {
            int numero = (int) (Math.random() * (99 + 1));
            r[i] = new Rectangulo(numero, 60, 60, Color.GREEN);
            r[i].r.setTranslateY(675);
            r[i].r.setTranslateX(100 + i * 80);
            pane.getChildren().add(r[i].r);
        }
        canvasGruaBase = new Canvas(150, 50);
        canvasGruaIman = new Canvas(150, 60);
      
        dibujar.dibujarCuerda();
       
       
        GraphicsContext gcBase = canvasGruaBase.getGraphicsContext2D();    
        gcBase.setFill(Color.web("#acb2b0")); 
        gcBase.fillRect(40, 0, 70, 50);
     

        GraphicsContext gcIman = canvasGruaIman.getGraphicsContext2D();
        gcIman.setFill(Color.web("#fb273b"));
     
        dibujar.cuerda.setTranslateX(650);
        dibujar.cuerda.setTranslateY(-110);
        canvasGruaBase.setTranslateX(650);
        canvasGruaBase.setTranslateY(145);
        canvasGruaIman.setTranslateX(650);
        canvasGruaIman.setTranslateY(310); 
        dibujar.dibujarBase(gcBase, 40, 0);
        dibujar.dibujarIman(gcIman, 75, 0);
        
        
  

        pane.getChildren().add(canvasGruaBase);
        pane.getChildren().add(canvasGruaIman);
      //  pane.getChildren().add(canvasRepisa);

        Group root = new Group(pane);
        if(sel==1){
            dibujar2.dibujarCuerda();
            canvasGruaBase2 = new Canvas(150, 50);
            canvasGruaIman2 = new Canvas(150, 60);
            GraphicsContext gcBase2 = canvasGruaBase2.getGraphicsContext2D();
            GraphicsContext gcIman2 = canvasGruaIman2.getGraphicsContext2D();
            gcIman2.setFill(Color.web("#fb273b"));
            gcBase2.setFill(Color.web("#acb2b0")); 
            gcBase2.fillRect(40, 0, 70, 50);

            dibujar2.cuerda.setTranslateX(850);
            dibujar2.cuerda.setTranslateY(-110);
            canvasGruaBase2.setTranslateX(850);
            canvasGruaBase2.setTranslateY(145);
            canvasGruaIman2.setTranslateX(850);
            canvasGruaIman2.setTranslateY(310);
            dibujar2.dibujarBase(gcBase2, 40, 0);
            dibujar2.dibujarIman(gcIman2, 75, 0);
             pane.getChildren().add(canvasGruaBase2);
             pane.getChildren().add(canvasGruaIman2); 
             root.getChildren().add(dibujar2.cuerda);
        }else{
             canvasRepisa= new Canvas(300, 300); 
             GraphicsContext gcRepisa = canvasRepisa.getGraphicsContext2D(); 
             canvasRepisa.setTranslateY(200);
             canvasRepisa.setTranslateX(140);
             dibujar3.dibujarRepisa(gcRepisa, 0, 100);
             root.getChildren().add(canvasRepisa);
             
        }
        
        root.getChildren().add(dibujar.cuerda);
        
        myAnchorPane.getChildren().add(root);
        root.toBack();
        pane.toFront();
        Group root2 = new Group();
        root2.getChildren().add(velocidad);
        myAnchorPane.getChildren().add(root2);
        
        if(sel==1){
        insertSort(r);
        }else if(sel==2){
            bubbleSort(r);
        }
        sequentialTransition.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(finalizado.textProperty(), "Arreglo Ordenado"))));
        sequentialTransition.play();
       
        if(sel==1){
             sequentialTransition2.play();
        }
    }
    
    
    void insertSort(Rectangulo arr[]) {
        colorChange = new ParallelTransition();
        colorChange2 = new ParallelTransition();
        sequentialTransition = new SequentialTransition();
        sequentialTransition2 = new SequentialTransition();
        int n = arr.length;
        pintaLinea(label1);
        valorN.setText(n+"");

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

                posicionBase.setToX(100+j*80);
                posicionIman.setToX(100+j*80);
                posicionCuerda.setToX(100+j*80);
                posicionBase2.setToX(100+(j+1)*80);
                posicionIman2.setToX(100+(j+1)*80);
                posicionCuerda2.setToX(100+(j+1)*80);
                pt = new ParallelTransition(posicionBase,posicionIman,posicionCuerda);
                pt2 = new ParallelTransition(posicionBase2,posicionIman2,posicionCuerda2);
                sequentialTransition.getChildren().add(pt);
                sequentialTransition2.getChildren().add(pt2);

                TranslateTransition ttImanDown = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);   
                TranslateTransition ttImanDown2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman2); 
                TranslateTransition cuerdaDown = new TranslateTransition(Duration.seconds(vel/2), dibujar.cuerda);
                TranslateTransition cuerdaDown2 = new TranslateTransition(Duration.seconds(vel/2), dibujar2.cuerda);
                cuerdaDown.setToY(195);
                cuerdaDown2.setToY(195);
                ttImanDown.setToY(615);
                ttImanDown2.setToY(615);

                pt = new ParallelTransition(cuerdaDown,ttImanDown);
                pt2 = new ParallelTransition(cuerdaDown2,ttImanDown2);
                sequentialTransition.getChildren().add(pt);
                sequentialTransition2.getChildren().add(pt2);

                //Movimiento cajas
                moverCajaIzquierda(recMover);
                moverCajaDerecha(recMover2);

                TranslateTransition subirIman = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);     
                TranslateTransition subirIman2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman2);
                TranslateTransition cuerdaUp = new TranslateTransition(Duration.seconds(vel/2), dibujar.cuerda);
                TranslateTransition cuerdaUp2 = new TranslateTransition(Duration.seconds(vel/2), dibujar2.cuerda);
                
                subirIman.setToY(310);
                subirIman2.setToY(310);
                cuerdaUp.setToY(-110);
                cuerdaUp2.setToY(-110);

                pt = new ParallelTransition(subirIman,cuerdaUp);
                pt2 = new ParallelTransition(subirIman2,cuerdaUp2);
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

    
     void bubbleSort(Rectangulo[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n-i-1; j++) {

                if (arr[j].valor > arr[j+1].valor) {
                    Rectangulo temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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
        TranslateTransition cuerdaUp = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        TranslateTransition cuerdaDown = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        
        ttUp.setByY(-400);
        ttRight.setByX(80);
        ttDown.setByY(400);
        ttImanUp.setByY(-400);
        ttImanRight.setByX(80);
        ttImanDown.setByY(400);
        ttBaseRight.setByX(80);
        ttCuerdaRight.setByX(80);
        cuerdaDown.setByY(400);
        cuerdaUp.setByY(-400);
         
        pt = new ParallelTransition(ttUp,ttImanUp,cuerdaUp);
        sequentialTransition.getChildren().add(pt);
        pt = new ParallelTransition(ttRight,ttImanRight,ttBaseRight,ttCuerdaRight);
        sequentialTransition.getChildren().add(pt);
        pt = new ParallelTransition(ttDown,ttImanDown,cuerdaDown);
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
        TranslateTransition cuerdaUp = new TranslateTransition(Duration.seconds(vel), dibujar2.cuerda);
        TranslateTransition cuerdaDown = new TranslateTransition(Duration.seconds(vel), dibujar2.cuerda);
        
        ttUp.setByY(-320);
        ttLeft.setByX(-80);
        ttDown.setByY(320);
        ttImanUp.setByY(-320);
        ttImanLeft.setByX(-80);
        ttImanDown.setByY(320);
        ttBaseLeft.setByX(-80);
        ttCuerdaLeft.setByX(-80);
        cuerdaDown.setByY(320);
        cuerdaUp.setByY(-320);

        pt2 = new ParallelTransition(ttUp,ttImanUp,cuerdaUp);
        sequentialTransition2.getChildren().add(pt2);
        pt2 = new ParallelTransition(ttLeft,ttImanLeft,ttBaseLeft,ttCuerdaLeft);
        sequentialTransition2.getChildren().add(pt2);
        pt2 = new ParallelTransition(ttDown,ttImanDown,cuerdaDown);
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

    public void setSel(int sel) {
        this.sel = sel;
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
    private void nuevoArreglo(ActionEvent event) throws IOException {
        Stage stage = (Stage) nuevoArreglo.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInterfaz.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

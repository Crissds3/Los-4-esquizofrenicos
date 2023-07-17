package los.pkg4.esquizofrenicos;

import static java.awt.Toolkit.getDefaultToolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    Animaciones animacion = new Animaciones();
    AnimacionesVagon animacionVagon = new AnimacionesVagon();


    
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
    @FXML
    private ImageView contenedorImagen;
    @FXML
    private Label labelKey;
    @FXML
    private Label label9;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label14;
    @FXML
    private Label labelN;
    @FXML
    private Label labelI;
    @FXML
    private Label labelJ;
    @FXML
    private Button volver;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        float escalaX = getDefaultToolkit().getScreenSize().width/1920f;
        float escalaY = getDefaultToolkit().getScreenSize().height/1080f;
        
        velocidad.setMin(0.01);
        velocidad.setMax(10.0);
        velocidad.setValue(1);
        vel = (float) velocidad.getValue();
        animacion.vel = vel;
        animacionVagon.vel = vel;
        animacionVagon.velVagones = vel/80;
        velocidad.setOnMouseDragged(event -> {
            float value = (float) velocidad.getValue();
            animacion.sequentialTransition.setRate(value);
            if(sel==4) animacionVagon.sequentialTransition.setRate(value);
            if(sel==1) animacion.sequentialTransition2.setRate(value);
        });

        animacion.dibujar = new DibujarElemento();
        animacion.dibujar2 = new DibujarElemento();
        animacionVagon.dibujar = new DibujarElementosFerrocarril();
        Rectangulo[] r = new Rectangulo[16];
        Vagon[] v = new Vagon[16];
        


        // Crea cuadrados
        StackPane pane = new StackPane();
        for (int i = 0; i < 16; i++) {
            int numero = (int) (Math.random() * (99 + 1));
            r[i] = new Rectangulo(numero, 60, 60, Color.GREEN);
            r[i].r.setTranslateY(675);
            r[i].r.setTranslateX(100 + i * 80);
            pane.getChildren().add(r[i].r);
        }
        
        //Crea vagones 
        StackPane paneVagones = new StackPane();
        for (int i = 0; i < 16; i++) {
            int numero = (int) (Math.random()*(99+1));         
            v[i]= new Vagon(numero,60,40,Color.BLACK);
            v[i].v.setTranslateY(945);
            v[i].v.setTranslateX(260+i * 70);
            paneVagones.getChildren().add(v[i].v);
        }
        animacion.canvasGruaBase = new Canvas(150, 50);
        animacion.canvasGruaIman = new Canvas(150, 60);
      
        animacion.dibujar.dibujarCuerda();

        GraphicsContext gcBase = animacion.canvasGruaBase.getGraphicsContext2D();    
        gcBase.setFill(Color.web("#acb2b0")); 
        gcBase.fillRect(40, 0, 70, 50);

        GraphicsContext gcIman = animacion.canvasGruaIman.getGraphicsContext2D();
        gcIman.setFill(Color.web("#fb273b"));
     
        animacion.dibujar.cuerda.setTranslateX(650);
        animacion.dibujar.cuerda.setTranslateY(-110);
        animacion.canvasGruaBase.setTranslateX(650);
        animacion.canvasGruaBase.setTranslateY(145);
        animacion.canvasGruaIman.setTranslateX(650);
        animacion.canvasGruaIman.setTranslateY(310); 
        animacion.dibujar.dibujarBase(gcBase, 40, 0);
        animacion.dibujar.dibujarIman(gcIman, 75, 0);

        Group root;
        if(sel==1){
            root = new Group(pane);
            animacion.dibujar2.dibujarCuerda();
            animacion.canvasGruaBase2 = new Canvas(150, 50);
            animacion.canvasGruaIman2 = new Canvas(150, 60);
            GraphicsContext gcBase2 = animacion.canvasGruaBase2.getGraphicsContext2D();
            GraphicsContext gcIman2 = animacion.canvasGruaIman2.getGraphicsContext2D();
            gcIman2.setFill(Color.web("#fb273b"));
            gcBase2.setFill(Color.web("#acb2b0")); 
            gcBase2.fillRect(40, 0, 70, 50);

            animacion.dibujar2.cuerda.setTranslateX(850);
            animacion.dibujar2.cuerda.setTranslateY(-110);
            animacion.canvasGruaBase2.setTranslateX(850);
            animacion.canvasGruaBase2.setTranslateY(145);
            animacion.canvasGruaIman2.setTranslateX(850);
            animacion.canvasGruaIman2.setTranslateY(310);
            animacion.dibujar2.dibujarBase(gcBase2, 40, 0);
            animacion.dibujar2.dibujarIman(gcIman2, 75, 0);
            pane.getChildren().add(animacion.canvasGruaBase2);
            pane.getChildren().add(animacion.canvasGruaIman2); 
            root.getChildren().add(animacion.dibujar2.cuerda);
        }else if(sel==2 || sel ==3){
            root = new Group(pane);
            animacion.canvasRepisa= new Canvas(300, 300); 
            GraphicsContext gcRepisa = animacion.canvasRepisa.getGraphicsContext2D(); 
            animacion.canvasRepisa.setTranslateY(243);
            animacion.canvasRepisa.setTranslateX(140);
            animacion.dibujar.dibujarRepisa(gcRepisa, 0, 100);
            root.getChildren().add(animacion.canvasRepisa);
        }
        else{
            StackPane paneFerrocarriles = new StackPane();
            animacionVagon.dibujar.agregarLocomotora(2580, 945);
            animacionVagon.dibujar.agregarLocomotora2(2020, 830);
            paneFerrocarriles.getChildren().add(animacionVagon.dibujar.locomotora);
            paneFerrocarriles.getChildren().add(animacionVagon.dibujar.locomotora2);
            paneVagones.setScaleX(0.5);
            paneVagones.setScaleY(0.5);
            paneFerrocarriles.setScaleX(0.5);
            paneFerrocarriles.setScaleY(0.5);
            root = new Group(paneVagones);
            root.getChildren().add(paneFerrocarriles);
        }
        
        if (sel != 4) {
            pane.getChildren().add(animacion.canvasGruaBase);
            root.getChildren().add(animacion.canvasGruaIman);
            root.getChildren().add(animacion.dibujar.cuerda);
        
            myAnchorPane.getChildren().add(root);
            root.toBack();
            pane.toFront();       
        }
        else{
            myAnchorPane.getChildren().add(root);
        }
        
        Group root2 = new Group();
        root2.getChildren().add(velocidad);
        myAnchorPane.getChildren().add(root2);
        myAnchorPane.setScaleX(escalaX);
        myAnchorPane.setScaleY(escalaY);
        
        if(getDefaultToolkit().getScreenSize().width != 1920){
            if(getDefaultToolkit().getScreenSize().width <=1400 && getDefaultToolkit().getScreenSize().width >1300)  myAnchorPane.setLayoutX(-200);
            else if(getDefaultToolkit().getScreenSize().width <=1300) myAnchorPane.setLayoutX(-210);
            else myAnchorPane.setLayoutX(-240);
            if(getDefaultToolkit().getScreenSize().height >=800)
                myAnchorPane.setLayoutY(-130);
            else myAnchorPane.setLayoutY(-140);
        }
        
        switch (sel){
            case 1:
                insertSort(r);
                break;
            case 2:{
                Image image = new Image(getClass().getResourceAsStream("img/fondopruebaBubble.png"));
                contenedorImagen.setImage(image);
                bubbleSort(r);
                break;
            }
            case 3:{
                Image image = new Image(getClass().getResourceAsStream("img/fondopruebaCocktail.png"));
                contenedorImagen.setImage(image);
                cocktailSort(r);
                break;
            }
            case 4:{
                Image image = new Image(getClass().getResourceAsStream("img/fondopruebaSelectSort.png"));
                contenedorImagen.setImage(image);
                selectSort(v);
                break;
            }
            
            default:
                break;
        }
        if (sel != 4) {
            if(sel==1) animacion.sequentialTransition2.play();
            animacion.sequentialTransition.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(finalizado.textProperty(), "Arreglo Ordenado"))));
            animacion.sequentialTransition.play();  
        }
        else{
            animacionVagon.sequentialTransition.play();
        }

       
        
    }
   
    void insertSort(Rectangulo arr[]) {
        animacion.colorChange = new ParallelTransition();
        animacion.colorChange2 = new ParallelTransition();
        animacion.sequentialTransition = new SequentialTransition();
        int n = arr.length;
        animacion.pintaLinea(label1);
        valorN.setText(n+"");

        Rectangulo aux = new Rectangulo();

        //Insert Sort
        for (int i = 1; i < n; i++) {
            animacion.pintaLinea(label2);
            animacion.actualizaContador(valorI,i);
            
            int key = arr[i].valor;
            animacion.pintaLinea(label3);
            animacion.actualizaContador(valorKey,key);
            
            int j = i - 1;
            animacion.pintaLinea(label4);
            animacion.actualizaContador(valorJ,j);
            
            while (j >= 0 && arr[j].valor > key) {
                animacion.pintaLinea(label5);
                
                animacion.colorChange = new ParallelTransition(label6);
                animacion.colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label6.styleProperty(), "-fx-background-color: #13bf38;"))));
                animacion.sequentialTransition.getChildren().add(animacion.colorChange);
                animacion.sequentialTransition2.getChildren().add(animacion.colorChange);
                Canvas recMover = arr[j].r;
                Canvas recMover2 = arr[j + 1].r;
                animacion.posicionInicial(j);
                animacion.posicionInicial2(j+1);
                
                animacion.bajarGrua();
                animacion.bajarGrua2();

                //Movimiento cajas
                animacion.moverCajaIzquierda(recMover);
                animacion.moverCajaDerecha(recMover2);

                animacion.subirGrua();
                animacion.subirGrua2();

                animacion.colorChange2 = new ParallelTransition(label6);
                animacion.colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label6.styleProperty(), "-fx-background-color: #ffffff;"))));
                animacion.sequentialTransition.getChildren().add(animacion.colorChange2);
                animacion.sequentialTransition2.getChildren().add(animacion.colorChange2);
                
                //swap cajas
                aux.setR(arr[j + 1].getR());
                arr[j + 1].setValor(arr[j].getValor());
                arr[j + 1].setR(arr[j].getR());
                arr[j].setR(aux.getR());
                j--;
                animacion.pintaLinea(label7);
                animacion.actualizaContador(valorJ,j);
            }
            
            arr[j + 1].setValor(key);
            animacion.pintaLinea(label8);
        }
    }

     void bubbleSort(Rectangulo[] arr) {  
        //Mostrar codigo
        labelKey.setText("");
        label3.setText("        Para j = 1 hasta n-i-1");
        label4.setText("            Si arreglo[j] > arreglo[j+1]");
        label5.setText("                swap(arreglo[j+1],arreglo[j])");
        label6.setText("");
        label7.setText("");
        label8.setText("");
       
        animacion.colorChange = new ParallelTransition();
        animacion.colorChange2 = new ParallelTransition();
        animacion.sequentialTransition = new SequentialTransition();
        int n = arr.length;
        valorN.setText(n+"");
        animacion.pintaLinea(label1);
        
        for (int i = 0; i < n-1; i++) {
            boolean cambio = false;
            animacion.pintaLinea(label2);
            animacion.actualizaContador(valorI,i);
            for (int j = 0; j < n-i-1; j++) {
                animacion.pintaLinea(label3);
                animacion.actualizaContador(valorJ,j);
                Canvas recMover = arr[j].r;
                Canvas recMover2 = arr[j + 1].r;
     
                if (arr[j].valor > arr[j+1].valor) {
                    animacion.posicionInicial(j,cambio);
                    animacion.pintaLinea(label4);
                    animacion.colorChange = new ParallelTransition(label5);
                    animacion.colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label5.styleProperty(), "-fx-background-color: #13bf38;"))));
                    animacion.sequentialTransition.getChildren().add(animacion.colorChange);
                        
                    animacion.bajarGrua();
                    
                    //Movimiento cajas
                    animacion.moverCajas(recMover,recMover2,j,cambio);
                    
                    animacion.colorChange2 = new ParallelTransition(label5);
                    animacion.colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label5.styleProperty(), "-fx-background-color: #ffffff;"))));
                    animacion.sequentialTransition.getChildren().add(animacion.colorChange2);
                    Rectangulo temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    cambio = true;      
                    if(j == n-i-2){
                        animacion.mueveDesdeRepisa(recMover,recMover2,j+1);
                    }
                }
                else{
                    if(cambio){
                        animacion.mueveDesdeRepisa(recMover,recMover2,j);
                    }
                    cambio = false; 
                }
                     
            }
        }
    }
     
    void cocktailSort(Rectangulo arr[]){
        animacion.sequentialTransition = new SequentialTransition();
        //Mostrar codigo
        labelN.setText("swapped");
        labelJ.setText("inicio");
        labelKey.setText("fin");
        label1.setText("swapped=true, inicio=0, fin=lenght(arreglo)");
        label2.setText("    Mientras swapped == true");
        label3.setText("        swapped = false");
        label4.setText("        Para i = inicio hasta fin-1");
        label5.setText("            Si arreglo[j] > arreglo[j+1]");
        label6.setText("                swap(arreglo[j+1],arreglo[j])");
        label7.setText("                swapped = true");
        label8.setText("        Si swapped == false break");
        label9.setText("        swapped = false, fin--");
        label10.setText("        Para i = fin - 1 hasta inicio");
        label11.setText("            Si arreglo[j] > arreglo[j+1]");
        label12.setText("                swap(arreglo[j+1],arreglo[j])");
        label13.setText("                swapped = true");
        label14.setText("        inicio++");
        boolean swapped = true;
        animacion.actualizaContador(valorN, swapped);
        int inicio = 0;
        animacion.actualizaContador(valorJ, inicio);
        int fin = arr.length;
        animacion.actualizaContador(valorKey, fin);
        animacion.pintaLinea(label1);
        
        while (swapped == true){
            animacion.pintaLinea(label2);
            swapped = false;
            animacion.actualizaContador(valorN, swapped);
            boolean cambio = false;
            animacion.pintaLinea(label3);
            for (int i = inicio; i < fin - 1; ++i){
                animacion.actualizaContador(valorI, i);
                animacion.pintaLinea(label4);
                Canvas recMover = arr[i].r;
                Canvas recMover2 = arr[i + 1].r;
                if (arr[i].valor > arr[i+1].valor) {
                    animacion.pintaLinea(label5);
                    animacion.colorChange = new ParallelTransition(label6);
                    animacion.colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label6.styleProperty(), "-fx-background-color: #13bf38;"))));
                    animacion.sequentialTransition.getChildren().add(animacion.colorChange);
                    animacion.posicionInicial(i,cambio);
                        
                    animacion.bajarGrua();
                    
                    //Movimiento cajas
                    animacion.moverCajas(recMover,recMover2,i,cambio);
                    animacion.colorChange2 = new ParallelTransition(label6);
                    animacion.colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label6.styleProperty(), "-fx-background-color: #ffffff;"))));
                    animacion.sequentialTransition.getChildren().add(animacion.colorChange2);
                    Rectangulo temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                    animacion.actualizaContador(valorN, swapped);
                    animacion.pintaLinea(label7);
                    cambio = true;
                    if(i == fin-2){
                        animacion.mueveDesdeRepisa(recMover,recMover2,i+1);
                    }
                }
                else{
                    if(cambio){
                        animacion.mueveDesdeRepisa(recMover,recMover2,i);
                    }
                    cambio = false;       
                }
                
            }
        
            if (swapped == false) break;
            animacion.pintaLinea(label8);
            swapped = false;
            animacion.actualizaContador(valorN, swapped);
            cambio=false;
            fin--;
            animacion.actualizaContador(valorKey, fin);
            animacion.pintaLinea(label9);

            for (int i = fin - 1; i >= inicio; i--){
                animacion.actualizaContador(valorI, i);
                animacion.pintaLinea(label10);
                Canvas recMover = arr[i].r;
                Canvas recMover2 = arr[i + 1].r;
                if (arr[i].valor > arr[i + 1].valor){ 
                    animacion.pintaLinea(label11);
                    animacion.colorChange = new ParallelTransition(label12);
                    animacion.colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label12.styleProperty(), "-fx-background-color: #13bf38;"))));
                    animacion.sequentialTransition.getChildren().add(animacion.colorChange);
                    animacion.posicionInicial(i,!cambio);
                        
                    animacion.bajarGrua();
                    
                    //Movimiento cajas
                    animacion.moverCajasReverso(recMover,recMover2,i,cambio);
                    
                    animacion.colorChange2 = new ParallelTransition(label12);
                    animacion.colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label12.styleProperty(), "-fx-background-color: #ffffff;"))));
                    animacion.sequentialTransition.getChildren().add(animacion.colorChange2);
                    Rectangulo temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                    animacion.actualizaContador(valorN, swapped);
                    animacion.pintaLinea(label13);
                    cambio = true;
                    if(i == inicio){
                        animacion.mueveDesdeRepisa(recMover2,recMover,i);
                    }
                }
                else{
                    if(cambio){
                        animacion.mueveDesdeRepisa(recMover2,recMover,i+1);
                    }
                    cambio = false;
                    
                }
            }
            inicio++;
            animacion.actualizaContador(valorJ, inicio);
            animacion.pintaLinea(label14);
        }    
    }
     public void selectSort(Vagon arr[]){
        animacionVagon.inicioAnimaciones(arr);
        labelKey.setText("MaxIndex");
        label2.setText("    Para i = n-1 hasta 0");
        label3.setText("        maxIndex = i");
        label4.setText("        Para j = i-1 hasta 0");
        label5.setText("            Si arreglo[i] < arreglo[maxIndex]");
        label6.setText("                maxIndex = j");
        label7.setText("        moverAPosicionI(arreglo[maxIndex])");
        label8.setText("");

        int n = arr.length;
        animacionVagon.actualizaContador(valorN, n);
        animacionVagon.pintaLinea(label1);
        
        for (int i = n - 1; i > 0; i--) {
            
            animacionVagon.pintaLinea(label2);
            animacionVagon.actualizaContador(valorI, i);
            int maxIndex  = i;
            
            animacionVagon.pintaLinea(label3);
            animacionVagon.actualizaContador(valorKey, maxIndex);

            // Encuentra el índice del elemento maximo en el subarreglo no ordenado
            for (int j = i - 1; j >= 0; j--) {
                animacionVagon.pintaLinea(label4);
                animacionVagon.actualizaContador(valorJ, j);
                if (arr[j].valor> arr[maxIndex].valor) {
                    animacionVagon.pintaLinea(label5);
                    maxIndex  = j;  
                    animacionVagon.pintaLinea(label6);
                    animacionVagon.actualizaContador(valorKey, maxIndex);
                }
            }
            
            if(arr[i].valor<arr[maxIndex].valor){
                animacionVagon.colorChange = new ParallelTransition(label7);
                animacionVagon.colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label7.styleProperty(), "-fx-background-color: #13bf38;"))));
                animacionVagon.sequentialTransition.getChildren().add(animacionVagon.colorChange);
                animacionVagon.retrocederFerrocarril1(arr.length);
                animacionVagon.avanzarFerrocarril1(arr,maxIndex);
                animacionVagon.retrocederFerrocarril2(arr,maxIndex);
                animacionVagon.avanzarFerrocarril2(arr,maxIndex);
                animacionVagon.retrocederAMaxFerrocarril1(arr,maxIndex);
                animacionVagon.avanzarFerrocarril1(arr,i);
                animacionVagon.retrocederConMaxFerrocarril2(arr,i,maxIndex);
                animacionVagon.retrocederMayoresOrdenadosFerrocarril1(arr,i); 
                animacionVagon.colorChange2 = new ParallelTransition(label7);
                animacionVagon.colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label7.styleProperty(), "-fx-background-color: #ffffff;"))));
                animacionVagon.sequentialTransition.getChildren().add(animacionVagon.colorChange2);
            }
            
            Vagon temp = arr[maxIndex];
            for (int j = maxIndex; j < i; j++) {
                arr[j] = arr[j+1];
            }
            arr[i] = temp;
        }
    }   


    public static void setSel(int sel) {
        FXMLInterfazController.sel = sel;
    }

    @FXML
    private void pausar(ActionEvent event) {
        if(sel==4){
            animacionVagon.sequentialTransition.pause();
        }
        else{
            animacion.sequentialTransition.pause();
            animacion.sequentialTransition2.pause(); 
        }
        
    }

    @FXML
    private void resumir(ActionEvent event) {
        if(sel==4){
            animacionVagon.sequentialTransition.play();
        }
        else{
            animacion.sequentialTransition.play();
            animacion.sequentialTransition2.play();
        }
    }

    @FXML
    private void resetea(ActionEvent event) {
        if(sel==4){
            animacionVagon.sequentialTransition.play();
            animacionVagon.sequentialTransition.jumpTo(Duration.ZERO);
        }
        else{
            animacion.sequentialTransition.play();
            animacion.sequentialTransition2.play();
            animacion.sequentialTransition.jumpTo(Duration.ZERO);
            animacion.sequentialTransition2.jumpTo(Duration.ZERO);
            
        }
    }
    
    @FXML
    private void volverMenu(ActionEvent event) throws IOException {
        Stage stage = (Stage) nuevoArreglo.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInterfazMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();    
    }

    @FXML
    private void nuevoArreglo(ActionEvent event) throws IOException {
        Stage stage = (Stage) nuevoArreglo.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInterfaz.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,getDefaultToolkit().getScreenSize().width,getDefaultToolkit().getScreenSize().height);  
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.show();
    }
    
}

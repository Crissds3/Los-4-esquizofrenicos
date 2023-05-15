/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los.pkg4.esquizofrenicos;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.util.Duration;
import static los.pkg4.esquizofrenicos.FXMLInterfazController.sel;

/**
 *
 * @author yanko
 */
public class Animaciones {
    SequentialTransition sequentialTransition;
    SequentialTransition sequentialTransition2;
    ParallelTransition pt;
    ParallelTransition pt2;  
    ParallelTransition colorChange;
    ParallelTransition colorChange2;
    Canvas canvasRepisa;
    Canvas canvasGruaBase;
    Canvas canvasGruaBase2;
    Canvas canvasGruaIman;
    Canvas canvasGruaIman2;
    DibujarElemento dibujar;
    DibujarElemento dibujar2; 
    float vel;
    
    
    public Animaciones(){
        colorChange = new ParallelTransition();
        colorChange2 = new ParallelTransition();
        sequentialTransition = new SequentialTransition();
        sequentialTransition2 = new SequentialTransition();
    }
    
    public void posicionInicial(int j){
        TranslateTransition posicionBase = new TranslateTransition(Duration.seconds(vel/2), canvasGruaBase);
        TranslateTransition posicionIman = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);
        TranslateTransition posicionCuerda = new TranslateTransition(Duration.seconds(vel/2), dibujar.cuerda);   
  
        posicionBase.setToX(100+j*80);
        posicionIman.setToX(100+j*80);
        posicionCuerda.setToX(100+j*80);
        pt = new ParallelTransition(posicionBase,posicionIman,posicionCuerda);
        sequentialTransition.getChildren().add(pt);
    }
    
    public void posicionInicial(int j, boolean cambio){
        TranslateTransition posicionBase = new TranslateTransition(Duration.seconds(vel/2), canvasGruaBase);
        TranslateTransition posicionIman = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);
        TranslateTransition posicionCuerda = new TranslateTransition(Duration.seconds(vel/2), dibujar.cuerda); 

        if(cambio){
            posicionBase.setToX(100+(j+1)*80);
            posicionIman.setToX(100+(j+1)*80);
            posicionCuerda.setToX(100+(j+1)*80);
            pt = new ParallelTransition(posicionBase,posicionIman,posicionCuerda);
            sequentialTransition.getChildren().add(pt);
        }
        else{
            posicionBase.setToX(100+j*80);
            posicionIman.setToX(100+j*80);
            posicionCuerda.setToX(100+j*80);
            pt = new ParallelTransition(posicionBase,posicionIman,posicionCuerda);
            sequentialTransition.getChildren().add(pt);
        }
    }

    
    public void posicionInicial2(int j){
        TranslateTransition posicionBase2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaBase2);
        TranslateTransition posicionIman2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman2);
        TranslateTransition posicionCuerda2 = new TranslateTransition(Duration.seconds(vel/2), dibujar2.cuerda);   

        posicionBase2.setToX(100+j*80);
        posicionIman2.setToX(100+j*80);
        posicionCuerda2.setToX(100+j*80);
        pt2 = new ParallelTransition(posicionBase2,posicionIman2,posicionCuerda2);
        sequentialTransition2.getChildren().add(pt2);
    }
    
    public void bajarGrua(){
        TranslateTransition ttImanDown = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);   
        TranslateTransition cuerdaDown = new TranslateTransition(Duration.seconds(vel/2), dibujar.cuerda);
        cuerdaDown.setToY(195);
        ttImanDown.setToY(615);
        pt = new ParallelTransition(cuerdaDown,ttImanDown);
        sequentialTransition.getChildren().add(pt);    
    }
    
    public void bajarGrua2(){
        TranslateTransition ttImanDown2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman2); 
        TranslateTransition cuerdaDown2 = new TranslateTransition(Duration.seconds(vel/2), dibujar2.cuerda);
        cuerdaDown2.setToY(195);
        ttImanDown2.setToY(615);
        pt2 = new ParallelTransition(cuerdaDown2,ttImanDown2);
        sequentialTransition2.getChildren().add(pt2);
    }
    
    public void subirGrua(){
        TranslateTransition subirIman = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman);     
        TranslateTransition cuerdaUp = new TranslateTransition(Duration.seconds(vel/2), dibujar.cuerda);
        subirIman.setToY(310);
        cuerdaUp.setToY(-110);
        pt = new ParallelTransition(subirIman,cuerdaUp);
        sequentialTransition.getChildren().add(pt);
    }
    
    public void subirGrua2(){
        TranslateTransition subirIman2 = new TranslateTransition(Duration.seconds(vel/2), canvasGruaIman2);
        TranslateTransition cuerdaUp2 = new TranslateTransition(Duration.seconds(vel/2), dibujar2.cuerda);
        subirIman2.setToY(310);
        cuerdaUp2.setToY(-110);
        pt2 = new ParallelTransition(subirIman2,cuerdaUp2);
        sequentialTransition2.getChildren().add(pt2);
    }
    
    public void moverCajas(Canvas recMover,Canvas recMover2,int j, boolean cambio) {
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
        
        TranslateTransition ttImanLeft = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttBaseLeft = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttCuerdaLeft = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        
        TranslateTransition ttImanIni = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttBaseIni = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttCuerdaIni = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        TranslateTransition tt2Left = new TranslateTransition(Duration.seconds(vel), recMover2);
        TranslateTransition ttLeftIni = new TranslateTransition(Duration.seconds(vel), recMover);

        ttUp.setByY(-400);
        ttRight.setByX(80+80*j);
        
        ttDown.setByY(400);
        ttImanUp.setByY(-400);
        ttImanDown.setByY(400);

        ttImanRight.setByX(80+80*j);
        ttBaseRight.setByX(80+80*j);
        ttCuerdaRight.setByX(80+80*j);
        cuerdaDown.setByY(400);
        cuerdaUp.setByY(-400);
        tt2Left.setByX(-80);
        
        ttImanIni.setToX(100);
        ttBaseIni.setToX(100);
        ttCuerdaIni.setToX(100);
        ttLeftIni.setToX(100);
        
        ttImanLeft.setByX(-80);
        ttBaseLeft.setByX(-80);
        ttCuerdaLeft.setByX(-80);
        
        if(!cambio){
            pt = new ParallelTransition(ttUp,ttImanUp,cuerdaUp); //Sube iman con la caja
            sequentialTransition.getChildren().add(pt);
            pt = new ParallelTransition(ttImanIni,ttCuerdaIni,ttBaseIni,ttLeftIni); //lleva el iman con la caja a la repisa
            sequentialTransition.getChildren().add(pt); 
            pt = new ParallelTransition(ttImanRight,ttBaseRight,ttCuerdaRight); //la grua se posiciona en la segunda caja a mover
            sequentialTransition.getChildren().add(pt);
            pt = new ParallelTransition(ttImanDown,cuerdaDown); //el iman baja
            sequentialTransition.getChildren().add(pt);   
        }

        
        pt = new ParallelTransition(ttImanLeft,ttBaseLeft,ttCuerdaLeft,tt2Left); //el iman con la segunda caja se desplazan a la izquierda
        sequentialTransition.getChildren().add(pt);   
        pt = new ParallelTransition(ttImanUp,cuerdaUp); //sube el iman
        sequentialTransition.getChildren().add(pt);
        
        /*if(cambio){
            pt = new ParallelTransition(ttImanIni,ttCuerdaIni,ttBaseIni); //el iman se ubica en la caja que esta en la repisa
            sequentialTransition.getChildren().add(pt);  
            pt = new ParallelTransition(ttImanRight,ttBaseRight,ttCuerdaRight,ttRight); //el iman con la caja de la repisa se ubican sobre la posicion a dejar la caja
            sequentialTransition.getChildren().add(pt);
            pt = new ParallelTransition(ttImanDown,cuerdaDown, ttDown); //baja el iman con la caja
            sequentialTransition.getChildren().add(pt);
        }*/
            
    }
    public void mueveDesdeRepisa(Canvas recMover,Canvas recMover2,int j) {
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
        
        TranslateTransition ttImanLeft = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttBaseLeft = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttCuerdaLeft = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        
        TranslateTransition ttImanIni = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttBaseIni = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttCuerdaIni = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        TranslateTransition tt2Left = new TranslateTransition(Duration.seconds(vel), recMover2);
        TranslateTransition ttLeftIni = new TranslateTransition(Duration.seconds(vel), recMover);

        ttUp.setByY(-400);
        ttRight.setByX(80*j);
        
        ttDown.setByY(400);
        ttImanUp.setByY(-400);
        ttImanDown.setByY(400);

        ttImanRight.setByX(80*j);
        ttBaseRight.setByX(80*j);
        ttCuerdaRight.setByX(80*j);
        cuerdaDown.setByY(400);
        cuerdaUp.setByY(-400);
        tt2Left.setByX(-80);
        
        ttImanIni.setToX(100);
        ttBaseIni.setToX(100);
        ttCuerdaIni.setToX(100);
        ttLeftIni.setToX(100);
        
        ttImanLeft.setByX(-80);
        ttBaseLeft.setByX(-80);
        ttCuerdaLeft.setByX(-80);
         
        /*pt = new ParallelTransition(ttUp,ttImanUp,cuerdaUp); //Sube iman con la caja
        sequentialTransition.getChildren().add(pt);
        pt = new ParallelTransition(ttImanIni,ttCuerdaIni,ttBaseIni,ttLeftIni); //lleva el iman con la caja a la repisa
        sequentialTransition.getChildren().add(pt); 
        pt = new ParallelTransition(ttImanRight,ttBaseRight,ttCuerdaRight); //la grua se posiciona en la segunda caja a mover
        sequentialTransition.getChildren().add(pt);  
        pt = new ParallelTransition(ttImanDown,cuerdaDown); //el iman baja
        sequentialTransition.getChildren().add(pt);   
        pt = new ParallelTransition(ttImanLeft,ttBaseLeft,ttCuerdaLeft,tt2Left); //el iman con la segunda caja se desplazan a la izquierda
        sequentialTransition.getChildren().add(pt); */
       
        //pt = new ParallelTransition(ttImanUp,cuerdaUp); //sube el iman
        //sequentialTransition.getChildren().add(pt);
        pt = new ParallelTransition(ttImanIni,ttCuerdaIni,ttBaseIni); //el iman se ubica en la caja que esta en la repisa
        sequentialTransition.getChildren().add(pt);  
        pt = new ParallelTransition(ttImanRight,ttBaseRight,ttCuerdaRight,ttRight); //el iman con la caja de la repisa se ubican sobre la posicion a dejar la caja
        sequentialTransition.getChildren().add(pt);
        pt = new ParallelTransition(ttImanDown,cuerdaDown, ttDown); //baja el iman con la caja
        sequentialTransition.getChildren().add(pt);
    }
    
    public void moverCajasReverso(Canvas recMover,Canvas recMover2,int j, boolean cambio) {
        TranslateTransition tt2Up = new TranslateTransition(Duration.seconds(vel), recMover2);
        TranslateTransition tt2Down = new TranslateTransition(Duration.seconds(vel), recMover2);
        TranslateTransition tt2Right = new TranslateTransition(Duration.seconds(vel), recMover2);
        
        TranslateTransition ttImanUp = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttImanRight = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttImanDown = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttBaseRight = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttCuerdaRight = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        TranslateTransition cuerdaUp = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        TranslateTransition cuerdaDown = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        
         
        TranslateTransition ttImanRight2 = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttBaseRight2 = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttCuerdaRight2 = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);
        
        TranslateTransition ttImanIni = new TranslateTransition(Duration.seconds(vel), canvasGruaIman);
        TranslateTransition ttBaseIni = new TranslateTransition(Duration.seconds(vel), canvasGruaBase);
        TranslateTransition ttCuerdaIni = new TranslateTransition(Duration.seconds(vel), dibujar.cuerda);       
        TranslateTransition ttRight2 = new TranslateTransition(Duration.seconds(vel), recMover);
        TranslateTransition ttLeftIni = new TranslateTransition(Duration.seconds(vel), recMover2);

        tt2Up.setByY(-400);
        tt2Right.setByX(80*j);

        tt2Down.setByY(400);
        ttImanUp.setByY(-400);
        ttImanDown.setByY(400);

        ttImanRight.setByX(80*j);
        ttBaseRight.setByX(80*j);
        ttCuerdaRight.setByX(80*j);
        cuerdaDown.setByY(400);
        cuerdaUp.setByY(-400);
        ttRight2.setByX(80);
        
        ttImanIni.setToX(100);
        ttBaseIni.setToX(100);
        ttCuerdaIni.setToX(100);
        ttLeftIni.setToX(100);
       
        ttImanRight2.setByX(80);
        ttBaseRight2.setByX(80);
        ttCuerdaRight2.setByX(80);
        
        if(!cambio){
            pt = new ParallelTransition(tt2Up,ttImanUp,cuerdaUp); //Sube iman con la caja
            sequentialTransition.getChildren().add(pt);
            pt = new ParallelTransition(ttImanIni,ttCuerdaIni,ttBaseIni,ttLeftIni); //lleva el iman con la caja a la repisa
            sequentialTransition.getChildren().add(pt);
            pt = new ParallelTransition(ttImanRight,ttBaseRight,ttCuerdaRight); //la grua se posiciona en la caja izquierda a mover
            sequentialTransition.getChildren().add(pt);   
            pt = new ParallelTransition(ttImanDown,cuerdaDown); //el iman baja
            sequentialTransition.getChildren().add(pt);     
        }
        pt = new ParallelTransition(ttImanRight2,ttBaseRight2,ttCuerdaRight2,ttRight2); //el iman con la caja de la izquierda se desplazan a la derecha
        sequentialTransition.getChildren().add(pt);  
        pt = new ParallelTransition(ttImanUp,cuerdaUp); //sube el iman
        sequentialTransition.getChildren().add(pt);   
        
        /*
        pt = new ParallelTransition(ttImanIni,ttCuerdaIni,ttBaseIni); //el iman se ubica en la caja que esta en la repisa
        sequentialTransition.getChildren().add(pt);  
        pt = new ParallelTransition(ttImanRight,ttBaseRight,ttCuerdaRight,tt2Right); //el iman con la caja de la repisa se ubican sobre la posicion a dejar la caja
        sequentialTransition.getChildren().add(pt);   
        pt = new ParallelTransition(ttImanDown,cuerdaDown, tt2Down); //baja el iman con la caja
        sequentialTransition.getChildren().add(pt);*/
    }
        
    public void moverCajaIzquierda(Canvas recMover) {
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

    public void moverCajaDerecha(Canvas recMover) {
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
    
    public void pintaLinea(Label label){
        colorChange = new ParallelTransition(label);
        colorChange2 = new ParallelTransition(label);
        colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.styleProperty(), "-fx-background-color: #13bf38;"))));
        colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.styleProperty(), "-fx-background-color: #ffffff;"))));
        sequentialTransition.getChildren().add(colorChange);
        sequentialTransition.getChildren().add(colorChange2);
        if(sel==1){
        sequentialTransition2.getChildren().add(colorChange);
        sequentialTransition2.getChildren().add(colorChange2);
        }
        
    }
        
    public void actualizaContador(Label label, int valor){
        ParallelTransition ptValor = new ParallelTransition(label);
        ptValor.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.textProperty(), valor+""))));
        sequentialTransition.getChildren().add(ptValor);
        if(sel==1)
        sequentialTransition2.getChildren().add(ptValor);
    }
    
    public void actualizaContador(Label label, boolean valor){
        ParallelTransition ptValor = new ParallelTransition(label);
        ptValor.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.textProperty(), valor+""))));
        sequentialTransition.getChildren().add(ptValor);
        if(sel==1)
        sequentialTransition2.getChildren().add(ptValor);
    }
}

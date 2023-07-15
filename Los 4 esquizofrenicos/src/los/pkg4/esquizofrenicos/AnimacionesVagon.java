package los.pkg4.esquizofrenicos;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class AnimacionesVagon {
    float vel;
    float velVagones;
    ParallelTransition pt;
    ParallelTransition pt2;
    ParallelTransition pt3;
    SequentialTransition sequentialTransition;
    ParallelTransition colorChange;
     ParallelTransition colorChange2;
    
    
    public AnimacionesVagon() {
        sequentialTransition = new SequentialTransition();  
    }

    public void avanzarFerrocarril1(Vagon[] v, int inicio, int fin){
        pt = new ParallelTransition();
        
        for (int i = inicio+1; i < fin; i++) {   
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1700+(i+1)*70);
            pt.getChildren().add(transicion);       
        }
        for (int i = fin+1; i < v.length; i++) {   
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1700+i*70);
            pt.getChildren().add(transicion);       
        }
        sequentialTransition.getChildren().add(pt); 
    }
    
    public void retrocederFerrocarril1(Vagon[] v, int inicio, int fin){      
        pt = new ParallelTransition();
        for (int i = 0; i < inicio; i++) {
            TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(260+(i) * 70);
            pt.getChildren().add(transicion);
        }
        
        for (int i = inicio+1; i < fin; i++) {
            TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(260+(i-1) * 70);
            pt.getChildren().add(transicion);
        }
        
        sequentialTransition.getChildren().add(pt);       
    }
    
    public void retrocederMayoresOrdenadosFerrocarril1(Vagon[] v, int inicio, int fin){      
        pt = new ParallelTransition();

        for (int i = inicio+1; i < fin; i++) {
            TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(260+(i-1) * 70);
            pt.getChildren().add(transicion);
        }
        sequentialTransition.getChildren().add(pt);       
    }

    
    public void avanzarConMaxFerrocarril1(Vagon[] v, int maxIndex, int fin){       
        pt = new ParallelTransition();
        
        for (int i = maxIndex+1; i < fin; i++) {
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1700+i*70);
            pt.getChildren().add(transicion);
        }
        for (int i = fin+1; i < v.length; i++) {
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1700+i*70);
            pt.getChildren().add(transicion);
        }
        
        TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[maxIndex].v);
        transicion.setToX(1700+(fin)*70);
        pt.getChildren().add(transicion);
        sequentialTransition.getChildren().add(pt);    
        
    }
    
    
    public void retrocederConMaxFerrocarril1(Vagon[] v, int maxIndex, int fin){      
        pt = new ParallelTransition();

        for (int i = maxIndex+1; i < fin; i++) {
            TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(260+(i) * 70);
            pt.getChildren().add(transicion);
        }
        for (int i = fin+1; i < v.length; i++) {
            TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(260+(i) * 70);
            pt.getChildren().add(transicion);
        }
        TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[maxIndex].v);
        transicion.setToX(260+(fin) * 70);
        pt.getChildren().add(transicion);
        sequentialTransition.getChildren().add(pt);       
    }
    
    public void retrocederHastaMayoresFerrocarril1(Vagon[] v, int inicio, int fin){
        pt = new ParallelTransition();
        
        for (int i = inicio+1; i < fin; i++) {   
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1700+(i+1)*70);
            pt.getChildren().add(transicion);       
        }
        for (int i = fin; i < v.length; i++) {   
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1700+i*70);
            pt.getChildren().add(transicion);       
        }
        sequentialTransition.getChildren().add(pt); 
    }
    
    public void extraeMayoresFerrocarril1(Vagon[] v, int fin, int maxIndex){      
        
        pt = new ParallelTransition();
        
        for (int i = fin+1; i < v.length; i++) {
            System.out.println("sa");
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1700+i*70);
            pt.getChildren().add(transicion);
            
        }
        sequentialTransition.getChildren().add(pt);  
    }
    
    public void avanzarFerrocarril2(Vagon[] v, int indice){
        pt = new ParallelTransition();
        
        SequentialTransition movimientoVagon = new SequentialTransition();
        int contador=1;
        for (int j = 260+indice * 70; j < 1700+indice*70; j+=10) {
            TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[indice].v); 
            TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[indice].v); 

            if(j<1400){
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
            else if(j>=1400 && j<1720){

                if(j==1400){
                    for (int i = 0; i >= -20; i--) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[indice].v);
                        rotateTransition.setToAngle(i);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaArriba.setToX(1400+contador*10);
                avanzaArriba.setToY(945-contador*3.7f);
                movimientoVagon.getChildren().add(avanzaArriba);

                contador++;
            }
            else if(j>=1720){
                if(j==1720){
                    for (int i = -20; i <= 0; i++) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[indice].v);
                        rotateTransition.setToAngle(i);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }  
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
        }
        pt.getChildren().add(movimientoVagon);   
        sequentialTransition.getChildren().add(pt);
        
    }
    
    public void avanzarConMaxFerrocarril2(Vagon[] v, int indice, int maxIndex){
        pt = new ParallelTransition();

        SequentialTransition movimientoVagon = new SequentialTransition();
        int contador=1;
        for (int j = 260+(maxIndex+1)  * 70; j < 1700+indice*70; j+=10) {

            TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[indice].v); 
            TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[indice].v); 

            if(j<1400){
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
            else if(j>=1400 && j<1720){

                if(j==1400){
                    for (int i = 0; i >= -20; i--) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[indice].v);
                        rotateTransition.setToAngle(i);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaArriba.setToX(1400+contador*10);
                avanzaArriba.setToY(945-contador*3.7f);
                movimientoVagon.getChildren().add(avanzaArriba);
                contador++;
            }
            else if(j>=1720){
                if(j==1720){
                    for (int i = -20; i <= 0; i++) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[indice].v);
                        rotateTransition.setToAngle(i);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }  
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
        }
        pt.getChildren().add(movimientoVagon);   
        
        //mueve el vagon maximo
        movimientoVagon = new SequentialTransition();
        contador=1;
        for (int j = 260+maxIndex * 70; j < 1700+(indice-1)*70; j+=10) {

            TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[maxIndex].v); 
            TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[maxIndex].v); 

            if(j<1400){
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
            else if(j>=1400 && j<1720){

                if(j==1400){
                    for (int i = 0; i >= -20; i--) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[maxIndex].v);
                        rotateTransition.setToAngle(i);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaArriba.setToX(1400+contador*10);
                avanzaArriba.setToY(945-contador*3.7f);
                movimientoVagon.getChildren().add(avanzaArriba);

                contador++;

            }
            else if(j>=1720){
                if(j==1720){
                    for (int i = -20; i <= 0; i++) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[maxIndex].v);
                        rotateTransition.setToAngle(i);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }  
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
        }
        pt.getChildren().add(movimientoVagon);   
        
        sequentialTransition.getChildren().add(pt);
        
    }
 
    public void retrocederFerrocarril2(Vagon[] v, int indice, int maxIndex){
        pt = new ParallelTransition();
        
        SequentialTransition movimientoVagon = new SequentialTransition();
        int contador=1;
        for (int j = 1700+(indice)*70; j >= 260+(maxIndex)*70; j-=10) {

            TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[indice].v); 
            TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[indice].v); 

            if(j>=1700){
                if(j==1700){
                    for (int k = 0; k >= -20; k--) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[indice].v);
                        rotateTransition.setToAngle(k);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
            else if(j>=1450 && j<1700){

                if(j==1450){
                    for (int k = -20; k <= 0; k++) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[indice].v);
                        rotateTransition.setToAngle(k);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaArriba.setToX(1700-contador*10);
                avanzaArriba.setToY(830+contador*4.6f);

                movimientoVagon.getChildren().add(avanzaArriba);
                contador++;
            }
            else {
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
        }
        pt.getChildren().add(movimientoVagon);   
        sequentialTransition.getChildren().add(pt);
    }
    
    public void retrocederAMaxFerrocarril2(Vagon[] v, int indice, int maxIndex){
        pt = new ParallelTransition();
        
        SequentialTransition movimientoVagon = new SequentialTransition();
        int contador=1;
        for (int j = 1700+(indice)*70; j >= 260+(maxIndex+1)*70; j-=10) {

            TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[indice].v); 
            TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[indice].v); 

            if(j>=1700){
                if(j==1700){
                    for (int k = 0; k >= -20; k--) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[indice].v);
                        rotateTransition.setToAngle(k);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
            else if(j>=1450 && j<1700){

                if(j==1450){
                    for (int k = -20; k <= 0; k++) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[indice].v);
                        rotateTransition.setToAngle(k);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaArriba.setToX(1700-contador*10);
                avanzaArriba.setToY(830+contador*4.6f);

                movimientoVagon.getChildren().add(avanzaArriba);
                contador++;
            }
            else {
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
        }
        pt.getChildren().add(movimientoVagon);      
        sequentialTransition.getChildren().add(pt);
        
    }
    
    public void retrocederFerrocarril3(Vagon[] v, int maxIndex, int fin){      
        pt = new ParallelTransition();
        
        for (int i = maxIndex-1; i >= 0 ; i--) {
            SequentialTransition movimientoVagon = new SequentialTransition();
            int contador=1;
            for (int j = 260+i * 70; j < 1700+i*70; j+=10) {
                
                TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 
                TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 

                if(j<1400){
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
                else if(j>=1400 && j<1720){

                    if(j==1400){
                        for (int k = 0; k >= -20; k--) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }
                    avanzaArriba.setToX(1400+contador*10);
                    avanzaArriba.setToY(945-contador*3.7f);
                    movimientoVagon.getChildren().add(avanzaArriba);
                    contador++;
                }
                else if(j>=1720){
                    if(j==1720){
                        for (int k = -20; k <= 0; k++) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }  
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
            }
            pt.getChildren().add(movimientoVagon);   
        }
        for (int i = fin-1; i > maxIndex ; i--) {
            SequentialTransition movimientoVagon = new SequentialTransition();
            int contador=1;
            for (int j = 260+(i-1) * 70; j < 1700+(i-1)*70; j+=10) {
                
                TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 
                TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 

                if(j<1400){
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
                else if(j>=1400 && j<1720){

                    if(j==1400){
                        for (int k = 0; k >= -20; k--) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }
                    avanzaArriba.setToX(1400+contador*10);
                    avanzaArriba.setToY(945-contador*3.7f);
                    movimientoVagon.getChildren().add(avanzaArriba);

                    contador++;

                }
                else if(j>=1720){
                    if(j==1720){
                        for (int k = -20; k <= 0; k++) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }  
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
            }
            pt.getChildren().add(movimientoVagon);   
        }
        sequentialTransition.getChildren().add(pt);  
    }
    
    public void retrocederAOrdenadosFerrocarril3(Vagon[] v, int fin){      
        pt = new ParallelTransition();
        
        for (int i = 0; i < fin; i++) {   
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1700+(i+2)*70);
            pt.getChildren().add(transicion);       
        }
  
        sequentialTransition.getChildren().add(pt); 
    }
    
    
    public void avanzarConMaxFerrocarril3(Vagon[] v, int indice, int maxIndex){
        
        pt = new ParallelTransition();
        
        for (int i = maxIndex-1; i >= 0 ; i--) {
            SequentialTransition movimientoVagon = new SequentialTransition();
            int contador=1;
            for (int j = 1700+(i)*70; j >= 260+(i)*70; j-=10) {
                
                TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 
                TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 

                if(j>=1700){
                    if(j==1700){
                        for (int k = 0; k >= -20; k--) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);             
                }
                else if(j>=1450 && j<1700){
                    if(j==1450){
                        for (int k = -20; k <= 0; k++) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }
                                        
                    avanzaArriba.setToX(1700-contador*10);
                    avanzaArriba.setToY(830+contador*4.6f);
 
                    movimientoVagon.getChildren().add(avanzaArriba);
                    contador++;
                }
                else {
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
            }
            pt.getChildren().add(movimientoVagon);   
        }
        for (int i = indice-1; i > maxIndex ; i--) {
            SequentialTransition movimientoVagon = new SequentialTransition();
            int contador=1;
            for (int j = 1700+(i-1)*70; j >= 260+(i-1)*70; j-=10) {
                
                TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 
                TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 

                if(j>=1700){
                    if(j==1700){
                        for (int k = 0; k >= -20; k--) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
                else if(j>=1450 && j<1700){
                    
                    if(j==1450){
                        for (int k = -20; k <= 0; k++) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }
                    avanzaArriba.setToX(1700-contador*10);
                    avanzaArriba.setToY(830+contador*4.6f);
 
                    movimientoVagon.getChildren().add(avanzaArriba);
                    contador++;
                }
                else {
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
            }
            pt.getChildren().add(movimientoVagon);   
        }
        
        //mueve el vagon maximo
        
        
        SequentialTransition movimientoVagon = new SequentialTransition();
        int contador=1;
        for (int j = 1700+(indice-1)*70; j >= 260+(indice-1)*70; j-=10) {

            TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[maxIndex].v); 
            TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[maxIndex].v); 

            if(j>=1700){
                if(j==1700){
                    for (int k = 0; k >= -20; k--) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[maxIndex].v);
                        rotateTransition.setToAngle(k);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
            else if(j>=1450 && j<1700){
                if(j==1450){
                    for (int k = -20; k <= 0; k++) {
                        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[maxIndex].v);
                        rotateTransition.setToAngle(k);
                        movimientoVagon.getChildren().add(rotateTransition);
                    }
                }
                avanzaArriba.setToX(1700-contador*10);
                avanzaArriba.setToY(830+contador*4.6f);

                movimientoVagon.getChildren().add(avanzaArriba);
                contador++;
            }
            else {
                avanzaAdentro.setToX(j);
                movimientoVagon.getChildren().add(avanzaAdentro);
            }
        }
        pt.getChildren().add(movimientoVagon);   
        
        sequentialTransition.getChildren().add(pt);
                
        
    }
    
    public void retrocederUltimoFerrocarril3(Vagon[] v, int maxIndex, int fin){      
        pt = new ParallelTransition();
        
        for (int i = maxIndex-1; i >=0 ; i--) {
            SequentialTransition movimientoVagon = new SequentialTransition();
            int contador=1;
            for (int j = 260+(i-1) * 70; j < 1700+(i-1)*70; j+=10) {
                
                TranslateTransition avanzaAdentro = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 
                TranslateTransition avanzaArriba = new TranslateTransition(Duration.seconds(velVagones), v[i].v); 

                if(j<1400){
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
                else if(j>=1400 && j<1720){

                    if(j==1400){
                        for (int k = 0; k >= -20; k--) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }
                    avanzaArriba.setToX(1400+contador*10);
                    avanzaArriba.setToY(945-contador*3.7f);
                    movimientoVagon.getChildren().add(avanzaArriba);
                    contador++;
                }
                else if(j>=1720){
                    if(j==1720){
                        for (int k = -20; k <= 0; k++) {
                            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(velVagones/20), v[i].v);
                            rotateTransition.setToAngle(k);
                            movimientoVagon.getChildren().add(rotateTransition);
                        }
                    }  
                    avanzaAdentro.setToX(j);
                    movimientoVagon.getChildren().add(avanzaAdentro);
                }
            }
            pt.getChildren().add(movimientoVagon);   
        }
        sequentialTransition.getChildren().add(pt);    
    }
    
     public void pintaLinea(Label label){
        colorChange = new ParallelTransition(label);
        colorChange2 = new ParallelTransition(label);
        colorChange.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.styleProperty(), "-fx-background-color: #13bf38;"))));
        colorChange2.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.styleProperty(), "-fx-background-color: #ffffff;"))));
        sequentialTransition.getChildren().add(colorChange);
        sequentialTransition.getChildren().add(colorChange2);  
    }
        
    public void actualizaContador(Label label, int valor){
        ParallelTransition ptValor = new ParallelTransition(label);
        ptValor.getChildren().add(new Timeline(new KeyFrame(Duration.seconds(vel/8),new KeyValue(label.textProperty(), valor+""))));
        sequentialTransition.getChildren().add(ptValor);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los.pkg4.esquizofrenicos;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 *
 * @author yanko
 */
public class AnimacionesVagon {
    float vel;
    ParallelTransition pt;
    SequentialTransition sequentialTransition;

    public AnimacionesVagon() {
        sequentialTransition = new SequentialTransition();
    }
    
    
    
    public void avanzar(Vagon[] v, int maxIndex, int fin){
        pt = new ParallelTransition();
        
        for (int i = maxIndex+1; i < fin; i++) {
            
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1400+i*80);
            pt.getChildren().add(transicion);
            
        }
        sequentialTransition.getChildren().add(pt); 
    }
    
    public void retroceder(Vagon[] v, int maxIndex, int fin){      
        pt = new ParallelTransition();

        for (int i = maxIndex+1; i < fin; i++) {
            TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[i].v);

            transicion.setToX(200+(i-1)*80);
            pt.getChildren().add(transicion);
        }
        sequentialTransition.getChildren().add(pt);       
    }
    
    public void avanzarConMax(Vagon[] v, int maxIndex, int fin){       
        pt = new ParallelTransition();
        
        for (int i = maxIndex+1; i < fin; i++) {
            
            TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(1400+i*80);
            pt.getChildren().add(transicion);
            
        }
        TranslateTransition transicion = new TranslateTransition(Duration.seconds(vel), v[maxIndex].v);
        transicion.setToX(1400+fin*80);
        pt.getChildren().add(transicion);
        sequentialTransition.getChildren().add(pt);    
        
    }
    
    
    public void retrocederConMax(Vagon[] v, int maxIndex, int fin){      
        pt = new ParallelTransition();

        for (int i = maxIndex+1; i < fin; i++) {
            TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[i].v);
            transicion.setToX(200+(i)*80);
            pt.getChildren().add(transicion);
        }
        TranslateTransition transicion =  new TranslateTransition(Duration.seconds(vel), v[maxIndex].v);
        transicion.setToX(200+(fin)*80);
        pt.getChildren().add(transicion);
        sequentialTransition.getChildren().add(pt);       
    }
    
    public void avanzarRotandoIzq(Vagon[] v, int indice){
        TranslateTransition vagonMaxAvanza = new TranslateTransition(Duration.seconds(vel/2), v[indice].v);
        TranslateTransition vagonMaxArriba = new TranslateTransition(Duration.seconds(vel/2), v[indice].v);
        vagonMaxAvanza.setToX(1500);
        vagonMaxArriba.setByY(-100);
        sequentialTransition.getChildren().add(vagonMaxAvanza);
        sequentialTransition.getChildren().add(vagonMaxArriba);
    }
    
    public void arrastra2Vagones(Vagon[] v, int indice, int maxIndex){
        TranslateTransition vagonMaxAvanza = new TranslateTransition(Duration.seconds(vel/2), v[indice].v);
        TranslateTransition vagonMaxArriba = new TranslateTransition(Duration.seconds(vel/2), v[indice].v);
        TranslateTransition vagonMaxAvanza2 = new TranslateTransition(Duration.seconds(vel/2), v[maxIndex].v);
        TranslateTransition vagonMaxArriba2 = new TranslateTransition(Duration.seconds(vel/2), v[maxIndex].v);
        vagonMaxAvanza.setToX(1500);
        vagonMaxArriba.setByY(-200);
        vagonMaxAvanza2.setToX(1500);
        vagonMaxArriba2.setByY(-100);
        pt = new ParallelTransition(vagonMaxAvanza,vagonMaxAvanza2);
        sequentialTransition.getChildren().add(pt);
        pt = new ParallelTransition(vagonMaxArriba,vagonMaxArriba2);
        sequentialTransition.getChildren().add(pt);
    }
    
    public void retrocederRotandoDer(Vagon[] v, int indice, int maxIndex){
        TranslateTransition vagonMaxAbajo = new TranslateTransition(Duration.seconds(vel/2), v[indice].v);
        TranslateTransition vagonMaxRetrocede = new TranslateTransition(Duration.seconds(vel/2), v[indice].v);
        vagonMaxAbajo.setToY(v[indice].v.getTranslateY());
        vagonMaxRetrocede.setToX(200+(maxIndex+1)*80);
        sequentialTransition.getChildren().add(vagonMaxAbajo);
        sequentialTransition.getChildren().add(vagonMaxRetrocede);
    }
    
    public void retrocederRotandoDerMax(Vagon[] v, int indice, int maxIndex){
        TranslateTransition vagonMaxAbajo = new TranslateTransition(Duration.seconds(vel/2), v[maxIndex].v);
        TranslateTransition vagonMaxRetrocede = new TranslateTransition(Duration.seconds(vel/2), v[maxIndex].v);
        vagonMaxAbajo.setByY(100);
        vagonMaxRetrocede.setToX(200+(indice)*80);
        sequentialTransition.getChildren().add(vagonMaxAbajo);
        sequentialTransition.getChildren().add(vagonMaxRetrocede);
    }
}

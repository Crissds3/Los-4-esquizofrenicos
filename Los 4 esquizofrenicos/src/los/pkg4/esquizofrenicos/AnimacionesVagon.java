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
    
    
    
    public void avanzar(Vagon[] v){
        TranslateTransition transiciones[] = new TranslateTransition[v.length];
        pt = new ParallelTransition();
        for (int i = 0; i < v.length; i++) {
            transiciones[i] =  new TranslateTransition(Duration.seconds(vel), v[i].v);
            transiciones[i].setByX(100);
            pt.getChildren().add(transiciones[i]);
            
        }
        sequentialTransition.getChildren().add(pt);  
    }
    
}

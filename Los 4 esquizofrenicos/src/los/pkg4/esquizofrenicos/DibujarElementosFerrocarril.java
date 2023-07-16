/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los.pkg4.esquizofrenicos;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class DibujarElementosFerrocarril {
    Canvas locomotora = new Canvas(120, 40);
    Canvas locomotora2 = new Canvas(120, 40);
    
    public void agregarLocomotora(int x, int y){
        System.out.println(getClass().getResourceAsStream("img/locomotora.png"));

        Image image = new Image(getClass().getResourceAsStream("img/locomotora.png"));
        GraphicsContext gc = locomotora.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        locomotora.setTranslateX(x);
        locomotora.setTranslateY(y);
    }
    
    public void agregarLocomotora2(int x, int y){
        Image image = new Image(getClass().getResourceAsStream("img/locomotora.png"));
        GraphicsContext gc = locomotora2.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        locomotora2.setTranslateX(x);
        locomotora2.setTranslateY(y);
    }
}
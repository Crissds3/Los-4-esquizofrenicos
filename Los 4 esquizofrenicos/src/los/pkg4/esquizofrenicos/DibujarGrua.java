
package los.pkg4.esquizofrenicos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class DibujarGrua {
   

  
    

    protected void dibujar2(GraphicsContext dib){

              Grua base1 = new Grua();
            double[] coordenadaBase = base1.base(600, 0);

        for (int i = 0; i < coordenadaBase.length; i = i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenadaBase[i], coordenadaBase[i + 1], coordenadaBase[i + 2], coordenadaBase[i + 3]);
             
        }
        
        Grua cuerda1= new Grua();
        double[] coordenadaCuerda =cuerda1.cuerda(650, 50);
        
        for (int i = 0; i < coordenadaCuerda.length; i= i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenadaCuerda[i], coordenadaCuerda[i+1], coordenadaCuerda[i+2], coordenadaCuerda[i+3]);
        }
        
        
        Grua iman1= new Grua();
        double[] coordenadaIman= iman1.iman(650, 150);
        for (int i = 0; i < coordenadaIman.length; i=i+4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenadaIman[i], coordenadaIman[i+1], coordenadaIman[i+2], coordenadaIman[i+3]);
        }
     
        
                 Grua base2 = new Grua();
            double[] coordenadaBase2 = base2.base(800, 0);

        for (int i = 0; i < coordenadaBase2.length; i = i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenadaBase2[i], coordenadaBase2[i + 1], coordenadaBase2[i + 2], coordenadaBase2[i + 3]);
             
        }
        
        Grua cuerda2= new Grua();
        double[] coordenadaCuerda2 =cuerda2.cuerda(850, 50);
        
        for (int i = 0; i < coordenadaCuerda2.length; i= i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenadaCuerda2[i], coordenadaCuerda2[i+1], coordenadaCuerda2[i+2], coordenadaCuerda2[i+3]);
        }
        
        
        Grua iman2= new Grua();
        double[] coordenadaIman2= iman2.iman(850, 150);
        for (int i = 0; i < coordenadaIman.length; i=i+4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenadaIman2[i], coordenadaIman2[i+1], coordenadaIman2[i+2], coordenadaIman2[i+3]);
        }
     
        
        
        

        
        
        
}
}

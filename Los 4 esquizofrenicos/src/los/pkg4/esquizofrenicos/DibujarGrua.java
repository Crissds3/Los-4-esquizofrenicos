package los.pkg4.esquizofrenicos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class DibujarGrua {
    Line cuerda= new Line();
    
    public void dibujarCuerda(int x,int y){    
        cuerda.setStartX(x);
        cuerda.setStartY(y);
        cuerda.setEndX(x);
        cuerda.setEndY(y+95);
        cuerda.setStrokeWidth(4);        
    }
    
    protected void dibujarBase(GraphicsContext dib, int x, int y){

        double[] coordenadaBase = {
            x,y ,x+70,y,
            x,y,x,y+50,
            x,y+50,x+70,y+50,
            x+70,y+50,x+70,y 
        };
        for (int i = 0; i < coordenadaBase.length; i = i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenadaBase[i], coordenadaBase[i + 1], coordenadaBase[i + 2], coordenadaBase[i + 3]);  
        }
    }    
      
 

 protected void dibujarIman(GraphicsContext dib, int x, int y){
        double[] coordenadaIman = {
            x-20,y,x+20,y,
            x-20,y,x-30,y+30,
            x-30,y+30,x-30,y+60,
            x-30,y+60,x-20,y+60,
            x-20,y+60,x-20,y+40,
            x-20,y+40,x-15,y+30,
            x-15,y+30,x+15,y+30,
            x+15,y+30,x+20,y+40,
            x+20,y+40,x+20,y+60,
            x+20,y+60,x+30,y+60,
            x+30,y+60,x+30,y+30,
            x+30,y+30,x+22,y,
        };
        
            double[] coordenadaImanPintar = {
  
    
            x-21,y+2,x-30,y+10, 
            x-23,y+5,x-26,y+20,
            x-25,y+7,x-24,y+22,
            x-28,y+17,x-68,y+100,
            x-24,y+10,x-24,y+22,
            x-25,y+17,x-68,y+100,
            x+20,y+17,x-66,y+100,
            x+18,y+17,x-66,y+50,
            
    
 
        };
      
      
      
        
        for (int i = 0; i < coordenadaImanPintar.length; i=i+4) {

            
            dib.fillRect(coordenadaImanPintar[i], coordenadaImanPintar[i+1], coordenadaImanPintar[i+2], coordenadaImanPintar[i+3]);
        }
        
        
        
          for (int i = 0; i < coordenadaIman.length; i=i+4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
        
            dib.strokeLine(coordenadaIman[i], coordenadaIman[i+1], coordenadaIman[i+2], coordenadaIman[i+3]);
           
           
        }
        
    }
    
}

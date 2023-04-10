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
      
        for (int i = 0; i < coordenadaIman.length; i=i+4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenadaIman[i], coordenadaIman[i+1], coordenadaIman[i+2], coordenadaIman[i+3]);
        }
    }
    
}

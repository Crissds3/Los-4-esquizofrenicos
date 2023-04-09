
package los.pkg4.esquizofrenicos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class DibujarGrua {

    protected void dibujar2(GraphicsContext dib){

        Grua grua = new Grua();
        double[] coordenada = grua.base(600, 0);

        for (int i = 0; i < coordenada.length; i = i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenada[i], coordenada[i + 1], coordenada[i + 2], coordenada[i + 3]);  
        }

        coordenada = grua.cuerda(650, 50);

        for (int i = 0; i < coordenada.length; i= i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenada[i], coordenada[i+1], coordenada[i+2], coordenada[i+3]);
        }

        coordenada = grua.iman(650, 150);
        for (int i = 0; i < coordenada.length; i=i+4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenada[i], coordenada[i+1], coordenada[i+2], coordenada[i+3]);
        }

        coordenada = grua.base(800, 0);
        for (int i = 0; i < coordenada.length; i = i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenada[i], coordenada[i + 1], coordenada[i + 2], coordenada[i + 3]);
        }

        coordenada =grua.cuerda(850, 50);
        for (int i = 0; i < coordenada.length; i= i + 4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenada[i], coordenada[i+1], coordenada[i+2], coordenada[i+3]);
        }

        coordenada = grua.iman(850, 150);
        for (int i = 0; i < coordenada.length; i=i+4) {
            dib.setStroke(Color.BLACK);
            dib.setLineWidth(4);
            dib.strokeLine(coordenada[i], coordenada[i+1], coordenada[i+2], coordenada[i+3]);
        }  
        
    }
}

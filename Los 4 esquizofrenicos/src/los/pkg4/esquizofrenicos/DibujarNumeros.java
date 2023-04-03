package los.pkg4.esquizofrenicos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DibujarNumeros {

    protected void dibujar(GraphicsContext gc, int num, int x, int y) {
        Numeros numDibujar = new Numeros();
        double[] coordenada = null;
        switch(num){
            case 0:
                coordenada = numDibujar.cero(x, y);
                break;
            case 1:
                coordenada = numDibujar.uno(x, y);
                break;
            case 2:
                coordenada = numDibujar.dos(x, y);
                break;
            case 3:
                coordenada = numDibujar.tres(x, y);
                break;
            case 4:
                coordenada = numDibujar.cuatro(x, y);
                break;
            case 5:
                coordenada = numDibujar.cinco(x, y);
                break;
            case 6:
                coordenada = numDibujar.seis(x, y);
                break;
            case 7:
                coordenada = numDibujar.siete(x, y);
                break;
            case 8:
                coordenada = numDibujar.ocho(x, y);
                break;
            case 9:
                coordenada = numDibujar.nueve(x, y);
                break;
            default:
                break;
        }
        for (int i = 0; i < coordenada.length; i = i + 4) {
            gc.setStroke(Color.WHITE);
            gc.setLineWidth(4);
            gc.strokeLine(coordenada[i], coordenada[i + 1], coordenada[i + 2], coordenada[i + 3]);
        }
    }
}

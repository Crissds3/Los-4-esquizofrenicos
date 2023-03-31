package los.pkg4.esquizofrenicos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DibujarNumeros {

    /*
    recibe el graphicsContext y con eso le paso las coordenadas para dibujar.
    por ej se invoca la funcion 0, con las x e y donde quiero que se dibujen para luego utilizar ese arreglo que retorna
    la funcion y utilizar el graphicsContext
    
    -Se llama la funcion dibujar numero que recibe graphicsContext
    -Se invoca una funcion de la clase numero
    -Se utiliza el arreglo de la funcion anterior y mediante un for se dibuja el numero
     */
    protected void dibujar(GraphicsContext gc) {
        Numeros cero = new Numeros();
        double[] coordenadaCero = cero.cero(100, 100);

        for (int i = 0; i < coordenadaCero.length; i = i + 4) {
            gc.setStroke(Color.RED);
            gc.strokeLine(coordenadaCero[i], coordenadaCero[i + 1], coordenadaCero[i + 2], coordenadaCero[i + 3]);
        }

        Numeros uno = new Numeros();
        double[] coordenadaUno = uno.uno(150, 100);

        for (int i = 0; i < coordenadaUno.length; i = i + 4) {
            gc.setStroke(Color.RED);
            gc.strokeLine(coordenadaUno[i], coordenadaUno[i + 1], coordenadaUno[i + 2], coordenadaUno[i + 3]);
        }

        Numeros dos = new Numeros();
        double[] coordenadaDos = dos.dos(200, 100);

        for (int i = 0; i < coordenadaDos.length; i = i + 4) {
            gc.setStroke(Color.RED);
            gc.strokeLine(coordenadaDos[i], coordenadaDos[i + 1], coordenadaDos[i + 2], coordenadaDos[i + 3]);
        }

        Numeros tres = new Numeros();
        double[] coordenadaTres = tres.tres(250, 100);

        for (int i = 0; i < coordenadaTres.length; i = i + 4) {
            gc.setStroke(Color.RED);
            gc.strokeLine(coordenadaTres[i], coordenadaTres[i + 1], coordenadaTres[i + 2], coordenadaTres[i + 3]);
        }
        Numeros cuatro = new Numeros();
        double[] coordenadaCuatro = cuatro.cuatro(300, 100);

        for (int i = 0; i < coordenadaCuatro.length; i = i + 4) {
            gc.setStroke(Color.RED);
            gc.strokeLine(coordenadaCuatro[i], coordenadaCuatro[i + 1], coordenadaCuatro[i + 2], coordenadaCuatro[i + 3]);
        }
        Numeros cinco = new Numeros();
        double[] coordenadaCinco = cinco.cinco(350, 100);

        for (int i = 0; i < coordenadaCinco.length; i = i + 4) {
            gc.setStroke(Color.RED);
            gc.strokeLine(coordenadaCinco[i], coordenadaCinco[i + 1], coordenadaCinco[i + 2], coordenadaCinco[i + 3]);
        }

    }
}

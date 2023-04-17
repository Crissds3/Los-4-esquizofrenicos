package los.pkg4.esquizofrenicos;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Rectangulo {
    int valor;
    Canvas r;

    public Rectangulo(int valor, int altura, int ancho, Color color) {
        Image image = new Image(getClass().getResourceAsStream("img/caja.jpg"));
        DibujarNumeros dibujar = new DibujarNumeros();   
        this.valor = valor;
        this.r = new Canvas(altura,ancho);
        GraphicsContext gc = r.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        dibujar.dibujar(gc,valor/10,25,55);
        dibujar.dibujar(gc,valor%10,45,55);
    }
    public Rectangulo() {
        this.valor = 0;
        this.r = new Canvas();
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setR(Canvas r) {
        this.r = r;
    }

    public int getValor() {
        return valor;
    }

    public Canvas getR() {
        return r;
    }
    
    
}


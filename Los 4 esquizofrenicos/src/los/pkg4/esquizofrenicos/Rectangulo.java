package los.pkg4.esquizofrenicos;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rectangulo {
    int valor;
    Canvas r;

    public Rectangulo(int valor, int altura, int ancho, Color color) {
        DibujarNumeros dibujar = new DibujarNumeros();   
        this.valor = valor;
        this.r = new Canvas(altura,ancho);
        GraphicsContext gc = r.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, ancho, altura);
        dibujar.dibujar(gc,valor/10,25,60);
        dibujar.dibujar(gc,valor%10,45,60);
    }
    public Rectangulo() {
        this.valor = 0;
        this.r = new Canvas();
    }
    
    public void repintarRectangulo(Color color){
        DibujarNumeros dibujar = new DibujarNumeros();
        GraphicsContext gc = r.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, r.getWidth(), r.getHeight());
        dibujar.dibujar(gc,valor/10,25,60);
        dibujar.dibujar(gc,valor%10,45,60);
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


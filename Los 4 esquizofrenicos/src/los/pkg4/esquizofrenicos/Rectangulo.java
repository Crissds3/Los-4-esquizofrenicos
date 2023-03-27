package los.pkg4.esquizofrenicos;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rectangulo {
    int valor;
    Rectangle r;

    public Rectangulo(int valor, int altura, int alto, Color color) {
        this.valor = valor;
        this.r = new Rectangle(altura,alto,color);
    }
    public Rectangulo() {
        this.valor = 0;
        this.r = new Rectangle();
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setR(Rectangle r) {
        this.r = r;
    }

    public int getValor() {
        return valor;
    }

    public Rectangle getR() {
        return r;
    }
    
    
}


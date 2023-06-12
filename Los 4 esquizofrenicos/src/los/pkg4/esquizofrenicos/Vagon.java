/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package los.pkg4.esquizofrenicos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
class Vagon {
    int valor;
    Canvas v;

    public Vagon(int valor, int altura, int ancho, Color color ) {
        Image image = new Image(getClass().getResourceAsStream("img/vagones.png"));
        DibujarNumeros dibujar = new DibujarNumeros();  
        this.valor=valor;
        this.v= new Canvas(altura,ancho);
        GraphicsContext gc = v.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
    }
    

    public Vagon() {
        this.valor=0;
        this.v= new Canvas();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Canvas getV() {
        return v;
    }

    public void setV(Canvas v) {
        this.v = v;
    }
    
    
    
    
    
          
    
}

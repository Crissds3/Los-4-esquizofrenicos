package los.pkg4.esquizofrenicos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DibujarNumeros {

    protected void dibujar(GraphicsContext gc, int num, int x, int y) {
        double[] coordenada = null;
        switch (num) {
            case 0:
                coordenada = new double[]{x - 10, y - 40, x, y - 40,
                    x, y - 40, x, y - 10,
                    x, y - 10, x - 10, y - 10,
                    x - 10, y - 10, x - 10, y - 40
                };
                break;
            case 1:
                coordenada = new double[]{x - 10, y - 35, x - 5, y - 40,
                    x - 5, y - 40, x - 5, y - 10,
                    x - 10, y - 10, x, y - 10,};
                break;
            case 2:
                coordenada = new double[]{x - 10, y - 40, x, y - 40,
                    x, y - 40, x, y - 25,
                    x, y - 25, x - 10, y - 25,
                    x - 10, y - 25, x - 10, y - 10,
                    x - 10, y - 10, x, y - 10
                };
                break;
            case 3:
                coordenada = new double[]{x - 10, y - 40, x, y - 40,
                    x, y - 40, x, y - 25,
                    x, y - 25, x - 10, y - 25,
                    x, y - 25, x, y - 10,
                    x - 10, y - 10, x, y - 10
                };
                break;
            case 4:
                coordenada = new double[]{x - 10, y - 40, x - 10, y - 25,
                    x - 10, y - 25, x, y - 25,
                    x, y - 40, x, y - 10
                };
                break;
            case 5:
                coordenada = new double[]{x - 10, y - 40, x, y - 40,
                    x - 10, y - 40, x - 10, y - 25,
                    x - 10, y - 25, x, y - 25,
                    x, y - 25, x, y - 10,
                    x, y - 10, x - 10, y - 10
                };
                break;
            case 6:
                coordenada = new double[]{x - 10, y - 40, x, y - 40,
                    x - 10, y - 40, x - 10, y - 10,
                    x - 10, y - 10, x, y - 10,
                    x, y - 10, x, y - 25,
                    x, y - 25, x - 10, y - 25
                };
                break;
            case 7:
                coordenada = new double[]{x - 10, y - 40, x, y - 40,
                    x, y - 40, x, y - 10
                };
                break;
            case 8:
                coordenada = new double[]{x - 10, y - 40, x, y - 40,
                    x - 10, y - 40, x - 10, y - 10,
                    x - 10, y - 10, x, y - 10,
                    x, y - 10, x, y - 40,
                    x - 10, y - 25, x, y - 25
                };
                break;
            case 9:
                coordenada = new double[]{x - 10, y - 40, x, y - 40,
                    x - 10, y - 40, x - 10, y - 25,
                    x - 10, y - 25, x, y - 25,
                    x, y - 40, x, y - 10,};
                break;
            default:
                break;
        }
        for (int i = 0; i < coordenada.length; i = i + 4) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(4);
            gc.strokeLine(coordenada[i], coordenada[i + 1], coordenada[i + 2], coordenada[i + 3]);
        }
    }
}

package studyJava.Core.Graphics.intuit;

import java.awt.*;

/**
 * Created by Olga on 28.06.2014.
 */
public class SinCanvas {

    private int height;

    public void paint(Graphics g ) {
        height = 100;//getHeight();
        int width = 100;//getWidth();
        // Вычисляем масштаб таким образом,
        // чтобы на компоненте всегда умещалось
        // 5 периодов
        double k=2*Math.PI*5/width;
        int sy = calcY(0, width, height, k);
        for (int i=1; i<width; i++) {
            int nsy = calcY(i, width, height, k);
            g.drawLine(i-1, sy, i, nsy);
            sy=nsy;
        }
    }



    // метод, вычисляющий значение функции
    // для отображения на экране
    private int calcY(int x, int width,
                      int height, double k) {
        double dx = (x-width/2.)*k;
        return (int)(height/2.*(1-Math.sin(dx)));
    }

    public static void main(String[] args) {
        Graphics graphics = null;
        new SinCanvas().paint(graphics);
    }
}

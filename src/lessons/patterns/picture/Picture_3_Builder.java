package lessons.patterns.picture;

import lessons.patterns.picture.figures.Circle;
import lessons.patterns.picture.figures.Figure;
import lessons.patterns.picture.figures.Rectangle;
import lessons.patterns.picture.figures.Trapeze;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Picture_3_Builder implements PictureBuilder {
    public static final String NOT_ENOUGH_MATERIAL = "Not enough material!";
    private Queue<Circle> circles = new LinkedList<>();
    private static final int CIRCLES_COUNT = 4;
    private Queue<Rectangle> rectangles = new LinkedList<>();
    private static final int RECTANGLES_COUNT = 2;
    private Queue<Trapeze> trapezes = new LinkedList<>();
    private static final int TRAPEZES_COUNT = 1;

    @Override
    public List<Figure> setFigures(List<Figure> figures) {
        for (Figure figure : figures) {
            switch (figure.getClass().getSimpleName()){
               case "Circle"://get circles
                    if (circles.size() < CIRCLES_COUNT){
                        circles.add((Circle)figure);
                        //figures.remove(figure);
                    }
                    break;
                case "Rectangle":
                    if (rectangles.size() < RECTANGLES_COUNT){
                        rectangles.add((Rectangle)figure);
                        //figures.remove(figure);
                    }
                    break;
                case "Trapeze":
                    if (trapezes.size() < TRAPEZES_COUNT){
                        trapezes.add((Trapeze)figure);
                        //figures.remove(figure);
                    }
                    break;
                default:
                    break;
            }
        }

        if (circles.size() != CIRCLES_COUNT
                || rectangles.size() != RECTANGLES_COUNT
                || trapezes.size() != TRAPEZES_COUNT){
            throw new IllegalArgumentException(NOT_ENOUGH_MATERIAL);
        }

        figures.removeAll(circles);
        figures.removeAll(rectangles);
        figures.removeAll(trapezes);

        return figures;
    }

    @Override
    public void drawPoints() {
        /*NOP*/
    }

    @Override
    public void drawSegments() {
        /*NOP*/
    }

    @Override
    public void drawCircles() {
        for (int i = 0; i < CIRCLES_COUNT; i++) {
            circles.poll().draw();
        }
    }

    @Override
    public void drawOvals() {
        /*NOP*/
    }

    @Override
    public void drawTriangles() {
        /*NOP*/
    }

    @Override
    public void drawRectangles() {
        for (int i = 0; i < RECTANGLES_COUNT; i++) {
            rectangles.poll().draw();
        }
    }

    @Override
    public void drawLines() {
        /*NOP*/
    }

    @Override
    public void drawTrapezes() {
        for (int i = 0; i < TRAPEZES_COUNT; i++) {
            trapezes.poll().draw();
        }
    }
}

package lessons.patterns.picture;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

interface PictureBuilder {
    //set figures

    /**
     * set material to PictureBuilder
     * @param figures -- list of all figures
     * @return the rest of figures
     */
    List<Figure> setFigures(List<Figure> figures);

    //draw figures
    void drawPoints();
    void drawSegments();
    void drawCircles();
    void drawOvals();
    void drawTriangles();
    void drawRectangles();
    void drawLines();
    void drawTrapezes();

}

interface Drawable {
    void draw();
}

abstract class Figure implements Drawable {
    //for exceptions
    public static final String NO_SUCH_PROPERTY = "No such property!";
    public static final String INCORRECT_PROPERTY = "incorrect property!";

    public double getDistance(Point point1, Point point2) {
        return Math.sqrt(getX(point1, point2)* getX(point1, point2)
                        + getY(point1, point2)* getY(point1, point2));
    }

    public double getX(Point point1, Point point2){
        return point1.getX() - point2.getX();
    }

    public double getY(Point point1, Point point2){
        return point1.getY() - point2.getY();
    }

    public abstract void setProperty(String key, Point[] points);

    protected void checkPointsCount(Point[] points, int requiredSize) {
        if (points.length < requiredSize){
            throw new IllegalArgumentException(INCORRECT_PROPERTY);
        }
    }

}
class Circle extends Figure {

    private Point center;
    private double radius;
    private Point point;

    Circle() {
    }

    public Circle(Point center, Point point) {
        this.center = center;
        this.radius = getDistance(center, point);
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }

    @Override
    public void setProperty(String key, Point[] points) {
        switch (key.toLowerCase()) {
            case "center":
                checkPointsCount(points, 1);
                setCenter(points[0]);
                break;
            case "point":
                checkPointsCount(points, 1);
                setPoint(points[0]);
                break;
            default:
                throw new IllegalArgumentException(NO_SUCH_PROPERTY);
        }
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setPoint(Point point) {
        this.point = point;
        this.radius = getDistance(center, point);
    }
}

class Triangle extends Figure{
    public static final String NOT_TRIANGLE = "this is not triangle!";
    private Point pointA;
    private Point pointB;
    private Point pointC;


    @Override
    public void draw() {
        System.out.println("Triangle");
    }

    @Override
    public void setProperty(String key, Point[] points) {
        switch (key.toLowerCase()) {
            case "a":
                checkPointsCount(points, 1);
                setA(points[0]);
                break;
            case "b":
                checkPointsCount(points, 1);
                setB(points[0]);
                break;
            case "c":
                checkPointsCount(points, 1);
                setC(points[0]);
                break;
            case "ab":
                checkPointsCount(points, 2);
                setA(points[0]);
                setB(points[1]);
                break;
            case "bc":
                checkPointsCount(points, 2);
                setB(points[0]);
                setC(points[1]);
                break;
            case "ac":
                checkPointsCount(points, 2);
                setA(points[0]);
                setC(points[1]);
                break;
            case "abc":
                checkPointsCount(points, 3);
                setA(points[0]);
                setB(points[1]);
                setC(points[2]);
                break;
            default:
                throw new IllegalArgumentException(NO_SUCH_PROPERTY);
        }
        checkIsTriangle();
    }

    private void checkIsTriangle() {
        double ab = getDistance(pointA, pointB);
        double bc = getDistance(pointB, pointC);
        double ac = getDistance(pointA, pointC);
        if (ab + bc <= ac
                || ab + ac <= bc
                || bc + ac <= ab){
            throw new IllegalArgumentException(NOT_TRIANGLE);
        }
    }

    public void setA(Point a) {
        this.pointA = a;
    }

    public void setB(Point b) {
        this.pointB = b;
    }

    public void setC(Point c) {
        this.pointC = c;
    }
}

class Rectangle extends Figure {

    @Override
    public void setProperty(String key, Point[] points) {

    }

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Trapeze extends Figure {

    @Override
    public void setProperty(String key, Point[] points) {

    }

    @Override
    public void draw() {
        System.out.println("Trapeze");
    }
}

class Oval extends Figure{

    @Override
    public void setProperty(String key, Point[] points) {

    }

    @Override
    public void draw() {
        System.out.println("Oval");
    }
}

class Line extends Figure {

    @Override
    public void setProperty(String key, Point[] points) {

    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}

enum Figures{
    CIRCLE, TRIANGLE, RECTANGLE, OVAL, LINE, POINT, TRAPEZE, SEGMENT
}

class Segment extends Figure{

    private Point begin;
    private Point end;

    Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public Segment() {

    }

    @Override
    public void draw() {
        System.out.println("Segment");
    }

    @Override
    public void setProperty(String key, Point[] points) {
        switch (key.toLowerCase()) {
            case "begin":
                checkPointsCount(points, 1);
                setBegin(points[0]);
                break;
            case "end":
                checkPointsCount(points, 1);
                setEnd(points[0]);
                break;
            case "segment":
                checkPointsCount(points, 2);
                setBegin(points[0]);
                setEnd(points[1]);
                break;
            default:
                throw new IllegalArgumentException(NO_SUCH_PROPERTY);
        }
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}

class Point extends Figure implements Drawable{

    private int x;
    private int y;

    Point() {
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void draw() {
        System.out.println("Point");
    }

    @Override
    public void setProperty(String key, Point[] points) {
        switch (key.toLowerCase()){
            case "point":
                checkPointsCount(points, 1);
                setX(points[0].getX());
                setY(points[0].getY());
                break;
            default:
                throw new IllegalArgumentException(NO_SUCH_PROPERTY);
        }
    }
}

class FigureFactory{

    public static final String NO_SUCH_FIGURE = "No such figure!";

    public Figure getFigure(String figureName, HashMap<String, Point[]> parameters){
        return getFigure(Figures.valueOf(figureName), parameters);
    }

    public Figure getFigure(Figures figureName, HashMap<String, Point[]> parameters){
        Figure figure = null;
        switch (figureName){
            case POINT:
                figure = new Point();
                break;
            case SEGMENT:
                figure = new Segment();
                break;
            case CIRCLE:
                figure = new Circle();
                break;
            case TRIANGLE:
                figure = new Triangle();
                break;
            case TRAPEZE:
                figure = new Trapeze();
                break;
            case RECTANGLE:
                figure = new Rectangle();
                break;
            case OVAL:
                figure = new Oval();
                break;
            case LINE:
                figure = new Line();
                break;
            default:
                throw new IllegalArgumentException(NO_SUCH_FIGURE);
        }
        return createFigure(figure, parameters);
    }

    public Figure createFigure(Figure figure, HashMap<String, Point[]> parameters) {
        for (String key : parameters.keySet()){
            figure.setProperty(key, parameters.get(key));
        }
        return figure;
    }
}

class Painter  {
    private PictureBuilder pictureBuilder;
    private List<Figure> figuresRest;

    Painter(PictureBuilder pictureBuilder, List<Figure> figures) {
        this.pictureBuilder = pictureBuilder;
        this.figuresRest = pictureBuilder.setFigures(figures);
    }

    public void paint(){
        pictureBuilder.drawRectangles();
        pictureBuilder.drawCircles();
        pictureBuilder.drawTrapezes();
    }
}

class Picture_3_Builder implements PictureBuilder {
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

public class Picture {
    public static void main(String[] args) {
        List<Figure> figures = new LinkedList<>();
        FigureFactory factory = new FigureFactory();
        HashMap<String, Point[]> parameters = new HashMap<>();

        //generate figures
        parameters.put("center", new Point[]{new Point(1,2)});
        parameters.put("point", new Point[]{new Point(2,2)});
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        parameters.clear();

        parameters.put("abc", new Point[]{new Point(1, 2), new Point(2, 2), new Point(3, 5)});
        figures.add(factory.getFigure(Figures.TRIANGLE, parameters));
        figures.add(factory.getFigure(Figures.TRIANGLE, parameters));
        parameters.clear();

        parameters.put("ac", new Point[]{new Point(0, 0), new Point(7, 2)});
        figures.add(factory.getFigure(Figures.RECTANGLE, parameters));
        figures.add(factory.getFigure(Figures.RECTANGLE, parameters));
        parameters.clear();

        parameters.put("abcd", new Point[]{new Point(0, 0), new Point(7, 2), new Point(-1, -1), new Point(2, 2)});
        figures.add(factory.getFigure(Figures.TRAPEZE, parameters));
        figures.add(factory.getFigure(Figures.TRAPEZE, parameters));
        parameters.clear();

        PictureBuilder builder = new Picture_3_Builder();
        Painter painter = new Painter(builder, figures);
        painter.paint();
    }
}

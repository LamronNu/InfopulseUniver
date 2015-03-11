package lessons.patterns.picture.figures;

import lessons.patterns.picture.Drawable;

public class Point extends Figure implements Drawable {

    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
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

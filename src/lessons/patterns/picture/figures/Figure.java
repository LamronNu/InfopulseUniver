package lessons.patterns.picture.figures;

import lessons.patterns.picture.Drawable;

public abstract class Figure implements Drawable {
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

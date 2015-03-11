package lessons.patterns.picture.figures;

public class Circle extends Figure {

    private Point center;
    private double radius;
    private Point point;

    public Circle() {
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

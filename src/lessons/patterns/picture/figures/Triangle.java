package lessons.patterns.picture.figures;

public class Triangle extends Figure{
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

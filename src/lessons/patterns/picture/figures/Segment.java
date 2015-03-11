package lessons.patterns.picture.figures;

public class Segment extends Figure{

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

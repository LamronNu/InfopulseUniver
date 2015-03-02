package labs.task1_OOP.services;

import labs.task1_OOP.utils.enums.TransferType;

public class Transfer extends OrderService {
    private String pointFrom = "A";
    private String pointTo = "B";
    private int duration = 1; //in hours

    public String getTypeStr() {
        return type.toString();
    }

    public void setType(TransferType type) {
        this.type = type;
    }

    private TransferType type = TransferType.AUTO;

    //constructors
    public Transfer(String name, double price, String pointFrom, String pointTo) {
       this(name, price, 1, pointFrom, pointTo, 1);
    }
    public Transfer(String name, double price, int count, String pointFrom, String pointTo) {
        this(name, price, count, pointFrom, pointTo, 1);
    }
    public Transfer(String name, double price, String pointFrom, String pointTo, int duration) {
        this(name, price, 1, pointFrom, pointTo, duration);
    }
    public Transfer(String name, double price, int count, String pointFrom, String pointTo, int duration) {
        super(name, price, count);
        checkPoint(pointFrom);
        checkPoint(pointTo);
        checkDuration(duration);
        this.pointFrom = pointFrom;
        this.pointTo = pointTo;
        this.duration = duration;
    }
    private void checkPoint(String point) {
        if (point.length() == 0 ){
            throw new IllegalArgumentException("not negative duration!");
        }
    }
    private void checkDuration(int duration) {
        if (duration < 0){
            throw new IllegalArgumentException("not negative duration!");
        }
    }

    //getters and setters
    public String getPointFrom() {
        return pointFrom;
    }

    public void setPointFrom(String pointFrom) {
        checkPoint(pointFrom);
        this.pointFrom = pointFrom;
    }

    public String getPointTo() {
        return pointTo;
    }

    public void setPointTo(String pointTo) {
        checkPoint(pointTo);
        this.pointTo = pointTo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        checkDuration(duration);
        this.duration = duration;
    }


    public void setType(String s) {
        this.type = TransferType.valueOf(s);
    }
}

package labs.task1_OOP.services;

import labs.task1_OOP.utils.TransferType;

public class Transfer extends OrderService {
    private String pointFrom = "A";
    private String pointTo = "B";
    private int duration = 1; //in hours
    private TransferType type = TransferType.AUTO;

    //constructors
    public Transfer(String name, double price, String pointFrom, String pointTo) {
        super(name, price);
        this.pointFrom = pointFrom;
        this.pointTo = pointTo;
    }
    public Transfer(String name, double price, int count, String pointFrom, String pointTo) {
        super(name, price, count);
        this.pointFrom = pointFrom;
        this.pointTo = pointTo;
    }
    public Transfer(String name, double price, String pointFrom, String pointTo, int duration) {
        super(name, price);
        this.pointFrom = pointFrom;
        this.pointTo = pointTo;
        this.duration = duration;
    }
    public Transfer(String name, double price, int count, String pointFrom, String pointTo, int duration) {
        super(name, price, count);
        this.pointFrom = pointFrom;
        this.pointTo = pointTo;
        this.duration = duration;
    }
    //getters and setters
    public String getPointFrom() {
        return pointFrom;
    }

    public void setPointFrom(String pointFrom) {
        this.pointFrom = pointFrom;
    }

    public String getPointTo() {
        return pointTo;
    }

    public void setPointTo(String pointTo) {
        this.pointTo = pointTo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}

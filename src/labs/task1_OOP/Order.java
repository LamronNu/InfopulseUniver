package labs.task1_OOP;

import labs.task1_OOP.services.OrderService;
import labs.task1_OOP.utils.comparators.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Order {
    //fields -- properties
    private String name;


    private List<OrderService> services = new ArrayList();
    private Date dateFrom;
    private Date dateTo;

    //constructors
    public Order() {
        this("Basic order", new ArrayList<OrderService>(), new Date(), new Date());
    }

    public Order(String name, List<OrderService> services, Date dateFrom, Date dateTo) {
        this.name = name;
        this.services = services;
        this.dateFrom = dateFrom;//check dates??
        this.dateTo = dateTo;
    }


    //getters, setters


    //sort
    public void sortByServiceName(){
        Collections.sort(services, new NameComparator());
    }
    public void sortByServicePrice(){
        Collections.sort(services, new PriceComparator());
    }
    public void sortByServiceDuration(){
        //Collections.sort(services, new DurationComparator());//think
    }
}

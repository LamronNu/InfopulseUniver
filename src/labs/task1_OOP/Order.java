package labs.task1_OOP;

import labs.task1_OOP.services.OrderService;
import labs.task1_OOP.utils.Money;
import labs.task1_OOP.utils.comparators.AmountComparator;
import labs.task1_OOP.utils.comparators.NameComparator;
import labs.task1_OOP.utils.comparators.PriceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private static final String DEFAULT_ORDER_NAME = "Basic order";

    //fields -- properties
    private String name;
    private int number;
    private static int counter = 0;
    private static boolean isCounterGetted = false;

    private List<OrderService> services;
//    private Date dateFrom;
//    private Date dateTo;

    //constructors
    public Order() {
        this("Basic order", new ArrayList<OrderService>());
    }

    public Order(String name, List<OrderService> services) {
        this.name = checkName(name);
        this.services = services;
        number = counter++;
//        this.dateFrom = dateFrom;//check dates??
//        this.dateTo = dateTo;
    }

    private String checkName(String name) {
        return name != "" ? name : DEFAULT_ORDER_NAME;
    }

    public Order(List<OrderService> list) {
        this(DEFAULT_ORDER_NAME, list);
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
    public void sortByServiceAmount() {
        Collections.sort(services, new AmountComparator());
    }


    public void addService(OrderService service) {
        services.add(service);
    }




    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = checkName(name);
    }

    public String getServicesStr() {
        String result = "";
        int count = 1;
        for (OrderService service : services){
            result += ">" + count++ + ". " + service + "\n";
        }
        return result;
    }

    public OrderService getService(int index) {
        return services.get(index);
    }

    public Money getTotalAmount(){
        Money result = new Money();
        for (OrderService service : services){
            result.addAmount(service.getAmount());
        }
        return result;
    }


}

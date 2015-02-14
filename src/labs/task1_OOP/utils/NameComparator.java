package labs.task1_OOP.utils;

import labs.task1_OOP.services.OrderService;

import java.util.Comparator;

public class NameComparator implements Comparator<OrderService>{

    @Override
    public int compare(OrderService o1, OrderService o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

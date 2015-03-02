package labs.task1_OOP.utils.comparators;

import labs.task1_OOP.services.OrderService;

import java.util.Comparator;

public class AmountComparator implements Comparator<OrderService> {

    @Override
    public int compare(OrderService o1, OrderService o2) {
        return (int)(o1.getAmount() - o2.getAmount());
    }
}

package labs.task1_OOP;

import org.apache.log4j.Logger;

public class Consultant {
    private static final Logger log = Logger.getLogger(Consultant.class);
    private String client;
    private Order order;

    public Consultant() {
        this("Cat Simon", new Order());
    }

    public Consultant(String client, Order order) {
        this.client = client;
        this.order = order;
    }
}

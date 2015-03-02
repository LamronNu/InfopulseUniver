package labs.task1_OOP;

import labs.task1_OOP.services.Hotel;
import labs.task1_OOP.services.Insurance;
import labs.task1_OOP.services.OrderService;
import labs.task1_OOP.services.Transfer;
import labs.task1_OOP.utils.comparators.NameComparator;
import labs.task1_OOP.utils.comparators.PriceComparator;
import labs.task1_OOP.utils.enums.HotelFood;
import labs.task1_OOP.utils.enums.TransferType;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Order {
    //files
    private static final String ORDERS_FILE_NAME = "src\\labs\\task1_OOP\\utils\\files\\orders.txt";
    private static final String ORDERS_NUMBER_FILE_NAME = "src\\labs\\task1_OOP\\utils\\files\\orders_number.txt";


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
        this.name = name;
        this.services = services;
        number = counter++;
//        this.dateFrom = dateFrom;//check dates??
//        this.dateTo = dateTo;
    }

    public Order(List<OrderService> list) {
        this("Basic order", list);
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

    //save to file
    //get counter
    private void getCounter()  {
        if (isCounterGetted)
            return;
        isCounterGetted = true;
        Scanner in = null;
        try {
            in = new Scanner(new File(ORDERS_NUMBER_FILE_NAME));
        } catch (FileNotFoundException e) {
            /*NOP*/

            return;
        }
        counter = in.nextInt();
        in.close();
    }

    //save counter to separate file
    private void saveCounter() throws IOException {
        FileWriter out = new FileWriter(ORDERS_NUMBER_FILE_NAME);
        out.write(counter);
        out.flush();
        out.close();
    }

    //save (append) order to file
    private void saveOrder() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ORDERS_FILE_NAME, true));
        out.println(number);
        out.print(">>" + "\t");
        out.println(name);
        //out.print("services:" + "\t");
        for (OrderService service : services){
            out.print(">" + "\t");
            out.print(service.getName() + "\t");
            out.print(service.getPrice() + "\t");
            out.print(service.getCount() + "\t");
            if (service instanceof Transfer){
                out.print("T" + "\t");
                out.print((char) ((Transfer) service).getDuration() + "\t");
                out.print(((Transfer) service).getTypeStr()+ "\t");
                out.print(((Transfer) service).getPointFrom() + "\t");
                out.print(((Transfer) service).getPointTo() + "\t");
            } else
            if (service instanceof Hotel) {
                out.print("H" + "\t");
                out.print(((Hotel) service).getFoodTypeStr() + "\t");
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public void saveToFile() throws IOException {
        getCounter();
        saveOrder();
        saveCounter();
    }

    private List<Order> getOrders() {
        Scanner in = null;
        try {
            in = new Scanner(new File(ORDERS_FILE_NAME));
        } catch (FileNotFoundException e) {
            return null;
        }
        String tempStr = "";
        String[] tempArr;
        OrderService tempService;
        String tempName;
        double tempPrice;
        int tempCount;
        int pos = 0;
        List<Order> result = new ArrayList<Order>();

        while (in.hasNext()) {
            Order order = new Order();
            order.setNumber(in.nextInt());
            if (in.hasNextLine()) {
                tempStr = in.nextLine();
                pos = tempStr.indexOf(">>\t");
                if (pos != -1) {
                    order.setName(tempStr.substring(++pos));
                }
            }
            if (in.hasNextLine()) {
                tempStr = in.nextLine();
                pos = tempStr.indexOf(">\t");
                while (pos != -1) {
                    try {
                        tempArr = tempStr.split("\t");
                        tempName = tempArr[1];
                        tempPrice = Double.parseDouble(tempArr[2]);
                        tempCount = Integer.parseInt(tempArr[3]);
                        switch (tempArr[tempArr.length - 1]) {
                            case "H":
                                tempService = new Hotel(tempPrice, tempCount);
                                tempService.setName(tempName);
                                ((Hotel) tempService).setFoodType(tempArr[4]);
                                break;
                            case "T":
                                tempService = new Transfer(tempName, tempPrice, tempCount, tempArr[6], tempArr[7], Integer.parseInt(tempArr[4]));
                                ((Transfer) tempService).setType(tempArr[5]);
                                break;
                            default://"I"
                                tempService = new Insurance(tempName, tempPrice, tempCount);
                        }

                    } catch (IndexOutOfBoundsException ex) {

                        break;
                    }
                    //add service to order
                    order.addService(tempService);
                    tempStr = in.hasNext() ? in.nextLine() : "";
                    pos = tempStr.indexOf(">\t");
                }
            }
            //add order to result
            result.add(order);
        }
        in.close();
        return result;
    }

    public void addService(OrderService service) {
        services.add(service);
    }


    public static void main(String[] args) {

        List<OrderService> list = new ArrayList<OrderService>();
        Hotel hotel = new Hotel(250, 1);
        hotel.setFoodType(HotelFood.OB);
        Transfer avia = new Transfer("avia", 100, "Kyiv", "London");
        avia.setType(TransferType.AVIA);
        list.add(hotel);
        list.add(avia);
        Order order = new Order(list);
        try {
            order.saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
}

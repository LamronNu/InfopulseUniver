package labs.task1_OOP;

import labs.task1_OOP.services.Hotel;
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
    //fields -- properties
    private String name;
    private static int counter = 0;

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
    public void saveToFile() throws IOException {
        checkCounter();
        PrintWriter out = new PrintWriter(new FileWriter("src\\labs\\task1_OOP\\utils\\files\\orders.txt", true));
        out.println(++counter);
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

    private void checkCounter() throws FileNotFoundException {//todo RandomAccessFile
        Scanner in = new Scanner(new File("src\\labs\\task1_OOP\\utils\\files\\orders.txt"));
        counter = in.nextInt();
        in.close();
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
}

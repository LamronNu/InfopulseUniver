package labs.task1_OOP;

import labs.task1_OOP.services.Hotel;
import labs.task1_OOP.services.Insurance;
import labs.task1_OOP.services.OrderService;
import labs.task1_OOP.services.Transfer;
import labs.task1_OOP.utils.enums.HotelFood;
import labs.task1_OOP.utils.enums.TransferType;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static labs.task1_OOP.utils.enums.HotelFood.*;

public class Consultant {
    //private static final Logger log = Logger.getLogger(Consultant.class);
    private String clientName = "Client";
    private String name;
    private Order order;
    private Scanner scanner;

    public Consultant() {
        this("Cat Simon", new Order());
    }

    public Consultant(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    public void startWork(){
        scanner = new Scanner(System.in);
        //introducing
        System.out.println("Hello! My name is " + name + ".");
        System.out.println("I like to travel around the world, so can help you to choose the best tourism route!");
        System.out.println("Let's introduce ourselves.So, what is your name?");
        clientName = scanner.next();


        System.out.println("Hello, " + clientName + "! \nI'm glad to see you! What order you want to create today?");
        int choice = -1;

        while (choice != 0) {
            //main menu
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Rename order");
            System.out.println("2. Add service");
            System.out.println("3. Edit service");
            System.out.println("4. Show total order");
            System.out.println("0. Exit");

            choice = getChoice();
            //while (choice != 0) {
            switch(choice) {
                case 1:
                    System.out.print("Enter new name (ONE word): ");
                    String tempName = "";
                    //while (scanner.hasNext() && scanner.next() != "\n"){
                        tempName = scanner.next();
                    //}
                    order.setName(tempName);
                    System.out.println();
                    System.out.println("Successfully rename order to " + tempName + "!");
                    System.out.println();
                break;
                case 2://2. Add service
                    //variables
                    Hotel hotel;
                    int days;
                    Transfer transfer;
                    String type = "AVIA";
                    Insurance insurance;
                    //showAllServices() -- all
                    //System.out.println("you choose " + choice);
                    while (choice != 9) {
                        System.out.println("1. Add hotel (Standart -- $100 per day)");
                        System.out.println("2. Add hotel (Econom -- $70 per day)");
                        System.out.println("3. Add avia-transfer (business class -- $250, Kyiv -- London)");
                        System.out.println("4. Add avia-transfer (econom class -- $150, Kyiv -- London)");
                        System.out.println("5. Add avia-transfer (choose cities)");
                        System.out.println("6. Add transfer (choose cities and type)");
                        System.out.println("7. Add Insurance");
                        System.out.println("\nThere are all our services.\n" +
                                "Please, choose one of them (or enter 9 for return to main menu)");
                        choice = getChoice();

                        switch (choice) {
                            case 1://Add hotel (Standart -- $100 per day
                            case 2://Add hotel (Econom -- $70 per day)");
                                hotel = new Hotel((choice == 1 ? 100 : 70), 1);
                                //count
                                System.out.println("How long you plan to be (in days)?");
                                days = getChoice();
                                try {
                                    hotel.setCount(days);
                                } catch (IllegalArgumentException ex){
                                    System.out.println(ex.getMessage());
                                }
                                //food
                                System.out.println("The default food type is BO. Do you want to change it?");
                                System.out.println("1. No, BO (Only Bed) is ok");
                                System.out.println("2. Yes, change to BB (Bed and Breakfast, + $15/day)");
                                System.out.println("3. Yes, change to HB (Half Board, + $30/day)");
                                System.out.println("4. Yes, change to FB (Full Board, + $50/day)");
                                choice = getChoice();
                                switch (choice){
                                    case 1:
                                        break;
                                    case 2:
                                        hotel.setFoodType(BB);
                                        hotel.addPrice(15);
                                        break;
                                    case 3:
                                        hotel.setFoodType(HB);
                                        hotel.addPrice(30);
                                        break;
                                    case 4:
                                        hotel.setFoodType(FB);
                                        hotel.addPrice(50);
                                        break;
                                }
                                order.addService(hotel);
                                System.out.println("Hotel is reserved.");
                                System.out.println("Your hotel is: " + hotel);
                                System.out.println("---------------");
                                break;
                            case 3:      //3.Add avia-transfer (business class -- $250, Kyiv -- London)");
                            case 4:     //4. Add avia-transfer (econom class -- $150, Kyiv -- London)");
                                transfer = new Transfer("avia", (choice == 3 ? 250 : 150), "Kyiv", "London");
                                transfer.setType(TransferType.AVIA);
                                order.addService(transfer);
                                System.out.println("Avia-transfer is reserved.");
                                System.out.println("Your transfer is: " + transfer);
                                System.out.println("---------------");
                                break;
                            case 6: //System.out.println("5. Add avia-transfer (choose cities)");
                                System.out.println("enter type (AUTO, AVIA, BUS, TRAIN, SHIP): ");
                                type = scanner.next();
                            case 5: //System.out.println("6. Add transfer (choose cities and type)");
                                String pointFrom;
                                String pointTo;
                                System.out.print("enter pointFrom: ");
                                pointFrom = scanner.next();
                                System.out.println();
                                System.out.print("enter pointTo: ");
                                pointTo = scanner.next();
                                try {
                                    transfer = new Transfer(type + "-transfer", new Random().nextInt(300), pointFrom, pointTo);
                                    transfer.setType(type);
                                } catch (IllegalArgumentException ex){
                                    System.out.println(ex.getMessage());
                                    System.out.println("try again");
                                    break;
                                }
                                order.addService(transfer);
                                System.out.println(type + "-transfer is reserved.");
                                System.out.println("Your transfer is: " + transfer);
                                System.out.println("---------------");
                                break;
                            case 7:
                                insurance = new Insurance(new Random().nextInt(100));
                                order.addService(insurance);
                                System.out.println("insurance is reserved.");
                                System.out.println("Your insurance is: " + insurance);
                                System.out.println("---------------");
                            case 8:
                                System.out.println("Wrong option! try again.");
                                break;
                            case 9:
                                break;
                        }
                        System.out.println("Add another service? 1-yes/2-no");
                        choice = getChoice();
                        choice = choice != 2 ? -1 : 9;
                    }
                    break;

                case 3://3. Edit service
                    // showAllSelectedServices() -- all
                    System.out.println("----------------------------");
                    System.out.println(order.getServicesStr());
                    System.out.println("----------------------------");
                    System.out.println("\nThere are all your services.\n" +
                            "Please, choose one of them for editing (or enter 0 for return to main menu)");
                    choice = getChoice();
                    if (choice <= 0) break;
//                    System.out.println("you choose " + choice);
                    choice--;
                    OrderService editService;
                    try {
                        editService = order.getService(choice);
                    } catch (IndexOutOfBoundsException ex){
                        System.out.println(ex.getMessage());
                        break;
                    }
                    if (!(editService instanceof Hotel)
                            &&!(editService instanceof Transfer)){
                        System.out.println("You can edit only hotel and transfer, not " + editService.getClass().getSimpleName() + "!");
                        break;
                    }
                    System.out.println(editService);
                    System.out.println("What option you want edit?");
                    if (editService instanceof Hotel){
                        hotel = (Hotel) editService;
                        System.out.println("1. Count of days");
                        HotelFood food = hotel.getFoodType();
                        double diff = 0;
                        switch (food){
                            case OB: diff = 0; break;
                            case BB: diff = -15; break;
                            case HB: diff = -30; break;
                            case FB: diff = -50; break;
                        }
                        if (food != OB) {
                            System.out.println("2. Change food to OB (Only Bed), " + formatDiff(diff));
                        }
                        if (food != BB) {
                            System.out.println("3. Change food to BB (Bed and Breakfast), " + formatDiff(diff+15));
                        }
                        if (food != HB) {
                            System.out.println("4. Change food to HB (Half Board), " + formatDiff(diff+30));
                        }
                        if (food != FB) {
                            System.out.println("5. Change food to FB (Full Board), " + formatDiff(diff+50));
                        }
                        choice = getChoice();
                        switch (choice){
                            case 1:
                                System.out.print("Enter days:");
                                days = scanner.nextInt();
                                System.out.println();
                                try {
                                    hotel.setCount(days);
                                } catch (IllegalArgumentException ex){
                                    System.out.println(ex.getMessage());
                                }
                                break;
                            case 2:
                                hotel.setFoodType(OB);
                                hotel.addPrice(diff);
                                break;
                            case 3:
                                hotel.setFoodType(BB);
                                hotel.addPrice(diff + 15);
                                break;
                            case 4:
                                hotel.setFoodType(HB);
                                hotel.addPrice(diff + 30);
                                break;
                            case 5:
                                hotel.setFoodType(FB);
                                hotel.addPrice(diff + 50);
                                break;
                        }
                        System.out.println("Hotel is edited.");
                        System.out.println("Your hotel is: " + hotel);
                        System.out.println("---------------");
                    } else
                    if (editService instanceof Transfer){
                        transfer = (Transfer) editService;
                        System.out.println("1. Transfer type (AUTO, AVIA, BUS, TRAIN, SHIP)");
                        System.out.println("2. Point from");
                        System.out.println("3. Point to");
                        choice = getChoice();
                        System.out.print("enter new value: ");
                        type = scanner.next();
                        //System.out.println();
                        try {
                            switch (choice){
                                case 1:     transfer.setType(type);         break;
                                case 2:     transfer.setPointFrom(type);    break;
                                case 3:     transfer.setPointTo(type);      break;
                            }
                        } catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                            System.out.println("try again");
                            break;
                        }
                        System.out.println("Transfer is edited.");
                        System.out.println("Your transfer is: " + transfer);
                        System.out.println("---------------");
                    }
                    break;

                case 4://4. Show total order
                    //showOrder()
                    while (choice == 4) {
                        System.out.println("----------------------------");
                        System.out.println(order.getServicesStr());
                        System.out.println("Total amount = " + order.getTotalAmount());
                        System.out.println("----------------------------");
                        System.out.println("\nThere is your order.\n" +
                                "What you want to do with it?");
                        System.out.println("1. Sort services by name");
                        System.out.println("2. Sort services by price");
                        System.out.println("3. Sort services by amount");
                        System.out.println("9. Exit to previous menu");
                        System.out.println("0. Exit");
                        choice = getChoice();
                        switch (choice) {
                            case 1:  //1. Sort services by name
                                order.sortByServiceName();
                                choice = 4;
                                break;
                            case 2:   //2. Sort services by price
                                order.sortByServicePrice();
                                choice = 4;
                                break;
                            case 3:  //3. Sort services by amount
                                order.sortByServiceAmount();
                                choice = 4;
                                break;
                            case 4:   //4. Save order as template
                                choice = 9;
                            case 9:
                                //break;
                            case 0:
                                default:
                                break;
                        }
                    }
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    break;
            }
            choice = -1;
        }

        scanner.close();
    }

    private String formatDiff(double diff) {
        return (diff > 0 ? "+" : "-") + "$" + Math.abs(diff) + "/day";
    }

    private int getChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong option!");
            scanner.next();
            choice = -1;
        }
        return choice;
    }
}

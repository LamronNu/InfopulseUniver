package labs.task1_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consultant {
    //private static final Logger log = Logger.getLogger(Consultant.class);
    private String clientName;
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
            System.out.println("1. Show variants");
            System.out.println("2. Add service");
            System.out.println("3. Edit service");
            System.out.println("4. Show total order");
            System.out.println("0. Exit");

            choice = getChoice();

            switch(choice) {
                case 1:  //1st menu "Show variants"
                    System.out.println("\nWe have some complete orders, but you can create your own tour.\n" +
                            "So, what is your choice?");
                    System.out.println("1. Show complete orders");
                    System.out.println("2. Show all services (I want create my own order)");
                    System.out.println("9. Exit to previous menu");
                    System.out.println("0. Exit");
                    choice = getChoice();
                    switch (choice){
                        case 1:  //showCompleteOrders() -- by 8
                            System.out.println("----------------------------");
                            System.out.println("showCompleteOrders() -- by 8");//todo
                            System.out.println("----------------------------");
                            System.out.println("\nThere are some complete orders.\n" +
                            "So, what is your choice (enter the number of Order or 0 for return to main menu)?");
                            choice = getChoice();
                            System.out.println("you choose " + choice);
                            break;
                        case 2:   //showAllServices() -- all
                            System.out.println("----------------------------");
                            System.out.println("showAllServices() -- all");//todo
                            System.out.println("----------------------------");
                            System.out.println("\nThere are all our services.\n" +
                                    "Please, choose one (or ones) of them (or enter 9 for return to main menu)");
                            choice = getChoice();//todo multiply choise
                            System.out.println("you choose " + choice);
                            break;
                        case 9:
                            //break;
                        case 0:
                            break;
                    }
                    break;

                case 2://2. Add service
                    //showAllServices() -- all
                    System.out.println("----------------------------");
                    System.out.println("--showAllServices() -- all");//todo
                    System.out.println("----------------------------");
                    System.out.println("\nThere are all our services.\n" +
                            "Please, choose one (or ones) of them (or enter 9 for return to main menu)");
                    choice = getChoice();//todo multiply choise
                    System.out.println("you choose " + choice);
                    break;

                case 3://3. Edit service
                // showAllSelectedServices() -- all
                    System.out.println("----------------------------");
                    System.out.println("showAllSelectedServices() -- all");//todo
                    System.out.println("----------------------------");
                    System.out.println("\nThere are all your services.\n" +
                            "Please, choose one of them for editing (or enter 9 for return to main menu)");
                    choice = getChoice();
                    System.out.println("you choose " + choice);
                    break;

                case 4://4. Show total order
                    //showOrder()
                    System.out.println("----------------------------");
                    System.out.println("------showOrder()");//todo
                    System.out.println("----------------------------");
                    System.out.println("\nThere is your order.\n" +
                        "What you want to do with it?");
                    System.out.println("1. Sort services by name");
                    System.out.println("2. Sort services by price");
                    System.out.println("3. Sort transfers by duration");
                    System.out.println("4. Save order as template");
                    System.out.println("9. Exit to previous menu");
                    System.out.println("0. Exit");
                    choice = getChoice();
                    switch (choice){
                        case 1:  //1. Sort services by name
                            choice = 4;//but to function showOrder send parameters

                            break;
                        case 2:   //2. Sort services by price
                            choice = 4;//but to function showOrder send parameters
                            break;
                        case 3:  //3. Sort transfers by duration
                            choice = 4;//but to function showOrder send parameters
                            break;
                        case 4:   //4. Save order as template
                            //save and return to main menu
                        case 9:
                            //break;
                        case 0:
                            break;
                    }
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }

        scanner.close();
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

    public static void main(String[] args) {
        new Consultant().startWork();
    }
}

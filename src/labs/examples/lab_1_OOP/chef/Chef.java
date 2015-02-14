package labs.examples.lab_1_OOP.chef;

import java.lang.reflect.Constructor;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class realizes the main logic of the program, provides methods to
 * create salad, manage its ingredients, sort ingredients.
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class Chef {
    private String name; // chef's name
    private Salad salad; // salad that he cooks

    /**
     * Default constructor. Chef's name is Bob, he cooks unknown salad.
     */
    public Chef() {
        name = "Bob";
        salad = new Salad();
    }

    /**
     * Constructor with parameter. Find another chef - named 'name'.
     * @param name the name of the chef
     */
    public Chef(String name) {
        this.name = name;
        salad = new Salad();
    }

    /**
     * Constructor with parameters 'name' - chef's name, 'salad' - salad to
     * work with.
     * @param name chef's name
     * @param salad the salad to work with
     */
    public Chef(String name, Salad salad) {
        this.name = name;
        this.salad = salad;
    }

    /**
     * Creates ingredient by parameters entered by user from the console.
     * @param scanner where to read the input parameters
     * @return returns a reference to a newly created Vegetable or null if
     * it was not created
     */
    public Vegetable getIngredient(Scanner scanner) {
        String ingredientName;
        double weight;

        System.out.println("Enter the ingredient name:");
        ingredientName = scanner.next();

        System.out.println("Enter the weight (in gramms):");

        try {
            weight = scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong weight!");
            scanner.next();

            return null;
        }

        // create new vegetable using reflection
        try {
            Class [] parameters = {double.class};
            ingredientName = "labs.examples.lab_1_OOP.chef." + ingredientName;
            Class ingredientClass = Class.forName(ingredientName);
            Constructor constructor =
                    ingredientClass.getDeclaredConstructor(parameters);
            Vegetable vegetable = (Vegetable) constructor.newInstance(
                    new Object[]{new Double(weight)});

            return vegetable;
        }
        catch (Exception e) {
            System.out.println("No such ingredient!");
            System.err.println(e);
            return null;
        }
    }

    /**
     * Displays the ingredients for a given range of calories.
     * @param scanner the input source
     */
    public void showIngredientsForCalories(Scanner scanner) {
        double lowerCalories, upperCalories;

        System.out.println("Enter the lower limit:");
        try {
            lowerCalories = scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input!");
            scanner.next();

            return;
        }

        System.out.println("Enter the upper limit:");
        try {
            upperCalories = scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input!");
            scanner.next();

            return;
        }

        salad.showIngredientsByCalories(lowerCalories, upperCalories);
    }

    /**
     * Shows all the available options for user.
     */
    public void showOptions() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        Vegetable vegetable = null;

        System.out.println("Hello! My name is " + name + ".");
        System.out.println("What do you want to cook today?");

        while (choice != 0) {
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Rename salad");
            System.out.println("2. Show recipe");
            System.out.println("3. Add ingredient");
            System.out.println("4. Sort ingredients by calories");
            System.out.println("5. Sort ingredients by weight");
            System.out.println("6. Get ingredients for calories");
            System.out.println("0. Exit");

            try {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Wrong option!");
                scanner.next();
                choice = -1;
            }

            switch(choice) {
                case 1:
                    System.out.println("Name your salad:");
                    salad.setname(scanner.next());
                    break;

                case 2:
                    salad.showRecipe();
                    break;

                case 3:
                    vegetable = getIngredient(scanner);
                    if (vegetable != null) {
                        if (!salad.addIngredient(vegetable)) {
                            System.out.println("Cannot add ingredient!");
                        }
                    }
                    break;

                case 4:
                    salad.sortIngredientsByCalories();
                    break;

                case 5:
                    salad.sortIngredientsByWeight();
                    break;

                case 6:
                    showIngredientsForCalories(scanner);
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
}

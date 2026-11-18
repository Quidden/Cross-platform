package Lab4.menus;

import java.util.HashMap;
import java.util.Scanner;

public class Warehouse {
    private final HashMap<String, Integer> warehouse = new HashMap<>();

    public int ChooseMenu(Scanner scanner){
        System.out.println("Choose options 1-5:");
        System.out.println("1. show ingredients");
        System.out.println("2. add ingredients");
        System.out.println("3. update quantity ingredients");
        System.out.println("4. delete ingredients");
        System.out.println("5. Exit");
        if (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            scanner.nextLine();
            return -1;
        }
        int choose = scanner.nextInt();
        scanner.nextLine();
        if (choose < 1 || choose > 5) {
            System.out.println("Invalid option!");
            return -1;
        }
        return choose;
    }

    public void showWarehouse(){
        if (warehouse.isEmpty()){
            System.out.println("Warehouse is empty");
            return;
        }
        System.out.println(warehouse);
    }

    public void addIngredients(String name, int quantity){
        if (name == null || name.isBlank()) {
            System.out.println("Invalid ingredient name");
            return;
        }
        if (warehouse.containsKey(name)) {
            System.out.println("Ingredient does exist");
            return;
        }
        if (quantity < 1){
            System.out.println("incurrent quantity");
            return;
        }
        warehouse.put(name, quantity);
    }

    public void updateQuantity(String name, int quantity){
        if (!warehouse.containsKey(name)) {
            System.out.println("Ingredient does not exist");
            return;
        }
        if (quantity < 1){
            System.out.println("incurrent quantity");
            return;
        }
        warehouse.put(name, quantity);
    }


    public void deleteIngredients(String name){
        if (warehouse.get(name) == null){
            System.out.println("Incorrect name");
            return;
        }
        warehouse.remove(name);
    }
}

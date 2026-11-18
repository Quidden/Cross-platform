package Lab4.menus;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

public class Orders {
    private final LinkedList<String> Order = new LinkedList<>();

    public int ChooseMenu(Scanner scanner){
        System.out.println("Choose options 1-5:");
        System.out.println("1. show Orders");
        System.out.println("2. add Order");
        System.out.println("3. delete Order");
        System.out.println("4. Update order");
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
    public void ShowOrder(){
        if (Order.isEmpty()) {
            System.out.println("No orders");
            return;
        }
        for (int index = 0; index < Order.size(); index++) {
            System.out.println(index + ": " + Order.get(index));
        }
    }

    public void addOrder(String position){
        if (position == null || position.isBlank()) {
            System.out.println("Invalid position name");
            return;
        }
        Order.add(position.trim());
        System.out.println("Order added");
    }

    public void deleteOrder(int index){
        if (index < 0 || index >= Order.size()) {
            System.out.println("Order does not exist");
            return;
        }
        Order.remove(index);
        System.out.println("Order deleted");
    }

    public void updateOrder(int index, String position) {
        if (index < 0 || index >= Order.size()) {
            System.out.println("Order does not exist");
            return;
        }
        if (position == null || position.isBlank()) {
            System.out.println("Invalid position name");
            return;
        }
        Order.set(index, position.trim());
        System.out.println("Order updated");
    }

    public void statistic(){
        if (Order.isEmpty()) {
            System.out.println("No orders");
            return;
        }
        HashMap<String, Integer> statistics = new HashMap<>();
        for (String position : Order) {
            statistics.put(position, statistics.getOrDefault(position, 0) + 1);
        }
        for (String position : statistics.keySet()) {
            System.out.println(position + " - " + statistics.get(position));
        }
    }
}

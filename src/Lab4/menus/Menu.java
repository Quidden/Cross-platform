package Lab4.menus;

import java.util.Scanner;
import java.util.TreeMap;

public class Menu {

    private final TreeMap<String, TreeMap<String, Double>> menu = new TreeMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public int chooseMenu() {
        System.out.println("\nChoose option 1-4:");
        System.out.println("1. Show categories");
        System.out.println("2. Add category");
        System.out.println("3. Delete category");
        System.out.println("4. Exit");

        if (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            scanner.nextLine();
            return -1;
        }

        int choose = scanner.nextInt();
        scanner.nextLine();

        if (choose < 1 || choose > 4) {
            System.out.println("Invalid option!");
            return -1;
        }

        return choose;
    }

    public void showMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menu is empty");
            return;
        }

        for (String category : menu.keySet()) {
            System.out.println("\nCategory: " + category);

            TreeMap<String, Double> positions = menu.get(category);

            if (positions.isEmpty()) {
                System.out.println("No positions");
                continue;
            }

            for (String position : positions.keySet()) {
                System.out.println(position + " - " + positions.get(position));
            }
        }
    }

    public void showCategories(String name) {
        if (!menu.containsKey(name)) {
            System.out.println("Category does not exist");
            return;
        }

        TreeMap<String, Double> positions = menu.get(name);

        if (positions.isEmpty()) {
            System.out.println("Category is empty");
            return;
        }

        for (String position : positions.keySet()) {
            System.out.println(position + " - " + positions.get(position));
        }
    }

    public void addCategories(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid category name");
            return;
        }

        if (menu.containsKey(name)) {
            System.out.println("Category already exists");
            return;
        }

        menu.put(name, new TreeMap<>());
        System.out.println("Category added");
    }

    public void addPosition(String nameCategories, String name, double price) {
        if (!menu.containsKey(nameCategories)) {
            System.out.println("Category does not exist");
            return;
        }

        if (name == null || name.isBlank()) {
            System.out.println("Invalid position name");
            return;
        }

        if (!Double.isFinite(price) || price < 0) {
            System.out.println("Invalid price");
            return;
        }

        if (menu.get(nameCategories).containsKey(name)) {
            System.out.println("Position already exists");
            return;
        }

        menu.get(nameCategories).put(name, price);
        System.out.println("Position added");
    }

    public void deleteCategories(String name) {
        if (!menu.containsKey(name)) {
            System.out.println("Category does not exist");
            return;
        }

        menu.remove(name);
        System.out.println("Category deleted");
    }

    public void deleteElement(String nameCategories, String namePosition) {
        if (!menu.containsKey(nameCategories) ||
                !menu.get(nameCategories).containsKey(namePosition)) {
            System.out.println("Element does not exist");
            return;
        }

        menu.get(nameCategories).remove(namePosition);
        System.out.println("Element deleted");
    }
}
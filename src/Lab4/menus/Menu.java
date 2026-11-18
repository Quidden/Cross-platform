package Lab4.menus;

import java.util.Scanner;
import java.util.TreeMap;

public class Menu {

    private final TreeMap<String, TreeMap<String, Double>> menu = new TreeMap<>();

    public int chooseMenu(Scanner scanner) {
        System.out.println("\nChoose option 1-9:");
        System.out.println("1. Show full menu");
        System.out.println("2. Add category");
        System.out.println("3. Delete category");
        System.out.println("4. Show positions in category");
        System.out.println("5. Add position");
        System.out.println("6. Delete position");
        System.out.println("7. Update price");
        System.out.println("8. Rename category");
        System.out.println("9. Exit");

        if (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            scanner.nextLine();
            return -1;
        }

        int choose = scanner.nextInt();
        scanner.nextLine();

        if (choose < 1 || choose > 9) {
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

    public boolean containsPosition(String name) {
        if (name == null || name.isBlank()) return false;
        for (TreeMap<String, Double> positions : menu.values()) {
            if (positions.containsKey(name.trim())) return true;
        }
        return false;
    }

    public void updatePrice(String category, String position, double price) {
        if (!menu.containsKey(category) || !menu.get(category).containsKey(position)) {
            System.out.println("Element does not exist");
            return;
        }
        if (!Double.isFinite(price) || price < 0) {
            System.out.println("Invalid price");
            return;
        }
        menu.get(category).put(position, price);
        System.out.println("Price updated");
    }

    public void renameCategory(String name, String newName) {
        if (!menu.containsKey(name)) {
            System.out.println("Category does not exist");
            return;
        }
        if (newName == null || newName.isBlank()) {
            System.out.println("Invalid category name");
            return;
        }
        if (menu.containsKey(newName)) {
            System.out.println("Category already exists");
            return;
        }
        menu.put(newName, menu.remove(name));
        System.out.println("Category renamed");
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

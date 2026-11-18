package Lab4;

import Lab4.menus.Menu;
import Lab4.menus.Orders;
import Lab4.menus.Reserv;
import Lab4.menus.Warehouse;

import java.util.Scanner;

public class Main {
    private static Integer readInteger(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("Please enter a whole number!");
            if (scanner.hasNextLine()) scanner.nextLine();
            return null;
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Reserv reserv = new Reserv();
        Orders orders = new Orders();
        Warehouse warehouse = new Warehouse();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.println("Choose options 1-6:");
            System.out.println("1. Menu");
            System.out.println("2. Reserv");
            System.out.println("3. Orders");
            System.out.println("4. Warehouse");
            System.out.println("5. Statistic");
            System.out.println("6. Exit");
            if (!scanner.hasNextLine()) break;
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                scanner.nextLine();
                continue;
            }
            int choose = scanner.nextInt();
            scanner.nextLine();


            switch(choose){
                case 1:
                    int menuChoice = menu.chooseMenu(scanner);
                    switch(menuChoice){
                        case 1:
                            menu.showMenu();
                            break;
                        case 2:
                            System.out.println("write category name:");
                            String name = scanner.nextLine();
                            menu.addCategories(name);
                            break;
                        case 3:
                            System.out.println("write category name:");
                            String nameDel = scanner.nextLine();
                            menu.deleteCategories(nameDel);
                            break;
                        case 4:
                            System.out.println("write category name:");
                            menu.showCategories(scanner.nextLine());
                            break;
                        case 5:
                        case 7:
                            System.out.println("write category name:");
                            String category = scanner.nextLine();
                            System.out.println("write position name:");
                            String position = scanner.nextLine();
                            System.out.println("write price:");
                            if (!scanner.hasNextDouble()) {
                                System.out.println("Invalid price");
                                scanner.nextLine();
                                break;
                            }
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            if (menuChoice == 5) {
                                menu.addPosition(category, position, price);
                            } else {
                                menu.updatePrice(category, position, price);
                            }
                            break;
                        case 6:
                            System.out.println("write category name:");
                            String categoryDel = scanner.nextLine();
                            System.out.println("write position name:");
                            menu.deleteElement(categoryDel, scanner.nextLine());
                            break;
                        case 8:
                            System.out.println("write category name:");
                            String oldName = scanner.nextLine();
                            System.out.println("write new category name:");
                            menu.renameCategory(oldName, scanner.nextLine());
                            break;
                        case 9:
                            break;
                    }
                    break;
                case 2:
                    switch(reserv.ChooseMenu(scanner)){
                        case 1:
                            reserv.ShowReserv();
                            break;
                        case 2:
                            System.out.println("write index:");
                            Integer indexadd = readInteger(scanner);
                            if (indexadd != null) reserv.addElement(indexadd);
                            break;
                        case 3:
                            System.out.println("write index");
                            Integer indexdel = readInteger(scanner);
                            if (indexdel != null) reserv.deleteElement(indexdel);
                            break;
                        case 4:
                            System.out.println("write current table number:");
                            Integer oldTable = readInteger(scanner);
                            if (oldTable == null) break;
                            System.out.println("write new table number:");
                            Integer newTable = readInteger(scanner);
                            if (newTable != null) reserv.updateReservation(oldTable, newTable);
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 3:
                    switch (orders.ChooseMenu(scanner)) {
                        case 1:
                            orders.ShowOrder();
                            break;
                        case 2:
                            System.out.println("write position name:");
                            String orderPosition = scanner.nextLine().trim();
                            if (!menu.containsPosition(orderPosition)) {
                                System.out.println("Position does not exist in menu");
                                break;
                            }
                            orders.addOrder(orderPosition);
                            break;
                        case 3:
                            System.out.println("write order index (starting from 0):");
                            if (!scanner.hasNextInt()) {
                                System.out.println("Please enter a number!");
                                scanner.nextLine();
                                break;
                            }
                            int orderIndex = scanner.nextInt();
                            scanner.nextLine();
                            orders.deleteOrder(orderIndex);
                            break;
                        case 4:
                            System.out.println("write order index (starting from 0):");
                            Integer updateIndex = readInteger(scanner);
                            if (updateIndex == null) break;
                            System.out.println("write new position name:");
                            String newPosition = scanner.nextLine().trim();
                            if (!menu.containsPosition(newPosition)) {
                                System.out.println("Position does not exist in menu");
                                break;
                            }
                            orders.updateOrder(updateIndex, newPosition);
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 4:
                    int warehouseChoice = warehouse.ChooseMenu(scanner);
                    switch (warehouseChoice) {
                        case 1:
                            warehouse.showWarehouse();
                            break;
                        case 2:
                        case 3:
                            System.out.println("write ingredient name:");
                            String ingredient = scanner.nextLine();
                            System.out.println("write quantity:");
                            if (!scanner.hasNextInt()) {
                                System.out.println("Please enter a whole number!");
                                scanner.nextLine();
                                break;
                            }
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            if (warehouseChoice == 2) {
                                warehouse.addIngredients(ingredient, quantity);
                            } else {
                                warehouse.updateQuantity(ingredient, quantity);
                            }
                            break;
                        case 4:
                            System.out.println("write ingredient name:");
                            warehouse.deleteIngredients(scanner.nextLine());
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 5:
                    orders.statistic();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }while(flag);
    }
}

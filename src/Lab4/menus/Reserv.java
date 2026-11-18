package Lab4.menus;

import java.util.HashSet;
import java.util.Scanner;

public class Reserv {
    private final HashSet<Integer> reservedTables = new HashSet<>();

    public int ChooseMenu(Scanner scanner){
        System.out.println("Choose options 1-5:");
        System.out.println("1. show reserv");
        System.out.println("2. add reserv");
        System.out.println("3. delete reserv");
        System.out.println("4. Change table");
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
    public void ShowReserv(){
        System.out.println(reservedTables);
    }
    public void addElement(int index){
        if(index < 1){
            System.out.println("index error <1");
            return;
        }
        if(reservedTables.contains(index)){
            System.out.println("element exist");
            return;
        }
        reservedTables.add(index);
        System.out.println("Table reserved");
    }
    public void updateReservation(int oldIndex, int newIndex) {
        if (!reservedTables.contains(oldIndex)) {
            System.out.println("Reservation does not exist");
            return;
        }
        if (newIndex < 1) {
            System.out.println("index error <1");
            return;
        }
        if (oldIndex != newIndex && reservedTables.contains(newIndex)) {
            System.out.println("element exist");
            return;
        }
        reservedTables.remove(oldIndex);
        reservedTables.add(newIndex);
        System.out.println("Reservation updated");
    }
    public void deleteElement(int index){
       if(reservedTables.contains(index)){
           reservedTables.remove(index);
           System.out.println("element deleted");
           return;
       }
       System.out.println("element does not exist");
    }
}

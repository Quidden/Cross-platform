package Lab4.menus;

import java.util.HashSet;
import java.util.Scanner;

public class Reserv {
    HashSet<Integer> reservedTables = new HashSet<>();

    public int ChooseMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose options 1-5:");
        System.out.println("1. show reserv");
        System.out.println("2. add reserv");
        System.out.println("3. delete reserv");
        System.out.println("4. Exit");
        int choose = scanner.nextInt();
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

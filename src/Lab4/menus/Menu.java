package Lab4.menus;

import java.util.Scanner;
import java.util.TreeMap;

public class Menu {

    private TreeMap<String, Double> menu = new TreeMap<>();

    public int ChooseMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose options 1-5:");
        System.out.println("1. show position");
        System.out.println("2. add position");
        System.out.println("3. delete position");
        System.out.println("4. Exit");
        int choose = scanner.nextInt();
        return choose;
    }
    public void ShowMenu(){
        System.out.println(menu);
    }
    public void addElement(String name, double price){
        if(price < 0){
            System.out.println("price error <0");
            return;
        }
        menu.put(name, price);
    }
    public void deleteElement(String name){
        if (!menu.containsKey(name)){
            System.out.println("element does not exist");
            return;
        }
        menu.remove(name);
        System.out.println("element deleted");
    }
}

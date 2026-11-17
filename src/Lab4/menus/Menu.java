package Lab4.menus;

import java.util.Scanner;
import java.util.TreeMap;

public class Menu {

    private TreeMap<String, TreeMap<String, Double>> menu = new TreeMap<>();

    public int ChooseMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose options 1-5:");
        System.out.println("1. show categories");
        System.out.println("2. add categories");
        System.out.println("3. delete categories");
        System.out.println("4. Exit");
        int choose = scanner.nextInt();
        return choose;
    }
    public void ShowMenu(){
        System.out.println(menu);
    }
    public void ShowCategories(String key){
        System.out.println(menu.get(key));
    }
    public void addCategories(String name){
        menu.put(name, new TreeMap<>());
    }
    public void addPosition(String name, double price){
        
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

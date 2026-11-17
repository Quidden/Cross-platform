package Lab4.menus;

import java.util.LinkedList;
import java.util.Scanner;

public class Orders {
    LinkedList<String> Order = new LinkedList<>();

    public int ChooseMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose options 1-5:");
        System.out.println("1. show Orders");
        System.out.println("2. add Order");
        System.out.println("3. delete Order");
        System.out.println("4. Exit");
        int choose = scanner.nextInt();
        return choose;
    }
    public void ShowOrder(){
        System.out.println(Order);
    }

    public void addOrder(String position){
        Order.add(position);
    }

    public void deleteOrder(int index){
        if (Order.contains(index)) {
            Order.remove(index);
        }
        else{
            System.out.println("Element is not exist");
        }
    }
}

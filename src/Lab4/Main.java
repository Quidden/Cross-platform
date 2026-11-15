package Lab4;

import Lab4.menus.Menu;
import Lab4.menus.Reserv;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Reserv reserv = new Reserv();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.println("Choose options 1-5:");
            System.out.println("1. Menu");
            System.out.println("2. Reserv");
            System.out.println("3. Orders");
            System.out.println("4. Warehouse");
            System.out.println("5. Statistic");
            System.out.println("6. Exit");
            int choose = scanner.nextInt();


            switch(choose){
                case 1:
                    switch(menu.ChooseMenu()){
                        case 1:
                            menu.ShowMenu();
                            break;
                        case 2:
                            System.out.println("write name:");
                            String name = scanner.next();
                            System.out.println("write price:");
                            double price = scanner.nextDouble();
                            menu.addElement(name, price);
                            break;
                        case 3:
                            System.out.println("write name");
                            String nameDel = scanner.next();
                            menu.deleteElement(nameDel);
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 2:
                    switch(reserv.ChooseMenu()){
                        case 1:
                            reserv.ShowReserv();
                            break;
                        case 2:
                            System.out.println("write index:");
                            int indexadd = scanner.nextInt();
                            reserv.addElement(indexadd);
                            break;
                        case 3:
                            System.out.println("write index");
                            int indexdel = scanner.nextInt();
                            reserv.deleteElement(indexdel);
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }while(flag);
    }
}

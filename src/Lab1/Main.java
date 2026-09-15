package Lab1;

import java.util.Scanner;

class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Price per unit");
        double price = scanner.nextDouble();
        System.out.println("Quantity of merchandise");
        int quantity = scanner.nextInt();
        System.out.println("Discount card? true/false");
        Boolean discountCard = scanner.nextBoolean();

        double total = price * quantity;
        if (discountCard || total > 1000) {
            total -= total/100 * 10;
        }
        System.out.println("Total: " + total);
    }
}
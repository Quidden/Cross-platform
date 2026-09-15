package Lab1;

import java.util.Scanner;
//var 2
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter total hours:");
        int totalHour = scanner.nextInt();
        System.out.println("Enter price per hour:");
        double pricePerHour = scanner.nextDouble();
        int NumberOfTheDay;
        double bonus = 1.0;
        boolean isInvalidInput = true;

        System.out.println("Enter day of the week (1-7):");
        do {
            if(!isInvalidInput){
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
            }
            NumberOfTheDay = scanner.nextInt();
            isInvalidInput = false;
        } while (NumberOfTheDay < 1 || NumberOfTheDay > 7);

        switch (NumberOfTheDay){
            case 1,2,3,4,5 -> bonus = 1.0;
            case 6 -> bonus = 1.2;
            case 7 -> bonus = 1.5;
        }

        if (totalHour > 40){
            bonus *= 1.5;
        }
        System.out.println("Total bonus: " + bonus);
        System.out.println("Total price: " + (pricePerHour * bonus) * totalHour);
    }
}

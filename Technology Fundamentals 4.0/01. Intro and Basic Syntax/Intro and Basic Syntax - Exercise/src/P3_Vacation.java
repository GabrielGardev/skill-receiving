import java.util.Scanner;

public class P3_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();

        double pricePerPerson = 0;

        switch (day) {
            case "Friday":
                switch (typeOfGroup) {
                    case "Students":
                        pricePerPerson = 8.45;
                        break;
                    case "Business":
                        pricePerPerson = 10.90;
                        break;
                    case "Regular":
                        pricePerPerson = 15;
                        break;
                }
                break;
            case "Saturday":
                switch (typeOfGroup) {
                    case "Students":
                        pricePerPerson = 9.80;
                        break;
                    case "Business":
                        pricePerPerson = 15.60;
                        break;
                    case "Regular":
                        pricePerPerson = 20;
                        break;
                }
                break;
            case "Sunday":
                switch (typeOfGroup) {
                    case "Students":
                        pricePerPerson = 10.46;
                        break;
                    case "Business":
                        pricePerPerson = 16;
                        break;
                    case "Regular":
                        pricePerPerson = 22.50;
                        break;
                }
                break;
        }

        double totalPrice = capacity * pricePerPerson;

        if (typeOfGroup.equals("Students") && capacity >= 30)
        {
            totalPrice = totalPrice - (totalPrice * 0.15);
        }
        else if (typeOfGroup.equals("Business") && capacity >= 100)
        {
            totalPrice = (capacity - 10) * pricePerPerson;
        }
        else if (typeOfGroup.equals("Regular") && capacity >= 10 && capacity <= 20)
        {
            totalPrice = totalPrice - (totalPrice * 0.05);
        }

        System.out.printf("Total price: %.2f", totalPrice);
}
}

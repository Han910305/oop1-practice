import java.util.Scanner;

public class temperature{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the Celsius degree: ");
        float number = input.nextInt();
        number = (number * 5 / 9) + 32;
        System.out.printf("The Fahrenheit degree is: %.2f" , number);
    }
}
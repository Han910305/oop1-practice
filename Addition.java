import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input integer1");
        int number1 = input.nextInt();
        System.out.print("input integer2");
        int number2 = input.nextInt(5);
        System.out.printf("the sum is: %d\n" , number1 + number2);
    }
}
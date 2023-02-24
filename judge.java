import java.util.Scanner;

public class judge{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("please enter the number: ");
        int number = input.nextInt();
        if(number % 2 == 0) {
            System.out.printf("該數字為偶數\n");
        }
        else{
            System.out.printf("該數字為奇數\n");
        }
    }
}
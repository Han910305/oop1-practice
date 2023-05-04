import java.util.Scanner;

public class A1103339_0421_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入您的電子信箱地址：");
        String email = scanner.nextLine();

        if (email.matches("[a-z]+@[a-z]+\\.(com|net|org|edu|gov|tw)")) {
            System.out.println("您輸入的電子信箱地址格式正確。");
        } else {
            System.out.println("您輸入的電子信箱地址格式不正確。");
        }
    }
}
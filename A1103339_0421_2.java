import java.util.Scanner;

public class  A1103339_0421_2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入日期(YYYY/MM/DD 或 MM/DD/YYYY)：");
        String input = scanner.nextLine();

        String[] parts = input.split("/");
        int year, month, day;

        if (parts.length == 3) {
            // 日期格式為 "YYYY/MM/DD"，例如：2023/05/05
            year = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            day = Integer.parseInt(parts[2]);
        } else {
            // 日期格式為 "MM/DD/YYYY"，例如：05/05/2023
            year = Integer.parseInt(parts[2]);
            month = Integer.parseInt(parts[0]);
            day = Integer.parseInt(parts[1]);
        }

        System.out.printf("您輸入的日期為：%d 年 %d 月 %d 日\n", year, month, day);
    }
}


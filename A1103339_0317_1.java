package A1103339_0317_1;
import java.util.Scanner;

public class A1103339_0317_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讓使用者輸入 n 和 m
        System.out.print("請輸入 n：");
        int n = scanner.nextInt();
        System.out.print("請輸入 m：");
        int m = scanner.nextInt();

        // 用二維陣列儲存產生 n*m 的值
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = i * m + j + 1;
            }
        }

        // 用二維陣列讀出 n*m 的值
        System.out.println("使用二維陣列讀出 n*m 的值：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // 用 for 迴圈儲存資料
        int[][] array2 = new int[n][m];
        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array2[i][j] = k++;
            }
        }

        // 用 for each 讀出陣列的資料
        System.out.println("使用 for each 讀出陣列的資料：");
        for (int[] row : array2) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

}
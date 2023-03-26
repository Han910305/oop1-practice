import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        animal a1 = new animal("雪寶", 1.1, 52, 100);
        animal a2 = new animal("驢子", 1.5, 99, 200);
        animal a3 = new animal("安娜", 1.7, 48, 120);
        animal a4 = new animal("愛沙", 1.7, 50, 120);
        animal[] animals = {a1, a2, a3, a4};
        
        for (animal a : animals) {
            a.show();
        }
        
        Scanner sc = new Scanner(System.in);
        for (animal a : animals) {
            System.out.println("請輸入" + a.getName() + "的x:");
            double x = sc.nextDouble();
            System.out.println("請輸入" + a.getName() + "的y(若不輸入則預設使用速度):");
            double y = sc.nextDouble();
            if (y == 0) {
                System.out.printf("%s的跑步距離為%.1f公尺\n", a.getName(), a.distance2(x));
            } else {
                System.out.printf("%s的跑步距離為%.1f公尺\n", a.getName(), a.distance1(x, y));
            }
        }
        
        sc.close();
    }

    
    

}

    
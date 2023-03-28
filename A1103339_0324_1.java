import java.util.Scanner;

class animal {
    private String name;
    private double height;
    private double weight;
    private double speed;
    
    public animal(String name, double height, double weight, double speed) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
    }
    
    public void show() {
        System.out.printf("%-8s%-8s%-8s%-8s\n", "項目姓名", "身高", "體重", "速度");
        System.out.printf("%-8s%-8.1f%-8.1f%-8.1f\n", name, height, weight, speed);
    }
    
    public double distance1(double x, double y) {
        return x * y;
    }
    
    public double distance2(double x) {
        return x * speed;
    }

    public Object getName() {
        return name;
    }

    
}

public class A1103339_0324_1 {
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

    
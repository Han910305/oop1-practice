public class animal {
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

import java.util.Scanner;

 class Animal {
    private String name;
    private double height;
    private double weight;
    private double speed;

    public Animal(String name, double height, double weight, double speed) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Speed: " + speed);
    }

    public double distance(double x, double y) {
        return x * y * speed;
    }

    public double distance(double x) {
        return x * speed;
    }

    public static void showInfo() {
        System.out.println("Welcome to the Animal System!");
    }

    public String getName() {
        return name;
    }
        
}

class GenderAnimal extends Animal {
    private String gender;

    public GenderAnimal(String name, double height, double weight, double speed, String gender) {
        super(name, height, weight, speed);
        this.gender = gender;
    }

    public void show() {
        super.show();
        System.out.println("Gender: " + gender);
    }
}

class Snow extends GenderAnimal {
    private String freezingAbility;

    public Snow(String name, double height, double weight, double speed, String gender, String freezingAbility) {
        super(name, height, weight, speed, gender);
        this.freezingAbility = freezingAbility;
    }

    public void show() {
        super.show();
        System.out.println("Freezing ability: " + freezingAbility);
    }

    public double distance(double x, double y) {
        return super.distance(x, y) * 2;
    }

    public double distance(double x) {
        return super.distance(x) * 2;
    }
}

public class A1103339_0331 {
    public static void main(String[] args) {
        Animal.showInfo();

        Animal[] animals = {
            new Animal("Snow baby", 1.1, 52, 100),
            new Animal("Donkey", 1.5, 99, 200),
            new GenderAnimal("Ark", 1.9, 80, 150, "Male"),
            new GenderAnimal("Hans", 1.8, 78, 130, "Male"),
            new GenderAnimal("Anna", 1.7, 48, 120, "Female"),
            new Snow("Elsa", 1.7, 50, 120, "Female", "Yes")
        };

        Scanner scanner = new Scanner(System.in);

        for (Animal animal : animals) {
            System.out.println("Enter the value of x:");
            double x = scanner.nextDouble();
            System.out.println("Enter the value of y (or enter 0 to use default value):");
            double y = scanner.nextDouble();
            if (y == 0) {
                System.out.println("Distance for " + animal.getClass().getSimpleName() + " " + animal.getName() + ": " + animal.distance(x));
            } else {
                System.out.println("Distance for " + animal.getClass().getSimpleName() + " " + animal.getName() + ": " + animal.distance(x, y));
            }
            System.out.println();
            animal.show();
            System.out.println();
        }
    }
}

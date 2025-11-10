package d.inheritance.practice01;

class Vehicle {
    String model;
    double dailyRate;

    public Vehicle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
    }

    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }
}

class Car extends Vehicle {
    boolean hasGPS;

    public Car(String model, double dailyRate, boolean hasGPS) {
        super(model, dailyRate);
        this.hasGPS = hasGPS;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = super.calculateRentalCost(days);
        if (hasGPS) {
            baseCost += days * 10000;
        }

        return baseCost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "hasGPS=" + hasGPS +
                ", model='" + model + '\'' +
                ", dailyRate=" + dailyRate +
                '}';
    }
}

class Truck extends Vehicle {
    double capacity;

    public Truck(String model, double dailyRate, double capacity) {
        super(model, dailyRate);
        this.capacity = capacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = super.calculateRentalCost(days);
        baseCost += capacity * 5000 * days;
        return baseCost;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                ", model='" + model + '\'' +
                ", dailyRate=" + dailyRate +
                '}';
    }
}


public class Practice03 {
    public static void main(String[] args) {
        Car car = new Car("소나타", 50000, true);
        Truck truck = new Truck("포터", 70000, 1.5);

        System.out.println(car);
        System.out.println("3일 대여료: " + car.calculateRentalCost(3) + "원");

        System.out.println(truck);
        System.out.println("5일 대여료: " + truck.calculateRentalCost(5) + "원");
    }
}

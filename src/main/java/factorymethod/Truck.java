package factorymethod.originalproblem;

public class Truck {

    private final String licensePlate;

    public Truck(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void deliver(String cargo, String destination) {
        System.out.println("[Truck " + licensePlate + "] Driving cargo '" + cargo + "' to " + destination + " by road.");
    }
}

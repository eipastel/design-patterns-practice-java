package factorymethod;

public class Truck implements Transport {

    private final String licensePlate;

    public Truck(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public void deliver(String cargo, String destination) {
        System.out.println("[Truck " + licensePlate + "] Driving cargo '" + cargo + "' to " + destination + " by road.");
    }
}

package factorymethod;

public class Ship implements Transport {

    private final String vesselName;

    public Ship(String vesselName) {
        this.vesselName = vesselName;
    }

    @Override
    public void deliver(String cargo, String destination) {
        System.out.println("[Ship " + vesselName + "] Sailing cargo '" + cargo + "' to " + destination + " via sea route.");
    }
}

package factorymethod.originalproblem;

public class Ship {

    private final String vesselName;

    public Ship(String vesselName) {
        this.vesselName = vesselName;
    }

    public void deliver(String cargo, String destination) {
        System.out.println("[Ship " + vesselName + "] Sailing cargo '" + cargo + "' to " + destination + " via sea route.");
    }
}

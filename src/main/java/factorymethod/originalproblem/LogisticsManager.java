package factorymethod.originalproblem;

// PROBLEM: This class knows about every concrete transport type.
// Each time a new transport is added (Ship, Airplane, Drone...),
// this method must be modified — violating the Open/Closed Principle.
// The if/else will keep growing, making the class harder to maintain,
// test in isolation, and extend from outside this codebase.
public class LogisticsManager {

    public void scheduleDelivery(String transportType, String cargo, String destination) {
        System.out.println("Scheduling delivery of '" + cargo + "' to " + destination + "...");

        if (transportType.equals("truck")) {
            Truck truck = new Truck("ABC-1234");
            truck.deliver(cargo, destination);
        } else if (transportType.equals("ship")) {
            Ship ship = new Ship("Ever Given");
            ship.deliver(cargo, destination);
        } else if (transportType.equals("airplane")) {
            // Added later — forced us to touch this class again
            Airplane airplane = new Airplane("LA-5050");
            airplane.deliver(cargo, destination);
        } else {
            throw new IllegalArgumentException("Unknown transport type: " + transportType);
        }

        System.out.println("Delivery scheduled.");
    }
}

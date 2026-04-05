package factorymethod.originalproblem;

public class Airplane {

    private final String flightNumber;

    public Airplane(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void deliver(String cargo, String destination) {
        System.out.println("[Airplane " + flightNumber + "] Flying cargo '" + cargo + "' to " + destination + " by air.");
    }
}

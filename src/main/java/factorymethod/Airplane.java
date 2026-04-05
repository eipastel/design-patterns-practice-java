package factorymethod;

public class Airplane implements Transport {

    private final String flightNumber;

    public Airplane(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public void deliver(String cargo, String destination) {
        System.out.println("[Airplane " + flightNumber + "] Flying cargo '" + cargo + "' to " + destination + " by air.");
    }
}

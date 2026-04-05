package factorymethod;

public class AirLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Airplane("LA-5050");
    }
}

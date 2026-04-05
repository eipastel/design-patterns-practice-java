package factorymethod;

import runner.DefaultPatternTesting;

public class FactoryMethodDemo implements DefaultPatternTesting {

    @Override
    public String getName() {
        return "Factory Method — Logistics Delivery System";
    }

    @Override
    public void execute() {
        Logistics road = new RoadLogistics();
        road.planDelivery("Construction Materials", "São Paulo");
        System.out.println();

        Logistics sea = new SeaLogistics();
        sea.planDelivery("Automobiles", "Hamburg");
        System.out.println();

        Logistics air = new AirLogistics();
        air.planDelivery("Medical Supplies", "Tokyo");
    }
}
